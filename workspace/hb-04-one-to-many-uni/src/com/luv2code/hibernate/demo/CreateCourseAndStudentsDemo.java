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

public class CreateCourseAndStudentsDemo {

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
			
			//create a course
			Course c = new Course("PACMAN- how to score");
			session.save(c);
			System.out.println("Saved the course..."+c);
			Student st1 = new Student("Frosty","Ice","erp@gmail.com");
			Student st2 = new Student("Mary","Poppins","Mary@gmail.com");
			
			c.addStudent(st1);
			c.addStudent(st2);
			
			
			
			//save the course .. and leverage the cascade all
			System.out.println("Saving the student...");
			
			session.save(st1);
			session.save(st2);
			
			System.out.println("Saved students..."+c.getStudents());
			
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
