//
// Created by cxsz-hp11 on 2019/10/19.
//

#include <string>
#include "jni.h"

extern "C"
JNIEXPORT jintArray JNICALL
Java_com_example_cdemo_JniUtils_getNumber(JNIEnv *env, jclass thiz) {
    // TODO: implement getNumber()
    int a =10000;
    return env->NewIntArray(a);
}extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_cdemo_JniUtils_getNameString(JNIEnv *env, jclass clazz) {
    // TODO: implement getNameString()
    std::string name ="I am jnilib";
    return env->NewStringUTF(name.c_str());
}