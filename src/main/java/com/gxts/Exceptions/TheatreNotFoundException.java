package com.gxts.Exceptions;
/*When admin tries to add a schedule to the theatre that does not exists in the thetare table then 
 * throw the TheatreNotFoundException*/

public class TheatreNotFoundException extends RuntimeException {

	public TheatreNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
