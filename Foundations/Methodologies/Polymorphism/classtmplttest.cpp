#include <iostream>
#include <string>

template<typename T> 
class Selector //Selector is class template with T as a substitutable data-type
{
public:
	Selector(const T& a, const T& b) : first(a), second(b)
	{
	}

	T Select(int index) const
	{
		if((index % 2) == 1)
			return first;
		return second;
	}
private:
	T first;
	T second;
};

int main(void)
{
	int i;
	std::cout << "Index: ";
	std::cin >> i;

	Selector<double> d(23.4, 43.2); //instantiating templated Selector class with T=double
	std::cout << "Selected double value = "
			  << d.Select(i)
			  << std::endl;

	Selector<std::string> s("Monday", "Tuesday");
	std::cout << "Selected string value = "
			  << s.Select(i)
			  << std::endl;
}

