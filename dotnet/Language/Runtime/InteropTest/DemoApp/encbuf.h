#ifdef _WIN32
#define EXPORT __declspec(dllexport)
#else
#define EXPORT
#endif

EXPORT long long encrypt_buffer(char bytes[], int count, const char* key, int (*transform)(char, char));


