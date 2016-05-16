package edu.uoc.eventreg.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import edu.uoc.eventreg.model.Attendee;
import edu.uoc.eventreg.model.impl.AttendeeImpl;

public class AttendeeFinderImpl extends BasePersistenceImpl<Attendee> implements AttendeeFinder {
	
	@SuppressWarnings("unchecked")
	public List<Attendee> findByEvent (long eventId) {
		List<Attendee> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_BY_EVENT);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        q.addEntity("REGEVENT_Attendee", AttendeeImpl.class);

	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(eventId);

	        list = (List<Attendee>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }
		
		return list;
	}
	
	public static final String FIND_BY_EVENT =
		    AttendeeFinder.class.getName() +
		        ".findByEvent";

}