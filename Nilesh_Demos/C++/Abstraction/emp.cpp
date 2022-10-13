#include "emp.h"
#include <cstdio>

int main(void)
{  
   int id, age, hours;
   float rate;

   printf("Enter id / age / hours / rate\n");
   scanf("%d %d %d %f", &id , &age, &hours, &rate);
   //Employee emp;  // non-param ctor called 
   Employee emp(id, age, hours, rate);
   //Employee::GetNetIncome(&emp);
   printf("Employee id %d net Income is %lf\n", emp.GetEid(), emp.GetNetIncome());
}
