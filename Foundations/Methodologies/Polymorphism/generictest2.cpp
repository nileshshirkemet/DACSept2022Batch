#include <iostream>
#include <string>
#include <list>
#include <vector>
#include <set>

using namespace std;

template<typename Collection, typename Predicate>
int CountSelected(const Collection& items, Predicate check)
{
	int count = 0;

	for(auto item : items)
	{
		if(check(item))
			count += 1;
	}

	return count;
}

bool IsSmall(double val)
{
	return val < 50;
}

int main(void)
{
	list<double> a;
	a.push_back(35.2);
	a.push_back(53.3);
	a.push_back(74.4);
	a.push_back(42.5);
	a.push_front(29.1);
	cout << "All values in the list" << endl;
	for(auto i = a.begin(); i != a.end(); ++i)
		cout << *i << endl;
	cout << "Number of small values = "
		 << CountSelected(a, IsSmall)
		 << endl;
	vector<int> b; 
	b.push_back(812);
	b.push_back(623);
	b.push_back(435);
	b.push_back(248);
	b.push_back(356);
	b.push_back(567);
	b.push_back(779);
	cout << "All integers in the vector" << endl;
	for(int n : b)
		cout << n << endl;
	cout << "Number of odd integers = "
		 << CountSelected(b, [](int m) { return m % 2; } ) //passing lambda expression
		 << endl;

	set<string> c; 
	c.insert("Monday");
	c.insert("Tuesday");
	c.insert("Wednesday");
	c.insert("Thursday");
	c.insert("Friday");
	c.insert("Monday");
	cout << "All strings in the set" << endl;
	for(string s : c)
		cout << s << endl;
	int lim;
	cout << "Limit: ";
	cin >> lim;
	cout << "Number of big strings = "
		 << CountSelected(c, [lim](string s) { return s.size() > lim; }) //capturing lim by value
		 << endl;
}

