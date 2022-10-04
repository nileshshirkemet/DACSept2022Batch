#include "banner3.h"
#include <cstdio>

int main(void)
{
	int n;
	printf("Number of Banners: ");
	scanf("%d", &n);

	if(n == 1)
	{
		//explicitly allocating memory on heap for an instance
		//and initializing it by calling the specified constructor
		Banner* b = new Banner(Geometry::Triangular);
		b->Resize(12, 5);
		printf("Area of Banner = %.2lf\n", b->Area());
		//deallocating the memory explicitly allocated for an instance
		//after calling its destructor
		delete b;
	}
	else
	{
		//explicitly allocating memory on heap for an array of n instances
		//and initializing each of them by calling default constructor
		Banner* a = new Banner[n];
		for(int i = 0; i < n; ++i)
		{
			a[i].Resize(12 + i, 5 + i);
			printf("Area of Banner %d is %.2lf\n", i + 1, a[i].Area());
		}
		//deallocating the memory explicitly allocated for an array of instances
		//after calling destructor on each of them
		delete[] a;
	}
}

