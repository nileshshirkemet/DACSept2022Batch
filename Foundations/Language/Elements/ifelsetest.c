#include <stdio.h>

float width = 0;
float height = 0;

int main(void)
{
	short int count = 0;
	float payment;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners   : ");
	scanf("%hd", &count);

	if(width > height)
	{
		payment = 0.75 * count * width * height;
		printf("Total Payment for Landscape Banner = %.2f\n", payment);
	}
	else
	{
		payment = 0.80 * count * width * height;
		printf("Total Payment for Potrait Banner = %.2f\n", payment);
	}
	puts("Goodbye Customer.");
}

