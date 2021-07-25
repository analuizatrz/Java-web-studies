package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		System.out.println("começando");
		SessionFactory sessionFactory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		System.out.println("criada a factory");
		Session session = sessionFactory.getCurrentSession();
		try {
			System.out.println("Creating new student");
			Student student = new Student("Luna", "Lovegood", "luna@email.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Student saved ! "+ student.getId());
			
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Getting student ! "+ student.getId());
			Student readedStudent = session.get(Student.class, student.getId());
			System.out.println("Student: "+ readedStudent.toString());
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
