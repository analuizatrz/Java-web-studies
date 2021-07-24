package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Granger'").getResultList();
			System.out.println("\nLast name Granger");
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName = 'Granger' OR s.firstName='Harry'").getResultList();
			System.out.println("\nLast name Granger or first name Harry");
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.email LIKE '%@email.com'").getResultList();
			System.out.println("\nLast name Granger or first name Harry");
			displayStudents(students);
			
			session.getTransaction().commit();
			System.out.println("Done");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student student:students) {
			System.out.println(student);
		}
	}
}
