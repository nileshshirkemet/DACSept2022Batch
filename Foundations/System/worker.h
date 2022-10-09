#include <time.h>

int DoWork(int count, int seed)
{
	clock_t future = clock() + CLOCKS_PER_SEC * count / 10;

	while(clock() < future);

	return count + seed;
}

