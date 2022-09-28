#include <stdio.h>

int main(void)
{
	int lower, upper;
	int value, total = 0;

	printf("Lower and Uppper Limit: ");
	scanf("%d%d", &lower, &upper);

	for(value = lower; value <= upper; ++value)
	{
		total += value * value;
	}

	printf("Sum of Squares = %d\n", total);

}

