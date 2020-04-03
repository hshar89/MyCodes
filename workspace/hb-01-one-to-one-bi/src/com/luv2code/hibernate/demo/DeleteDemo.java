package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			// create the object
			System.out.println("Creating a new student object");
			session.beginTransaction();
			int id= 3;
			Instructor ins = session.get(Instructor.class, id);
			
			System.out.println("Found instructor..."+ins);
			
			if(ins!=null) {
				System.out.println("Deleting Instructor....");
				//ALso delete the child due to cascade type ALL
				session.delete(ins);
			}

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}
}
