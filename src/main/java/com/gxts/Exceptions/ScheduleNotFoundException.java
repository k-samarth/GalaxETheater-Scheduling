package com.gxts.Exceptions;

/*When admin tries to search for the Schedule that does not exists in the database then we have to throw
 * ScheduleNotFoundException*/

public class ScheduleNotFoundException extends RuntimeException {

	public ScheduleNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public ScheduleNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ScheduleNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ScheduleNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ScheduleNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
