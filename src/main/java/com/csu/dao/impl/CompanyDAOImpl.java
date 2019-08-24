package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.CompanyDAO;
import com.csu.model.Company;
import com.csu.model.Introduction;

@Transactional
public class CompanyDAOImpl extends HibernateDaoSupport implements CompanyDAO{

	public void addCompany(Company company) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(company);
	}

	public void updateCompany(Company company) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(company);
	}

	public void deleteCompany(Company company) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(company);
	}

	public Company queryCompany(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Company.class, id);
	}

	public List<Company> QueryAllCompany(final int row, final int PageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Company>>() {

			public List<Company> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Company";
				Query query = session.createQuery(hql).setFirstResult(
                        (row - 1) * PageSize).setMaxResults(PageSize);
				List<Company> result = null;
				result = query.list();
				return result;
			}
		});
	}

}
