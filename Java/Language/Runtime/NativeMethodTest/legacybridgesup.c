#include "LegacyBridge.h"
#include <stdlib.h>

extern jlong GCD(jlong, jlong);

JNIEXPORT jlong JNICALL Java_LegacyBridge_gcdOfTwo(JNIEnv* env, jclass cls, jlong first, jlong second)
{
	return GCD(first, second);
}

JNIEXPORT jlong JNICALL Java_LegacyBridge_gcdOfMany(JNIEnv* env, jclass cls, jlongArray all)
{
	jint n = (*env)->GetArrayLength(env, all);
	jlong* list = malloc(n * sizeof(jlong));
	jlong g, i;

	(*env)->GetLongArrayRegion(env, all, 0, n, list); 
	g = list[0];
	for(i = 1; i < n; ++i)
		g = GCD(g, list[i]);
	free(list);

	return g;
}

