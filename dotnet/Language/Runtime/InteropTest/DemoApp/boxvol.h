#ifdef _WIN32
#define EXPORT __declspec(dllexport)
#else
#define EXPORT
#endif

struct Box
{
	double dimensions[3];
	float thickness;
};

EXPORT int BoxVolume(const struct Box* info, double* result);

