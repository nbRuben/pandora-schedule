package edu.upc.eetac.ea.group1.PandoraSchedule.api;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Schedule;
import edu.upc.eetac.ea.group1.PandoraSchedule.api.model.Scheduledb;


@Path("/schedule")
public class ScheduleResource {
	
	private DBOperations dbo =  DBOperations.getInstance();

	@GET
    @Path ("/{id}")
    public Scheduledb getSchedule(@PathParam("id") int id ) {	
    	 
    	Scheduledb s = dbo.getSchedule(id);
        return s;
        
    }
	
	@POST
	@Consumes(MediaType.EA_PANDORA_SCHEDULE)
	public int addSchedule(Schedule schedule){
		
		int success = dbo.addSchedule(schedule);
		return success;
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes (MediaType.EA_PANDORA_SCHEDULE)
	public int updateSchedule(@PathParam("id") int id, Schedule schedule){
		
		int success = dbo.updateSchedule(id, schedule);
		return success;
		
	}
	
	@DELETE
	@Path ("/{id}")
	public int deleteSchedule(@PathParam("id") int id){
		
		int success = dbo.deleteSchedule(id);
		return success;
		
	}
	
	
}
