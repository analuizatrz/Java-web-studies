package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForHermioneDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("Creating instructor");
			int id = 2;
			session.beginTransaction();
			
			Student hermione = session.get(Student.class, id);
			
			System.out.println("Loaded student :"+hermione);
			
			Course machineLearning = new Course("Machine learning");
			Course operatingSystems = new Course("Operating Systems");
			Course calculus = new Course("Calculus 1");
			
			System.out.println("saving courses");
			machineLearning.add(hermione);
			operatingSystems.add(hermione);
			calculus.add(hermione);
			
			session.save(machineLearning);
			session.save(operatingSystems);
			session.save(calculus);
			System.out.println("courses saved");
			
			System.out.println("Saved students: " + hermione.getCourses());
			session.getTransaction().commit();
			
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sessionFactory.close();
			
		}
	}
}
