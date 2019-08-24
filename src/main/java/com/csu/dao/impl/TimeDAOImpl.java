package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.TimeDAO;
import com.csu.model.Time;

@Transactional
public class TimeDAOImpl extends HibernateDaoSupport implements TimeDAO{

	public void addTime(Time time) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(time);
	}

	public void deleteTime(Time time) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(time);
	}

	public void UpdateTime(Time time) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(time);
	}

	public Time queryTime(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Time.class, id);
	}

	public List<Time> QueryAllTime(final int row, final int PageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Time>>() {

			public List<Time> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Time";
				Query query = session.createQuery(hql).setFirstResult(
                        (row - 1) * PageSize).setMaxResults(PageSize);
				List<Time> result = null;
				result = query.list();
				return result;
			}
		});
	}

}
