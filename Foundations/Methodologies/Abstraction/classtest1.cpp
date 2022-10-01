#include "banner1.h"
#include <cstdio>

double BannerPrice(Banner info, int copies)
{
	float rate = copies < 5 ? 0.80 : 0.75;
	return copies * rate * info.Area(); //Banner::Area(&info)
}

int main(void)
{
	Banner a;  //activation of Banner instance identified by object a

	float x, y;
	printf("Banner Dimensions: ");
	scanf("%f%f", &x, &y);
	int n;
	printf("Number of Copies : ");
	scanf("%d", &n);

	a.Resize(x, y); //Banner::Resize(&a, x, y)
	printf("Total price of regular banner: %.2lf\n", BannerPrice(a, n));
}

