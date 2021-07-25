package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class BreakingTheApplicationSolution2 {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			int id = 1;
			session.beginTransaction();

			System.out.println("--- Creating instructor");
			// using HQL to make eager fetch, even when mapping by lazy load.
			Query<Instructor> query = session
					.createQuery("select i from Instructor i "
								+ "JOIN FETCH i.courses "
								+ "where i.id =:instructorId", Instructor.class);
			query.setParameter("instructorId", id);
			
			System.out.println("--- Querying instructor");
			Instructor instructor = query.getSingleResult();
			
			System.out.println("--- " + instructor);
			
			session.getTransaction().commit();
			sessionFactory.close();
			
			// this will work now
			System.out.println("--- courses" + instructor.getCourses());

			System.out.println(" --- Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
