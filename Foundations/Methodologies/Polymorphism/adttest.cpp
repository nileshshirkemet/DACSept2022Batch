#include "series.h"
#include <cstdio>

double Compute(Series::Sequence& seq, int count)
{
	return seq.Sum(count) / count;
}

int main(void)
{
	int n;
	printf("Number of Terms: ");
	scanf("%d", &n);

	Series::LinearSequence a(2, 5);
	Series::PowerSequence b(3);

	printf("First linear computation result  = %lf\n", Compute(a, n));
	printf("Second linear computation result = %lf\n", Compute(a, n));
	printf("First power computation result   = %lf\n", Compute(b, n));
	printf("Second power computation result  = %lf\n", Compute(b, n));
}

