package edu.met.banking;

//a class declared with final modifier cannot be sub-class
final class CurrentAccount extends Account {

	public void deposit(double amount) {
		if(balance < 0)
			amount *= 0.95;
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}
}

