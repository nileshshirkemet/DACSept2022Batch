#include <stdio.h>
#include <time.h>

void DelayLibC(int seconds)
{
	clock_t future = clock() + CLOCKS_PER_SEC * seconds;
	while(clock() < future);
}

int main(int argc, char* argv[])
{
	register int i;

	for(i = 1; i < argc; ++i)
	{
		printf("Hello %s\n", argv[i]);
		DelayLibC(i);
	}
}

