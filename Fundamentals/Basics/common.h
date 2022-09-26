#ifndef _COMMON_H
#define _COMMON_H

#ifdef __cplusplus
extern "C"{
#endif

int main(void);

void __start(int(*)());
void __writestr(const char*, long);
void __writechr(char);
void __writeint(long);
long __readint(void);
void __writedec(double);
double __readdec(void);

void _start(void)
{
	__start(main);	
}

long GetInt(const char* prompt)
{	
	__writestr(prompt, 0);
	return __readint();
}

double GetDec(const char* prompt)
{	
	__writestr(prompt, 0);
	return __readdec();
}

//void __stack_chk_fail(void) {}

#define PutMsg(txt) __writestr(txt, 0)
#define PutInt(pmt, val) __writestr(pmt, 0);__writeint(val);__writechr('\n')
#define PutDec(pmt, val) __writestr(pmt, 0);__writedec(val);__writechr('\n')

#ifdef __cplusplus
}
#endif

#endif
