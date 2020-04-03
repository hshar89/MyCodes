package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForStudentsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the object
			System.out.println("Creating a new student object");
			session.beginTransaction();
			
			int id = 1;
			Student st = session.get(Student.class, id);
			
			System.out.println("Loaded student..."+st);
			System.out.println("Courses assigned to student..."+st.getCourses());
			
			//create more courses
			Course c1 = new Course("Thermodynamics- how to expand");
			Course c2 = new Course("How to fix tyres");
			
			c1.addStudent(st);
			c2.addStudent(st);
			
			System.out.println("Saving the course...");
			
			session.save(c1);
			session.save(c2);
			
			//System.out.println("Courses for the student..."+st.getCourses());
		
			
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
