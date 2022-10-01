#include "banner2.h"
#include <cstdio>

double BannerPrice(Banner info, int copies)
{
	float rate = copies < 5 ? 0.80 : 0.75;
	return copies * rate * info.Area();
}

int main(void)
{
	Banner a; //memory is implicitly allocated (on stack-frame) for the instance
			  //and default constructor is called
	Banner b(Geometry::Elliptical); //memory is implicitly allocated for the instance
									 //and parameterized constructor is called
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

