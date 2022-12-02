package com.gxts.Exceptions;

/*When an admin tries to insert the already exists schedule in the table then 
 we have to throw ScheduleAlreadyExistsException*/

public class ScheduleAlreadyExistsException extends RuntimeException {

	public ScheduleAlreadyExistsException() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ScheduleAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ScheduleAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ScheduleAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
