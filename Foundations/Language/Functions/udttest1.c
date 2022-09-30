#include "banner1.h"
#include <stdio.h>

int main(void)
{
	Banner mybanner = {10, 6};
	int n;

	printf("Banner Dimensions: ");
	scanf("%f%f", &mybanner.width, &mybanner.height);
	printf("Number of Copies : ");
	scanf("%d", &n);

	printf("Total price for regular banner: %.2lf\n", BannerPrice(mybanner, n));

}

