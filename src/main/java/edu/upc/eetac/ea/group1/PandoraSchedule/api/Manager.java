package edu.upc.eetac.ea.group1.PandoraSchedule.api;

import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Schedule;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Scheduledb;

public interface Manager {
	
	public Scheduledb getSchedule(int id);
	public int addSchedule(Schedule schedule);
	public int updateSchedule(int id, Schedule schedule);
	public int deleteSchedule(int id);

}
