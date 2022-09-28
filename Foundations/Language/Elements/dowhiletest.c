#include <stdio.h>

int main(void)
{
	long long int num;
	register long long int a, b, c;

	printf("Positive Integer: ");
	scanf("%lld", &num);

	a = 1;
	b = num;
	c = 0;

	do
	{
		a = a * 10;
		c = c + 1;
	}
	while(a <= b);

	printf("Number of Digits = %lld\n", c);
}

