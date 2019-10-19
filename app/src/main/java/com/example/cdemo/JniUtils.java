package com.example.cdemo;

public class JniUtils {
    static {
        System.loadLibrary("jnilib");
    }

    public static native String getNameString();

    public static native int getNumber();
}
