package com.allaber.iq.utils;

public class Utils {

    public static boolean isBlankString( String value )
    {
        return value == null || value.trim().length() == 0;
    }

    public static boolean notBlankString( String value )
    {
        return ! isBlankString(value);
    }
}
