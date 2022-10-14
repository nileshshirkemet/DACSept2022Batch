package edu.met.banking;

//a class declared with abstract modifier cannot be instantiated
public abstract class Account {

	long id;
	protected double balance;

	public long getId() { return id; }

	public double getBalance() { return balance; }

	//a method declared with abstract modifier must be
	//overridden in a sub-class to support instantiation
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount) throws InsufficientFundsException;

	//a method declared with final modifier cannot be overridden
	//in a sub-class (JVM can skip dynamic binding for such method)
	public final void transfer(double amount, Account that) throws InsufficientFundsException {
		if(this == that)
			throw new IllegalTransferException();
		this.withdraw(amount);
		that.deposit(amount);
	}
}

