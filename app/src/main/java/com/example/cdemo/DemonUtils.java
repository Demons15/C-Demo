package com.example.cdemo;

public class DemonUtils {
    static {
        System.loadLibrary("demon");
    }

    public static native String getString();
}
