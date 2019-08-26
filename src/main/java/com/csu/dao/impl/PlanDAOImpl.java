package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.PlanDAO;
import com.csu.model.Plan;


@Transactional
public class PlanDAOImpl extends HibernateDaoSupport implements PlanDAO{

	public void addPlan(Plan plan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(plan);
	}

	public void deletePlan(Plan plan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(plan);
	}

	public void updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(plan);
	}

	public Plan queryPlan(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Plan.class, id);
	}

	public List<Plan> GetAllPlan() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Plan>>() {

			public List<Plan> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Plan";
				Query query = session.createQuery(hql);
				List<Plan> result = null;
				result = query.list();
				return result;
			}
		});
	}

	public List<Plan> GetAllPlanByPageSize(final int row,final int PageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Plan>>() {

			public List<Plan> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Plan";
				Query query = session.createQuery(hql).setFirstResult(
                        (row - 1) * PageSize).setMaxResults(PageSize);
				List<Plan> result = null;
				result = query.list();
				return result;
			}
		});
	}

	public int CountPlan() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Plan as Plan";
		return ((Long)getHibernateTemplate().iterate(hql).next()).intValue();
	}

	public List<Plan> GetByTimeAndCompanyPlan(final String time_name, final String company_name) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Plan>>() {

			public List<Plan> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Plan where time_name = ? and company_name = ?";
				Query query = session.createQuery(hql);
				List<Plan> result = null;
				result = query.list();
				query.setParameter(0, time_name);
				query.setParameter(1, company_name);
				return result;
			}
		});
	}

}
