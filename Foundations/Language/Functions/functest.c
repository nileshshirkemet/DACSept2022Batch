#include <stdio.h>

float BannerPrice(float length, float breadth, short copies, float rate)
{
	float d = copies < 5 ? 0 : 0.15;
	return copies * (length - 0.5) * (breadth - 0.5) * rate * (1 - d);
}

int main(void)
{
	float width, height;
	short int count = 0;
	float payment;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners   : ");
	scanf("%hd", &count);

	if(width > height)
	{
		printf("Total Payment for Landscape Banner = %.2f\n", BannerPrice(width, height, count, 0.75));
	}
	else
	{
		printf("Total Payment for Potrait Banner = %.2f\n", BannerPrice(width, height, count, 0.80));
	}
	puts("Goodbye Customer.");

	return count + 1;
}

