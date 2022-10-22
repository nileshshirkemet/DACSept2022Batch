package advertisement;

public class Banner{
	private float width;
	private float height;

	public Banner(){
		width = 20;
		height = 5;
	}
    //overloaded functions
    public boolean Resize(float w, float h){
		if (w >= h){
			width = w;
			height = h;
			return true;
		}
		return false;
	}
    
	public void Resize(float s){
		Resize(s, s);
	}

    public double area(){
		return width * height;
	}
   
}
