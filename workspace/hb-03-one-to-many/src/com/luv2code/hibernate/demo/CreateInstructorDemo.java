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

public class CreateInstructorDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the object
			System.out.println("Creating a new instructor object");
			
			Instructor ins = new Instructor("Dan", "Bilzerian", "Screw@luv2Screw.com");

			InstructorDetail insD = new InstructorDetail("http://www.pokerStar.com/youtube", "Gamer");
			
			Course course = new Course("Gambling");
			// Associate the objects
			ins.setInstructorDetail(insD);

			// start a transaction
			session.beginTransaction();

			// save the object
			// It will save the instructor object also
			// due to cascading effect
			System.out.println("Saving Instructor....");
			session.save(ins);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
