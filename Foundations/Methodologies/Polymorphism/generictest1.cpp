#include <iostream>
#include <string>
#include <list>
#include <vector>
#include <set>

using namespace std;

int main(void)
{
	list<double> a; //generic double linked-list collection
	a.push_back(35.2);
	a.push_back(53.3);
	a.push_back(74.4);
	a.push_back(42.5);
	a.push_front(29.1);
	cout << "All values in the list" << endl;
	//a collection enables standard iteration by exposing begin
	//and end methods each returning the same iterator type which
	//supports !=, prefix ++ and unary * operators
	for(auto i = a.begin(); i != a.end(); ++i)
		cout << *i << endl;

	vector<int> b; //generic array-list collection
	b.push_back(812);
	b.push_back(623);
	b.push_back(435);
	b.push_back(248);
	b.push_back(356);
	b.push_back(567);
	b.push_back(774);
	//b.push_back("Twenty");
	cout << "All integers in the vector" << endl;
	//range-for loop simplifies usage of standard iteration
	for(int n : b)
		cout << n << endl;

	set<string> c; //generic binary-tree collection
	c.insert("Monday");
	c.insert("Tuesday");
	c.insert("Wednesday");
	c.insert("Thursday");
	c.insert("Friday");
	c.insert("Monday");
	cout << "All strings in the set" << endl;
	for(string s : c)
		cout << s << endl;
}

