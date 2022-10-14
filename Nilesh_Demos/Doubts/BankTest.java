class BankTest{
		public static void main(String[] args){
			bank.Finance bn = new bank.Finance();
			double interest = bn.interest(10000, 10, 3);

			System.out.printf("Calculated Interest is %f%n", interest);

		}
}
