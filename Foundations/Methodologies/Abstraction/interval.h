#include <cstdio>

class Interval
{
public:
	Interval(int min, int sec)
	{
		minutes = min + sec / 60;
		seconds = sec % 60;
		#ifdef TESTING
		puts("Interval instance initialized");
		#endif
	}
	
	//copy constructor
	Interval(const Interval& source)
	{
		minutes = source.minutes;
		seconds = source.seconds;
		#ifdef TESTING
		puts("Interval instance copy initialized");
		#endif
	}

	int Time() const
	{
		return 60 * minutes + seconds;
	}

	void Print() const
	{
		printf("%d:%02d\n", minutes, seconds);
	}

	//overloading addition(+) operator
	Interval operator+(const Interval& rhs) const
	{
		return Interval(minutes + rhs.minutes, seconds + rhs.seconds);
	}

	~Interval()
	{
		#ifdef TESTING
		puts("Interval instance finalized");
		#endif
	}
private:
	int minutes;
	int seconds;
};

