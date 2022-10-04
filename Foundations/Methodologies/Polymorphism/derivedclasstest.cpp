#include "banner.h"
#include <cstdio>

double BannerPrice(const Banner& info, int copies)
{
	float rate = copies < 5 ? 0.8 : 0.75;
	//dynamic binding is used for calling a virtual member function (Area)
	//on a reference (info) or pointer
	return copies * rate * info.Area();
}

int main(void)
{
	float x, y;
	int n;
	
	printf("Dimensions of Banner: ");
	scanf("%f%f", &x, &y);
	printf("Number of Copies: ");
	scanf("%d", &n);

	Banner a;
	a.Resize(x, y);
	printf("Total price for regular banner = %.2lf\n", BannerPrice(a, n));

	CurvedBanner b(0.5);
	b.Resize(x, y);
	printf("Total price for special banner = %.2lf\n", BannerPrice(b, n));

}

