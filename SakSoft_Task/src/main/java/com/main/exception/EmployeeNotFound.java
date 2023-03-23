package com.main.exception;

public class EmployeeNotFound extends Exception
{
public EmployeeNotFound(int id) {
	super("could not found with id "+id);
}
}
