package hr;

public class Employee{
     private int id;
	 private int hours;
	 private float rate;
	 private static int count;

	 public int getCount(){
		return count;  // can only access static fields
	 }

     static {
				count = 1000;
	 }
    //non-paramterised ctor
     public Employee(){
		this(180, 100);
	 }
	 //paramterised ctor
	 public Employee(int h, float r){
		hours = h;
		rate = r;
		id = ++count;
	 }
	 public int getId(){
		return id;
	 }
	 public int getHours(){
		return hours;
	 }
	 public void setHours(int hours){
		this.hours = hours;
	 }
	 public float getRate(){
		return rate;
	 }
	 public void setRate(float rr){
		rate = rr;
	 }

	 public double income(){
		return hours * rate;
	 }
	
	 public String toString(){
		return String.format("Id is %d has worked for %d hours", id, hours); 
	 }
    
}







