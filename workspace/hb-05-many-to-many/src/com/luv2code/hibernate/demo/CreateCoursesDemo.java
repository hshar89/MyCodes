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

public class CreateCoursesDemo {

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
			
			Course course1 = new Course("Aerodynamics");
			Course course2 = new Course("The pinball masterclass");
			Course course3 = new Course("Civil Engg");
			// Associate the objects
			ins.addCourse(course1);
			ins.addCourse(course2);
			ins.addCourse(course3);

			// save the object
			// It will save the instructor object also
			// due to cascading effect
			System.out.println("Saving Courses...");
			session.save(course1);
			session.save(course2);
			session.save(course3);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
