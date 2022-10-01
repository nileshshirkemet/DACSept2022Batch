#include <cstdio>
#include <cmath>

double Compute(int count)
{
	puts("Performing basic computation...");
	return count * (count + 1) / 2; 
}

//function overloading - defining multiple functions with same name
//but different list of parameter types
double Compute(float level, int count)
{
	puts("Performing advanced computation...");
	
	double total = 0;

	for(int i = 1; i <= count; ++i)
	{
		total += pow(i, level);	
	}

	return total;
}

int main(void)
{
	int n;
	float p;

	printf("Upper Limit: ");
	scanf("%d", &n);
	printf("Level: ");
	scanf("%f", &p);

	double c1 = Compute(n);
	double c2 = Compute(p, n);

	printf("Final Result = %.3lf\n", c2 / c1);
}

