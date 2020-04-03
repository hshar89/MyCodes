package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the object
			System.out.println("Creating a new student object");
			session.beginTransaction();
			int id = 1;
			
			Instructor ins = session.get(Instructor.class, id);
			
			System.out.println("luv2Code: Instructor:"+ ins);

			System.out.println("luv2Code: Instructor courses: "+ins.getCourses());
			// commit the transaction
			session.getTransaction().commit();
			session.close();
			System.out.println("luv2code: Session is now closed\n");
			System.out.println("luv2Code: Instructor courses: "+ins.getCourses());
			System.out.println("luv2Code: Done");
		} finally {
			factory.close();
		}
	}
}
