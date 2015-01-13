package edu.upc.eetac.ea.group1.PandoraSchedule.api.model;

public class ScheduleError {
	private int status;
	private String message;

	public ScheduleError() {
		super();
	}

	public ScheduleError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}