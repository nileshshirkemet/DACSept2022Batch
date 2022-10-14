package edu.met.banking;

/*
	A checked exception that does not inherit from 
	java.lang.RuntimeException cannot go unreported
	an as such it can only occur in the scope of a
	(1) try block with a catch block for that exception type
	(2) method with throws clause specifying that exception type
*/
public class InsufficientFundsException extends Exception {}

