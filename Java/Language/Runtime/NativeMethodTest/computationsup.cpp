#include "Computation.h"
#include "series.h"

JNIEXPORT jdouble JNICALL Java_Computation_compute(JNIEnv* env, jobject self, jint terms)
{
	jclass cls = env->GetObjectClass(self);
	jfieldID idFirst = env->GetFieldID(cls, "first", "D");
	jdouble first = env->GetDoubleField(self, idFirst);
	jfieldID idSecond = env->GetFieldID(cls, "second", "D");
	jdouble second = env->GetDoubleField(self, idSecond);
	Series::LinearSequence seq(first, second - first);
	
	return seq.Sum(terms);
}

