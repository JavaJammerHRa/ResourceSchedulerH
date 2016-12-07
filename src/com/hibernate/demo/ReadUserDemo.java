package com.hibernate.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ReourceEntity.Reservation;
import com.ReourceEntity.Resource;
import com.ReourceEntity.User;


public class ReadUserDemo {
	
public static void main(String[] args) {
	

	//create session factory
	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Reservation.class)
			.addAnnotatedClass(Resource.class)
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	Session session = factory.getCurrentSession();
//    //Get the current date
//    LocalDate today = LocalDate.now();
//    System.out.println("Current date: " + today);
//    Date d = new SimpleDateFormat("YYYY-MM-dd").parse(today.toString());
//    System.out.println(d);

	
    try{
    	Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        LocalDate today = LocalDate.now();
    	DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
    	Date d1 = df.parse("2016-12-07"); // for example, today's date
    	System.out.println("DATE IS: "+d1);
    	

        System.out.println("Current date: " + today);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(today.toString());
        System.out.println(d);
        
        DateFormat newd = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(newd.format(date));
		//create a user object
		System.out.println("Creating new resource object...");
		Reservation tempRes = new Reservation(1,d1,23);
		
		//start transaction
		session.beginTransaction();
		
		//save the user
		System.out.println("savng the resource object...");
		System.out.println(tempRes);
		session.save(tempRes);
		
		//commit the transaction 
		session.getTransaction().commit();
		
		//find reservation ID
		System.out.println("Saved reservation ID:"+ tempRes.getReversationId());
		
		//get new session and start transaction 
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		//retrieve reservation based on id: primary key
		System.out.println("\nGetting Reservation with id: "+ tempRes.getReversationId());
		Reservation newRes = session.get(Reservation.class, tempRes.getReversationId());
		System.out.println("Get complete: "+ newRes);
		
		//commit transaction 
		session.getTransaction().commit();
		
		System.out.println("Done!");
    }catch (ParseException e){
    	e.printStackTrace();
    	}
	 finally{
			System.out.println("Done!");
		factory.close();
	}
}

//public SessionFactory sessionFact(c){
//	//create session factory
//	SessionFactory factory = new Configuration()
//			.configure("hibernate.cfg.xml")
//			.addAnnotatedClass(c.class)
//			.buildSessionFactory();
//	
//	Session session = factory.getCurrentSession();
//}

}
