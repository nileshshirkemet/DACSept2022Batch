#define TESTING
#include "interval.h"
#include <cstdio>

class Journey
{
public:
	//initializing inner object (duration) as a copy of argument(dur)
	Journey(float dis, const Interval& dur) : duration(dur)
	{
		distance = dis;
	}

	float Speed() const
	{
		return distance / duration.Time();
	}
private:
	float distance;
	Interval duration;
};

int main(void)
{
	float d;
	int m, s;
	printf("Distance: ");
	scanf("%f", &d);
	printf("Minutes and Seconds: ");
	scanf("%d%d", &m, &s);

	Interval i(m, s);
	Journey j(d, i);
	printf("Speed = %.3f\n", j.Speed());
}

