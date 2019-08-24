package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.RoleDAO;
import com.csu.model.Role;
import com.csu.model.Time;

@Transactional
public class RoleDAOImpl extends HibernateDaoSupport implements RoleDAO{

	public void addRole(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(role);
	}

	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(role);
	}

	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(role);
	}

	public Role queryRole(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Role.class, id);
	}

	public List<Role> QueryAllRole(final int row, final int PageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Role>>() {

			public List<Role> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Role";
				Query query = session.createQuery(hql).setFirstResult(
                        (row - 1) * PageSize).setMaxResults(PageSize);
				List<Role> result = null;
				result = query.list();
				return result;
			}
		});
	}

}
