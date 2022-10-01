enum class Geometry {Rectangular, Triangular, Elliptical};

class Banner
{
public:

	//parameterized conbstructor
	Banner(Geometry g)
	{
		width = 20;
		height = 5;
		shape = g;
	}
	
	//A default constructor has zero (non-optional) parameter, such a
	//constructor is implicitly defined if the class does not contain
	//any explicitly defined constructor
	Banner() : Banner(Geometry::Rectangular) {}

	bool Resize(float w, float h) 
	{
		if(w >= h)
		{
			width = w;
			height = h;
			return true;
		}
		return false;
	}

	double Area() const
	{
		switch(shape)
		{
			case Geometry::Triangular:
				return 0.5 * width * height;
			case Geometry::Elliptical:
				return 3.14 * width * height / 4;
			default:
				return width * height;
		}
	}

private:
	float width;
	float height;
	Geometry shape;
};

