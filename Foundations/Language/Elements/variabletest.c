#include <stdio.h>

//global variables
float width = 0;
float height = 0;

int main(void)
{
	//local variables (defined within a statement block {})
	short int count = 0;
	float payment;

	printf("Dimensions of Banner: ");
	scanf("%f%f", &width, &height);
	printf("Number of Banners   : ");
	scanf("%hd", &count);
	
	payment = 0.75 * count * width * height;
	printf("Total Payment = %f\n", payment);
}

