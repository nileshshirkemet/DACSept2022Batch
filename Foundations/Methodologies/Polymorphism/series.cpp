#include "series.h"

namespace Series
{
	double Sequence::Sum(int count)
	{
		double total = 0;

		for(int i = 1; i <= count; ++i)
		{
			total += Next();
		}

		return total;
	}

	double LinearSequence::Next()
	{
		double term = current;
		current += step;
		return term;
	}

	double PowerSequence::Next()
	{
		double term = current;
		current *= factor;
		return term;
	}

	LinearSequence::LinearSequence(float first, float difference)
	{
		current = first;
		step = difference;
	}

	PowerSequence::PowerSequence(float ratio)
	{
		current = 1;
		factor = ratio;
	}

	void PowerSequence::Reset()
	{
		current = 1;
	}
}

