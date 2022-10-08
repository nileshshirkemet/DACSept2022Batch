#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <dlfcn.h>

int main(int argc, char* argv[])
{
	//a void pointer can address data of any type but does not support indirection
	void* lib;

	if(argc < 2)
		return printf("USAGE: %s library-to-use\n", argv[0]);

	lib = dlopen(argv[1], RTLD_NOW);
	if(lib)
	{
		int (*fn)(char[], int);

		fn = dlsym(lib, "Transform");
		if(fn)
		{
			char text[80];

			printf("Text to transform: ");
			scanf("%79[^\n]s", text);
			fn(text, strlen(text));
			printf("Transformed text : %s\n", text);
		}
		else
			puts("ERROR: Bad library");
		dlclose(lib);
	}
	else
		printf("ERROR: Cannot load %s\n", argv[1]);
}

