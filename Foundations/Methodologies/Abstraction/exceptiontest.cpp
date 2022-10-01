#include <cstdio>
#include <cmath>

//optional parameters can appear at the end of the list
//of parameters each with default arguments implicitly passed
//by the compiler when required
double Compute(int first, int last, float level=1)
{
	double total = 0;

	if(first > last)
		throw (first - last); //raising an exception of int type
	if(level < 0)
		throw level; //raising an exception of flaot type
	for(int i = first; i <= last; ++i)
	{
		total += pow(i, level);
	}

	return total;
	
}

int main(void)
{
	int m, n;
	float p;

	printf("Lower and Upper Limit: ");
	scanf("%d%d", &m, &n);
	printf("Level: ");
	scanf("%f", &p);
	
	try
	{
		double c1 = Compute(m, n); //Compute(m, n, 1)
		double c2 = Compute(m, n, p);
		printf("Final Result = %.3lf\n", c2 / c1);
	}
	catch(int e)
	{
		printf("Invalid range: off by %d\n", e); //handling exception of int type
	}
	catch(float)
	{
		puts("Invalid level!");
	}
	
	puts("Goodbye User.");
}

