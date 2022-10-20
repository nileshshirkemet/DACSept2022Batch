class Program {

	public static void main(String[] args) throws Exception {
		var acc = new JointAccount();
		acc.deposit(5000);
		System.out.println("Account opened for Jack and Jill.");
		System.out.printf("Initial Balance = %d%n", acc.balance());
		var child = new Thread(() -> {
			System.out.println("Jack is withdrawing 3000...");
			if(acc.withdraw(3000) == false)
				System.out.println("Jack's withdraw operation failed!");
		});
		child.start();
		System.out.println("Jill is withdrawing 4000...");
		if(acc.withdraw(4000) == false)
			System.out.println("Jill's withdraw operation failed!");
		child.join(); //current thread waits for child to exit
		System.out.printf("Final Balance   = %d%n", acc.balance());
	}

	static class JointAccount {
		
		private int balance;

		public int balance() { return balance; }

		public synchronized void deposit(int amount) {
			balance = Worker.doWork(amount, balance, 1);
			//notify the monitor of this object to allow any one
			//thread waiting on it to resume execution
			this.notify();
		}

		public boolean withdraw(int amount) {
			boolean success = false;
			//A thread can enter a synchronized block by locking the built-in
			//monitor of 'this' object. Only one thread can lock the monitor
			//of a given object at a time while other threads must wait for
			//this thread to unlock the monitor by exiting synchronized block
			synchronized(this){
				if(balance >= amount){
					balance = Worker.doWork(amount, balance, -1);
					success = true;
				}
			}
			return success;
		}

		public synchronized boolean withdrawAfterDeposit(int amount) throws InterruptedException {
			//unlock the monitor of 'this' and wait for some other
			//thread to notify this monitor
			this.wait();
			return withdraw(amount);
		}
	}
}

