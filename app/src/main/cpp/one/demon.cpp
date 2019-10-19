//
// Created by cxsz-hp11 on 2019/10/19.
//

#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_cdemo_DemonUtils_getString(JNIEnv *env, jclass clazz) {
    // TODO: implement getString()
    std::string a ="I am demon";
    return env->NewStringUTF(a.c_str());
}