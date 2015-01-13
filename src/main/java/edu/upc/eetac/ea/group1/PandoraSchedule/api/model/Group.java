package edu.upc.eetac.ea.group1.PandoraSchedule.api.model;

import java.util.List;

public class Group {
	
	public String group;
	public String teacher;
	public List<Day> days;
	//public List<String> time;
	
	public Group(){
		
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<Day> getDays() {
		return days;
	}
	public void setDays(List<Day> days) {
		this.days = days;
	}
	/*public List<String> getTime() {
		return time;
	}
	public void setTime(List<String> time) {
		this.time = time;
	}*/
	
}
