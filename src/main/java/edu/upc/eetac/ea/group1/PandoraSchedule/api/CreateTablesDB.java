package edu.upc.eetac.ea.group1.PandoraSchedule.api;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Schedule;

public class CreateTablesDB {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Schedule.class);
		config.configure();
		
		new SchemaExport (config).create(true,true);
		
		//Hibernate session
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("Tables created");	
		
		//Añadiendo los valores iniciales
		Schedule s = new Schedule("CESA", "Lunes,Miercoles&Martes,Viernes", "11:00-13:00,10:00-12:30&15:00-17:30,16:30-19:30", "Oscar&Gasulla", "4GM11&4GT21");
		session.save(s);
		s = new Schedule("FC", "Lunes,Jueves&Martes,Jueves", "9:00-12:00,10:00-12:30&15:00-18:30,16:30-19:00", "Juan&Elotro", "3GM11&3GT21");
		session.save(s);
		
		//Confirmamos lo que añadimos.
		session.getTransaction().commit();
		System.out.println("Base de Datos inicializada.");
	}

}
