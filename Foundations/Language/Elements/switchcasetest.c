#include <stdio.h>

int main(void)
{
	short int age;
	float rate;
	double amount;

	printf("Age: ");
	scanf("%hd", &age);

	switch(age)
	{
		case 16:
			rate = 70;
			break;
		case 18:
			rate = 75;
			break;
		case 21:
			rate = 85;
			break;
		case 50:
			rate = 100;
			break;
		default:
			rate = 50;
	}
	amount = age * rate;
	printf("Gift Amount: %.2lf\n", amount);
}

