#include <stdio.h>

int main(void)
{
	int num;
	register int sum;

	printf("Positive Integer: ");
	scanf("%d", &num);

	sum = 0;

	while(num > 0)
	{
		sum += num % 10; //sum = sum + num % 10;
		num /= 10; //num = num / 10;
	}

	printf("Sum of Digits = %d\n", sum);
}

