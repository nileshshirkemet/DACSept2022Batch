class Banner
{
//members declared within public (access-control) block 
//are visible outside of this class
public:

	bool Resize(float w, float h) //bool Banner::Resize(Banner* this, float w, float h)
	{
		if(w >= h)
		{
			width = w; //this->width = w
			height = h; //this->height = h;
			return true;
		}
		return false;
	}

	//const qualifier indicates that the method does not
	//change the state of the object on which it is called
	double Area() const //double Banner::Area(const Banner* this)
	{
		return width * height; //return this->width * this->height
	}
	
	//constructor is defined as a special member function
	//with no return type and a name that matches with the
	//name of its class
	Banner()
	{
		width = 20;
		height = 5;
	}

//members declared within private block are visible
//only in the current class
private:
	float width;
	float height;
};

