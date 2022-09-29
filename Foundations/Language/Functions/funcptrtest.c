#include <stdio.h>

float PrimarySequence(int term)
{
	return 3 * term + 2;
}

float SecondarySequence(int term)
{
	return term * term + 1;
}

/*
double PrimarySum(int count)
{
	register int i;
	double total = 0;

	for(i = 1; i <= count; ++i)
	{
		total += PrimarySequence(i);
	}

	return total;
}

double SecondarySum(int count)
{
	register int i;
	double total = 0;

	for(i = 1; i <= count; ++i)
	{
		total += SecondarySequence(i);
	}

	return total;
}
*/

//the second parameter (sequence) is of function-pointer type
//which accepts any function with one parameter of int type and
//float as its return type
double CommonSum(int count, float (*sequence)(int))
{
	register int i;
	double total = 0;

	for(i = 1; i <= count; ++i)
	{
		total += sequence(i); //function passed for sequence is called
	}

	return total;
}

int main(void)
{
	int n;

	printf("Number of Terms: ");
	scanf("%d", &n);

	//printf("Sum of Primary Terms  : %lf\n", PrimarySum(n));
	//printf("Sum of Secondary Terms: %lf\n", SecondarySum(n));
	printf("Sum of Primary Terms  : %lf\n", CommonSum(n, PrimarySequence));
	printf("Sum of Secondary Terms: %lf\n", CommonSum(n, SecondarySequence));
}

