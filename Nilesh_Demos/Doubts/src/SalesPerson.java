package hr;

public class SalesPerson extends Employee{
	private double sales;

	final public double getSales(){
		return sales;
	}
	final void setSales(double ss){
		sales = ss;
	}
	
	public SalesPerson(){
	   super();
	}

	public SalesPerson(int hh, float rr, double ss){
		super(hh, rr);
		sales = ss;
	}

	public double income(){
		double in = super.income();
		in = in + sales * 0.25;
		return in;
	}


}
