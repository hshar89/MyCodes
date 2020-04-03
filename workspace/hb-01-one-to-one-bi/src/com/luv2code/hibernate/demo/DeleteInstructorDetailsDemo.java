package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the object
			System.out.println("Creating a new student object");
			session.beginTransaction();
			int id= 6;
			InstructorDetail insD = session.get(InstructorDetail.class, id);
			
			System.out.println("Found instructor..."+insD);
			
			if(insD!=null) {
				System.out.println("Finding Instructor....");
				
				//ALso delete the child due to cascade type ALL
				
				//break the bi directional link
				//remove the associated object reference
				insD.getInstructor().setInstructorDetail(null);
				session.delete(insD);
			}

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
		}
	}
}
