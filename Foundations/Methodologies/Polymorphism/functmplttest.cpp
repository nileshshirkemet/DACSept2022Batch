#include <iostream>
#include <string>

/*
bool Swap(double& first, double& second)
{
	double third = first;
	first = second;
	second = third;
	return first < second;
}

bool Swap(std::string& first, std::string& second)
{
	std::string third = first;
	first = second;
	second = third;
	return first < second;
}
*/

template<typename T> //Swap is a function template in which T is substitutable type
bool Swap(T& first, T& second)
{
	T third = first;
	first = second;
	second = third;
	return first < second;
}

int main(void)
{
	double dx = 23.4, dy = 43.2;
	std::cout << "Original double values = " << dx << ", " << dy << std::endl;
	Swap(dx, dy); //compiler will generate templated Swap function with T=double
	std::cout << "Swapped double values = " << dx << ", " << dy << std::endl;

	std::string sx = "Monday", sy = "Tuesday";
	std::cout << "Original string values = " << sx << ", " << sy << std::endl;
	Swap(sx, sy);
	std::cout << "Swapped string values = " << sx << ", " << sy << std::endl;
	//Swap(dx, sy);
}

