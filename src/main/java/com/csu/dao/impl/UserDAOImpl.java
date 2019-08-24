package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.UserDAO;
import com.csu.model.User;

@Transactional
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{

	public void addUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	public User queryUser(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(User.class, id);
	}

	public List<User> GetAllUser() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from User";
				Query query = session.createQuery(hql);
				List<User> result = null;
				result = query.list();
				return result;
			}
		});
	}

	public List<User> QueryUserByNumber(final String UserNumber) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from User where user_number = ?";
				Query query = session.createQuery(hql);
				List<User> result = null;
				result = query.list();
				query.setParameter(0, UserNumber);
				return result;
			}
		});
	}

	public List<User> GetAllUserByPageSize(final int row, final int PageSize) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			public List<User> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from User";
				Query query = session.createQuery(hql).setFirstResult(
                        (row - 1) * PageSize).setMaxResults(PageSize);;
				List<User> result = null;
				result = query.list();
				return result;
			}
		});
	}

	public int CountUser() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from User as User";
		return ((Long)getHibernateTemplate().iterate(hql).next()).intValue();
	}

}
