package edu.upc.eetac.ea.group1.PandoraSchedule.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Day;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Group;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Schedule;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Scheduledb;

@SuppressWarnings("serial")
public class DBOperations implements Manager, Serializable {
	
	private static DBOperations instance = null;
	private AnnotationConfiguration config;
	private SessionFactory factory;

	public static DBOperations getInstance() {
		if (instance == null) {
			instance = new DBOperations();
		}
		return instance;
	}

	private DBOperations() {
		super();
		config = new AnnotationConfiguration();
		config.addAnnotatedClass(Schedule.class);
		config.configure();
		factory = config.buildSessionFactory();

	}

	@Override
	public Scheduledb getSchedule(int id) {
		// TODO Auto-generated method stub
		Session sesion = factory.openSession();
		SQLQuery query = sesion
				.createSQLQuery("SELECT * FROM schedule WHERE id = :id");
		query.addEntity(Schedule.class);
		query.setInteger("id", id);
		sesion.beginTransaction();
		Scheduledb s = new Scheduledb();
		Schedule scheduleQuery = (Schedule) query.uniqueResult();

		if (scheduleQuery == null)
			throw new NotFoundException("Schedule with identifier " + id + " not found");
		else {
			sesion.getTransaction().commit();
			
			String subject = scheduleQuery.getSubject();
			String days = scheduleQuery.getDays();
			String time = scheduleQuery.getTime();
			String teachers = scheduleQuery.getTeachers();
			String groups = scheduleQuery.getGroups();

			Iterator<String> it;
			List<String> groupsSplitted = Arrays.asList(groups.split("&"));
			it = groupsSplitted.iterator();
			int i = 0;
			List<Group> groupsSubject = new ArrayList<Group>();
			List<Day> dayGroup = new ArrayList<Day>();
			while(it.hasNext()){
				Group g = new Group();
				Day d = new Day();
				g.setGroup(it.next());
				List<String> daysSplitted = Arrays.asList(days.split("&"));
				List<String> daysSplitted2 = Arrays.asList(daysSplitted.get(i).split(","));
				d.setDay(daysSplitted2.get(i));
				//g.setDays(Arrays.asList(daysSplitted.get(i).split(",")));
				List<String> teachersSplitted = Arrays.asList(teachers.split("&"));
				g.setTeacher(teachersSplitted.get(i));
				List<String> timeSplitted = Arrays.asList(time.split("&"));
				List<String> timeSplitted2 = Arrays.asList(timeSplitted.get(i).split(","));
				d.setTime(timeSplitted2.get(i));
				dayGroup.add(d);
				g.setDays(dayGroup);
				//g.setTime(Arrays.asList(timeSplitted.get(i).split(",")));
				groupsSubject.add(g);
				i++;
			}
			
			System.out.println(groupsSubject);

			s.setId(id);
			s.setSubject(subject);
			s.setGroups(groupsSubject);

		}
		return s;
	}

	@Override
	public int addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub

		try{
			SessionFactory factory = config.buildSessionFactory();
			Session sesion = factory.getCurrentSession();
			sesion.beginTransaction();	
			sesion.save(schedule);
			sesion.getTransaction().commit();
			return 1;
		}catch (Exception e){
			return 0;
		}
		
	}

	@Override
	public int updateSchedule(int id, Schedule schedule) {
		// TODO Auto-generated method stub
		Session sesion = factory.openSession();
		sesion.beginTransaction();
		SQLQuery query = sesion.createSQLQuery("update schedule set id = ifnull(:id, id), subject = ifnull(:subject, subject), days = ifnull(:days, days), time = ifnull(:time, time), teachers = ifnull(:teachers, teachers), groups = ifnull(:groups, groups) where id = :id");
		query.addEntity(Schedule.class);
		
		String subject = schedule.getSubject();
		String days = schedule.getDays();
		String time = schedule.getTime();
		String teachers = schedule.getTeachers();
		String groups = schedule.getGroups();
		
		query.setInteger("id", id);
		query.setString("subject", subject);
		query.setString("days", days);
		query.setString("time", time);
		query.setString("teachers", teachers);
		query.setString("groups", groups);

		try{
			int scheduleQuery = query.executeUpdate();
			sesion.getTransaction().commit();
			sesion.close();	
			if (scheduleQuery == 1)
				 return 1;
			else
				throw new NotFoundException ("Schedule with id " + id + " not found");
					
		}catch (Exception e){
			return 0;
		}
		
	}

	@Override
	public int deleteSchedule(int id) {
		// TODO Auto-generated method stub

		try{
		 Session session = factory.openSession();
		 session.beginTransaction();

		 Schedule s = (Schedule)session.get(Schedule.class, new Integer(id));
		 
		 session.delete(s);
		 session.getTransaction().commit();
		 session.close();
		 	return 1;
		}catch (Exception e){
			return 0;
		}
		 
	}

}
