#include <stdio.h>

extern long GCD(long, long);

int main(void)
{
	long a, b, c, g;

	printf("Three Positive Integers: ");
	scanf("%ld%ld%ld", &a, &b, &c);
	g = GCD(GCD(a, b), c);
	printf("G.C.D = %ld\n", g);
}

