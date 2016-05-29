package edu.uoc.eventreg.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import edu.uoc.eventreg.model.Event;

public class EventFinderImpl extends BasePersistenceImpl<Event> implements EventFinder {
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findDayCount (long companyId, long groupId) {
		List<Object[]> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_DAY_COUNT);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(companyId);
	        qPos.add(groupId);
	        
	        list = (List<Object[]>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	        closeSession(session);
	    }
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public long findAvailableSeats (long eventId) {
		List<Long> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_DAY_COUNT);

	        SQLQuery q = session.createSQLQuery(sql).addScalar("seats", Type.LONG);
	        q.setCacheable(false);
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(eventId);
	        qPos.add(eventId);
	        
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
	
	public static final String FIND_DAY_COUNT =
		    EventFinder.class.getName() +
		        ".findDayCount";
	
	public static final String FIND_AVAILABLE_SEATS =
		    EventFinder.class.getName() +
		        ".findAvailableSeats";

}