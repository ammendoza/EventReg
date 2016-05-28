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
	public List<Object[]> findDayCount (long eventId) {
		List<Object[]> list = null;
		
		Session session = null;
	    try {
	        session = openSession();

	        String sql = CustomSQLUtil.get(FIND_DAY_COUNT_BY_EVENT);

	        SQLQuery q = session.createSQLQuery(sql);
	        q.setCacheable(false);
	        
	        QueryPos qPos = QueryPos.getInstance(q);  
	        qPos.add(eventId);

	        list = (List<Object[]>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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

	public static final String FIND_DAY_COUNT =
		    AttendeeFinder.class.getName() +
		        ".findDayCount";
	
	public static final String FIND_DAY_COUNT_BY_EVENT =
		    AttendeeFinder.class.getName() +
		        ".findDayCountByEvent";

	
}