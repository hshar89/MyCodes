package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			//Hibernate query with HQL
			int instructorid = 1;
			
			Query<Instructor> query= session.createQuery("select i from Instructor i"+
					                       " JOIN FETCH i.courses where i.id=:instructorid",
					                        Instructor.class);
			query.setParameter("instructorid", instructorid);
			
			//execute query and get instructor
			
			Instructor ins = query.getSingleResult();
			
			System.out.println("luv2Code: Instructor:"+ ins);

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
