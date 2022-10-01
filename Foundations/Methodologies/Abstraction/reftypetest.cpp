#include "banner3.h"
#include <cstdio>

//accept an object type argument using a reference type parameter
//to avoid copying of instance and declare this parameter with const 
//qualifier to indicate that the function will only access the
//instance in a read-only manner
double BannerPrice(const Banner& info, int copies)
{
	float rate = copies < 5 ? 0.80 : 0.75;
	return copies * rate * info.Area();
}

int main(void)
{
	Banner a;
	Banner b(Geometry::Elliptical); 
	
	float x, y;
	printf("Banner Dimensions: ");
	scanf("%f%f", &x, &y);
	int n;
	printf("Number of Copies : ");
	scanf("%d", &n);

	a.Resize(x, y);
	printf("Total price of regular banner: %.2lf\n", BannerPrice(a, n));
	b.Resize(x, y);
	printf("Total price of special banner: %.2lf\n", BannerPrice(b, n));
}

