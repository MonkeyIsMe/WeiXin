package com.csu.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.IntroductionDAO;
import com.csu.model.Introduction;
import com.csu.model.User;

@Transactional
public class IntroductionDAOImpl extends HibernateDaoSupport implements IntroductionDAO{

	public void addIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(introduction);
	}

	public void updateIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(introduction);
	}

	public void deleteIntroduction(Introduction introduction) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(introduction);
	}

	public Introduction queryIntroduction(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Introduction.class, id);
	}

	public List<Introduction> GetAllIntroduction() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Introduction>>() {

			public List<Introduction> doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "from Introduction";
				Query query = session.createQuery(hql);
				List<Introduction> result = null;
				result = query.list();
				return result;
			}
		});
	}

}
