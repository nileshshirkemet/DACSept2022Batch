#include "series.h"
#include <cstdio>

//lookup for unqualifed symbols in Series namespace
using namespace Series;

double Compute(Sequence* seq, int count)
{
	//explicitly (side) casting of Sequence* to Resetble*
	//using runtime-type identification (RTTI)
	auto rs = dynamic_cast<Resetable*>(seq); //auto = Resetable*
	if(rs) //rs will be nullptr(zero) if casting fails
		rs->Reset();
	return seq->Sum(count) / count;
}

int main(void)
{
	int n;
	printf("Number of Terms: ");
	scanf("%d", &n);

	LinearSequence a(2, 5);
	PowerSequence b(3);

	printf("First linear computation result  = %lf\n", Compute(&a, n));
	printf("Second linear computation result = %lf\n", Compute(&a, n));
	printf("First power computation result   = %lf\n", Compute(&b, n));
	printf("Second power computation result  = %lf\n", Compute(&b, n));

}

