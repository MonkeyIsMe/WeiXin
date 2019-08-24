package com.csu.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.csu.dao.PlanDAO;
import com.csu.model.Plan;
import com.csu.model.User;
import com.csu.po.AccessToken;
import com.csu.service.PlanService;
import com.csu.util.HibernateUtil;
import com.csu.util.WeixinUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WeixinTest {
	
	@Resource(name="PlanDAO")
	private PlanDAO pd;
	
	@Resource(name="PlanService")
	private PlanService ps;
	
	@Resource(name="sessionFactory")
	private  SessionFactory sf;
	
	
	@Test
	public void QueryAllPlan() {
		Plan pan = pd.queryPlan(1);
		
		List<Plan> PlanList = ps.GetAllPlan();
		for(Plan plan : PlanList) {
			System.out.println(plan.toString());
		}
	}
}
