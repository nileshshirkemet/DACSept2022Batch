#include <stdio.h>
/*
int SumAll(int l, int h)
{
	int total = 0;
	register int count;
	for(count = l; count <= h; ++count)
	{
		total+= count;
	}
	return total;
}

int SumEven(int l, int h)
{
	int total = 0;
	register int count;
	for(count = l; count <= h; ++count)
	{   
	    if (count % 2 == 0)
			total+= count;
	}
	return total;
}
*/
int isEven(int n){
	if (n % 2 == 0)
	  	return 1;
}

int isAll(int n){
	return 1;
}

int isOdd(int n){
	if (n % 2 != 0)
		return 1;
	return 0;
}

int SumConditional(int l, int h, int (*check)(int))
{
	int total = 0;
	register int count;
	for(count = l; count <= h; ++count)
	{   
	    if (check(count))  // calling function referred by check
			total+= count;
	}
	return total;
}

int main(void)
{
   int lower, higher;
   printf("Enter lower number/ higher number\n");
   scanf("%d %d", &lower, &higher);

  // printf("Sum is %d\n", SumAll(lower, higher)); 
  // printf("Sum of Even numbers is %d\n", SumEven(lower, higher)); 
	 printf("Sum of All number is %d\n", SumConditional(lower, higher, isAll));
	 printf("Sum of Even number is %d\n", SumConditional(lower, higher, isEven));
	 printf("Sum of Odd number is %d\n", SumConditional(lower, higher, isOdd));

}




