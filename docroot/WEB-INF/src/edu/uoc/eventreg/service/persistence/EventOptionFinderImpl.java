package edu.uoc.eventreg.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import edu.uoc.eventreg.model.EventOption;

public class EventOptionFinderImpl extends BasePersistenceImpl<EventOption> implements EventOptionFinder {
	
	@SuppressWarnings("unchecked")
	public long findAvailableSeats (long eventOptionId) {
		List<Long> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_AVAILABLE_SEATS);

	        SQLQuery q = session.createSQLQuery(sql).addScalar("seats", Type.LONG);
	        q.setCacheable(false);
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(eventOptionId);
	        
	        list = (List<Long>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }

	    if (list != null)
	    	return list.get(0);
	    else
	    	return 0;
	}
	
	public static final String FIND_AVAILABLE_SEATS =
		    EventOptionFinder.class.getName() +
		        ".findAvailableSeats";

}