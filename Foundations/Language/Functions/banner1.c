#include "banner1.h"

double BannerPrice(Banner info, int copies)
{
	float rate = copies < 5 ? 0.80 : 0.75;
	return copies * info.width * info.height * rate;
}

