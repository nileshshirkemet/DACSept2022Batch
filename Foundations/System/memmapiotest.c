#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/mman.h>

extern int Transform(char[], int);

int main(int argc, char* argv[])
{
	int fd;

	if(argc < 2)
		return printf("USAGE: %s file-to-reverse\n", argv[0]);
	
	fd = open(argv[1], O_RDWR, 0);
	if(fd != -1)
	{
		struct stat fs;
		int n;
		char* buffer;

		fstat(fd, &fs);
		n = fs.st_size;
		buffer = mmap(NULL, n, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
		Transform(buffer, n);
		munmap(buffer, n);

		close(fd);
	}
	else
		printf("ERROR: Cannot read %s\n", argv[1]);
}

