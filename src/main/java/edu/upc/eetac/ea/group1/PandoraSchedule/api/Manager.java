package edu.upc.eetac.ea.group1.PandoraSchedule.api;

import java.util.List;

import javax.security.auth.Subject;

import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Schedule;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Scheduledb;

public interface Manager {
	
	public Scheduledb getSchedule(int id);
	public List<Scheduledb> getSchedules(String arrayIDs);
	public int addSchedule(Schedule schedule);
	public int updateSchedule(int id, Schedule schedule);
	public int deleteSchedule(int id);
	

}
