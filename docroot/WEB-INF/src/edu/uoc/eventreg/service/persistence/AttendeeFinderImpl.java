package edu.uoc.eventreg.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

import edu.uoc.eventreg.model.Attendee;

public class AttendeeFinderImpl extends AttendeePersistenceImpl {
	
	public List<Attendee> findByEvent (long eventId) {
		List<Attendee> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_BY_EVENT);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("Attendee", Attendee.class);

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(eventId);

	        list = (List<Attendee>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	    } catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }
		
		return list;
	}
	
	public static final String FIND_BY_EVENT =
		    Attendee.class.getName() +
		        ".findByEvent";

}