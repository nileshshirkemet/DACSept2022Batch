#include <cstdio>

extern "C" int CountPrimes(int, int);

int main(void)
{
	int lower, upper;

	printf("Lower and Upper Limit: ");
	scanf("%d%d", &lower, &upper);

	printf("Number of Primes = %d\n", CountPrimes(lower, upper));
}

