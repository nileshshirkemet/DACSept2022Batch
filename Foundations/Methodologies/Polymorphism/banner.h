class Banner
{
public:
	Banner()
	{
		width = 20;
		height = 5;
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
	
	//method overloading - defining a member function of a class whose
	//name matches with another member function of the same class but
	//is defined with different list of parameter types
	void Resize(float s)
	{
		Resize(s, s);
	}

	//a virtual member function can be overridden in the derived class
	//and it is called using dynamic-binding in which its invocation
	//is indirected through (v-table addressed by) the instance on 
	//which it is called
	virtual double Area() const
	{
		return width * height;
	}
private:
	float width;
	float height;
};

//CurvedBanner is a subclass derived from Banner which is called base class
class CurvedBanner : public Banner
{
public:
	//derived class constructor must always call base class constructor
	CurvedBanner(float r = 0.1) : Banner()
	{
		radius = r;
	}

	//overriding method - defining a member function in a class whose
	//declaration matches with a virtual member function defined
	//in its base class
	double Area() const
	{
		return Banner::Area() - 0.86 * radius * radius;
	}
private:
	float radius;
};

