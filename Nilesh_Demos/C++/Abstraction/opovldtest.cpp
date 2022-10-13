#include "interval.h"
#include <cstdio>

int main(void)
{
	int m, s;
	printf("First Interval : ");
	scanf("%d%d", &m, &s);
	Interval a(m, s);
	printf("Second Interval: ");
	scanf("%d%d", &m, &s);
	Interval b(m, s);
	Interval c = a + b; //a.operator+(b)
	printf("Total Interval = ");
	c.Print();
}
