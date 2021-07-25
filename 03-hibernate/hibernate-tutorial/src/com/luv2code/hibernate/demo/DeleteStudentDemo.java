package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
												.configure("hibernate.cfg.xml")
												.addAnnotatedClass(Student.class)
												.buildSessionFactory();

		System.out.println("criada a factory");
		try {
			int studentId = 5;

			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Deleting student with id" + studentId);
			Student student = session.get(Student.class, studentId);
			
			session.delete(student);

			session.getTransaction().commit();			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Deleting id 6");
			
			
			session.createQuery("delete from Student where id = 6").executeUpdate();

			session.getTransaction().commit();
			
			
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
