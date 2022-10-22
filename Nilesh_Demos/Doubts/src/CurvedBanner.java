package advertisement;

public class CurvedBanner extends Banner{
	private float radius;

    public CurvedBanner(){
		super();
		radius = 0.1f;
	}

	public CurvedBanner(float radius){
		super();
		this.radius = radius;
	}

    public double area(){
		double a = super.area() - 0.86 * radius * radius;
		return a;
	}
}
