#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main(void)
{
	pid_t cpid;

	printf("Welcome from process<%d/%d>\n", getpid(), getppid());
	
	//fork creates a child process and returns its process id in 
	//the parent process and 0 in the child process
	cpid = fork(); 
	//any code here will execute in parent as well as child process
	if(cpid == 0)
	{
		//this code will execute only in child process
		//overwriting current process by executing another command-line
		execl("./greet", "Greeter", "Mother", "Father", "Sister", NULL);
	}
	else
	{
		//this code will execute in parent process
		waitpid(cpid, NULL, 0); //waiting for child to exit
		printf("Goodbye from process<%d/%d>\n", getpid(), getppid());
	}

}

