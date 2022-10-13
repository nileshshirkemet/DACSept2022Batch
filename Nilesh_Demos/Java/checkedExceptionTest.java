class MyException extends RuntimeException{} // unchecked exception
class MyException1 extends Exception{} // Checked Exception

class MySum{
      
	int msum(int a , int b){
		if (a == 0) 
		    throw new MyException();
		return (a + b);
	}
	
	int msum1(int a , int b) throws MyException1{
			if (a == 0) 
		    	throw new MyException1();
	
			return (a + b);
	}

}

class MainTest{
	public static void main(String[] args){
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		MySum m = new MySum();
		//MySum n = new MySum();
		//Handling Exception
		
		try{
			System.out.printf("Value is %d%n", m.msum1(x, y));
			}
		catch(MyException1 ex){
			System.out.println("Exception generated was caught and handled");
			}
		finally{
		//n.msum1(x, y);
			System.out.println("Goodbye");
			}
			
			//System.out.printf("Value is %d%n", m.msum1(x, y));
	}
}
