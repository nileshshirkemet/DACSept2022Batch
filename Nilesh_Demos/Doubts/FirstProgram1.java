class MySum{
    // static  => are classed by reffering by class name
	// No need to create object of MySum
	//public  => accessible outside package
	//private => accessible inside class
	//nothing => accessible in same package
	private static int Sum(int a, int b){  
		return a + b;
	}
	//instance method
	//create an object of class 
	public int Mul(int a, int b){
		return a * b;
	}

}

class FirstProgram1{
    public static void main(String[] args){
		// java FirstProgram 10 20
		// 10 => args[0]
		// 20 => args[1]
		MySum my = new MySum(); // my is object of MySum
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
        System.out.printf("Summation is %d %n", MySum.Sum(x, y)); 
        System.out.printf("Multiplication is %d %n", my.Mul(x, y)); 
	}
}




