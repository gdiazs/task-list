package io.gdiazs.tasklist.exceptions;

/**
 * TaskServiceException
 */
public class TaskException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    TaskException(String msg, Throwable throwable){
        super(msg, throwable);
    }
}