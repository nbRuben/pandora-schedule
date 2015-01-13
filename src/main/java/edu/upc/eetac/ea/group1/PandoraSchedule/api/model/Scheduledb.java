package edu.upc.eetac.ea.group1.PandoraSchedule.api.model;

import java.util.ArrayList;
import java.util.List;

public class Scheduledb {
	
	public int id;
	public String subject;
	public List<Group> groups;
	
	public Scheduledb (){
		super();
		this.groups = new ArrayList<Group>();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	
	

}
