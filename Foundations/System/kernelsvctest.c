#include <stdio.h>
#include <time.h>
#include <unistd.h>

//will work on any platform
void DelayLibC(int seconds)
{
	clock_t future = clock() + CLOCKS_PER_SEC * seconds;
	while(clock() < future);
}

//will work on only Linux/x64
void DelayLinX64(int seconds)
{
	long interval[] = {seconds, 0};

	asm("syscall" :: "D"(interval), "a"(35));
	/*
		mov	rax, 35
		mov	rdi, interval
		syscall
	*/
}

//will work on any UNIX platform
void DelayPosix(int seconds)
{
	usleep(1000000 * seconds);
}

int main(int argc, char* argv[])
{
	register int i;

	for(i = 1; i < argc; ++i)
	{
		printf("Hello %s\n", argv[i]);
		//DelayLibC(i);
		//DelayLinX64(i);
		DelayPosix(i);
	}
}

