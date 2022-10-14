package edu.met.banking;

//factory class for Account
public class Banker {

	private static long nid;

	//static initializer block is executed once after the class is
	//loaded by the JVM, used for initializing static fields
	static {
		nid = System.currentTimeMillis() % 1000000;
	}

	public static Account openCurrentAccount() {
		var acc = new CurrentAccount();
		acc.id = ++nid + 100000000;
		return acc;
	}

	public static Account openSavingsAccount() {
		var acc = new SavingsAccount();
		acc.id = ++nid + 200000000;
		return acc;
	}

	//a class which only defines static members does need instances
	//an such it should define a private constructor
	private Banker() {}
}

