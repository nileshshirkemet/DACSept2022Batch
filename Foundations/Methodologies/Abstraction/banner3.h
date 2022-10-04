#include <cstdio>

enum class Geometry {Rectangular, Triangular, Elliptical};

class Banner
{
public:

	//parameterized constructor which can be used as default constructor
	//since its parameter is optional
	Banner(Geometry g=Geometry::Rectangular)
	{
		width = 20;
		height = 5;
		shape = g;
		puts("Banner instance initialized");
	}

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
	
	//A destructor is a special member function defined for reversing
	//the side-effect of the constructor. It is called before
	//an instance is removed from memory. If memory is implicitly
	//allocated for an instance then destructor is called immediately
	//after its identifier goes out of scope
	~Banner()
	{
		puts("Banner instance finalized");
	}
private:
	float width;
	float height;
	Geometry shape;
};

