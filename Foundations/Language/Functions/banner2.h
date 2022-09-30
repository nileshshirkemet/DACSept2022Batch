typedef enum {Rectangular, Triangular, Elliptical} Geometry;

typedef struct {
	float width;
	float height;
	char text[80];
	Geometry shape;
}Banner;

double BannerPrice(Banner, int);

