package edu.upc.eetac.ea.group1.PandoraSchedule.api.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schedule")
public class Schedule {
	
	public int id;
	public String subject;
	public String days;
	public String time;
	public String teachers;
	public String groups;
	
	public Schedule (){
		super();
	}
	
	public Schedule (String subject, String days, String time, String teachers, String groups){
		super();
		this.subject = subject;
		this.days = days;
		this.time = time;
		this.teachers = teachers;
		this.groups = groups;
	}
	public Schedule (int id,String subject, String days, String time, String teachers, String groups){
		super();
		this.id = id;
		this.subject = subject;
		this.days = days;
		this.time = time;
		this.teachers = teachers;
		this.groups = groups;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "subject", unique = true, nullable = false)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Column(name = "days", nullable = false)
	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	@Column(name = "time", nullable = false)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "teachers", nullable = false)
	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}
	
	@Column(name = "groups", nullable = false)
	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}
	
}
