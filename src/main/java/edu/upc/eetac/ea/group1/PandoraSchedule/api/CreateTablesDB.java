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
		Schedule s = new Schedule(9,"Circuits Electronics i Sistemes de Alimentació", "Lunes,Miercoles&Martes,Viernes", "11:00-13:00,10:00-12:30&15:00-17:30,16:30-19:30", "Oscar&Gasulla", "4GM11&4GT21");
		session.save(s);
		s = new Schedule(10,"Fonaments de la Comunicació", "Lunes,Jueves&Martes,Jueves", "9:00-12:00,10:00-12:30&15:00-18:30,16:30-19:00", "Juan&Elotro", "3GM11&3GT21");
		session.save(s);
		s = new Schedule(4,"Xarxes Locals, d'Access i Metropolitanes", "Lunes,Martes", "08:00-11:00,08:00-10:00", "Lluis Casals,Joan Mataix", "5GM2");
		session.save(s);
		s = new Schedule(5,"Disseny d'Aplicacions", "Lunes,Miercoles,Viernes", "11:00-14:00,12:00-14:00,08:00-11:00", "Sergio Machado,Roc Meseguer", "5GM2");
		session.save(s);
		s = new Schedule(6,"Serveis Audivisuals sobre Internet", "Miercoles,Jueves", "08:00-12:00,11:00-14:00", "David Rincón", "5GM2");
		session.save(s);
		s = new Schedule(11,"Movilitat de Xarxes i Serveis", "Martes,Jueves", "12:00-14:00,11:00-14:00", "Carles Gómez,Enrica Zola", "5GM2");
		session.save(s);		
		s = new Schedule(7,"Anàlisis i Dimensionament de Xarxes", "Jueves,Viernes", "11:00-12:30,11:00-14:00", "Ramon Piney", "5GM2");
		session.save(s);
		s = new Schedule(12,"Infraestructura i Organitzacions de les Telecomunicacions", "Lunes,Miercoles", "15:00-17:30,15:00-17:30", "Francesca Torrell,David Rincón", "6GT2");
		session.save(s);
		s = new Schedule(1,"Enginyeria de Aplicacions", "Lunes,Martes,Miercoles,Viernes", "17:30-20:30,15:00-19:00,19:30-20:30,17:00-20:00", "Antonia Gallardo,Toni Oller", "6GT2");
		session.save(s);
		s = new Schedule(2,"Planificació de Xarxes", "Martes,Miercoles", "19:00-21:00,17:30-19:30", "Sebastià Sallent,David Rincón", "6GT2");
		session.save(s);
		s = new Schedule(3,"Seguretat en Xarxes","Jueves,Viernes","15:00-16:30,15:00-17:00","Olga León,Juan Hernandez","6GT2");
		session.save(s);
		s = new Schedule(8,"Xarxes de Transport", "Jueves", "16:30-21:00", "Cristina Cervelló", "6GT2");
		session.save(s);
			
		
		//Confirmamos lo que añadimos.
		session.getTransaction().commit();
		System.out.println("Base de Datos inicializada.");
	}

}
