#include <stdio.h>
#include <unistd.h>

int main(int argc, char* argv[])
{
	register int i;

	printf("Running %s as process<%d/%d>\n", argv[0], getpid(), getppid());
	for(i = 1; i < argc; ++i)
		printf("Hello %s\n", argv[i]);

}

