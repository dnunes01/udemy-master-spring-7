package com.eazybytes.jobportal.constants;

public class ApplicationConstants {

    private ApplicationConstants() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    // I understand this is to be done in environment variable in production. This is done this way as part of the demo
    public static  final String JWT_SECRET_KEY = "JWT_SECRET";
    public static final String JWT_SECRET_DEFAULT_VALUE = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
}
