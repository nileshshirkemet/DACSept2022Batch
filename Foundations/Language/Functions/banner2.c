#include "banner2.h"

//accept argument of struct type using a pointer type parameter
//to avoid copying of data and declare this parameter with
//const qualifier to indicate that function will treat the
//addressed data as read-only
static float BannerArea(const Banner* info)
{
	switch(info[0].shape)
	{
		case Elliptical:
			return 3.14 * (*info).width * info->height / 4;
		case Triangular:
			return 0.5 * info->width * info->height;
		default:
			return info->width * info->height;
	}
}

double BannerPrice(Banner info, int copies)
{
	float rate = copies < 5 ? 0.80 : 0.75;
	return copies * rate * BannerArea(&info);
}

