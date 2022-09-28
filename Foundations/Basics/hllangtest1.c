#include "common.h"

int main(void)
{
	long long int upper = GetInt("Upper Limit: ");
	long long int total = upper * (upper + 1) / 2;
	PutInt("Sum of Integers = ", total);
	PutMsg("Goodbye User.\n");
}

