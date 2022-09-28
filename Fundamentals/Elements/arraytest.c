#include <stdio.h>

int year[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main(void)
{
	short month = 0;

	printf("Month[1-12]: ");
	scanf("%hd", &month);
	printf("Number of Days = %d\n", year[month - 1]);
	puts("Goodbye User.");
}

