class FirstProgram{
	public static int Sum(int a, int b){
		return a + b;
	}
    public static void main(String[] args){
		// java FirstProgram 10 20
		// 10 => args[0]
		// 20 => args[1]
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
        System.out.printf("Summation is %d %n", Sum(x, y)); 

	}



}
