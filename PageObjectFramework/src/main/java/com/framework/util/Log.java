package com.framework.util;

import org.apache.log4j.Logger;

public class Log {

    private static Logger Log = Logger.getLogger(com.framework.util.Log.class.getName());

    public static void plainLine(){
        Log.info("========================================================================================");
    }

    public static void startTesting(String testCaseName){
        Log.info("----- TestCase Name: "+testCaseName);
        Log.info("========================================================================================");
    }

    public static void info(String message) {
        String getCallingClassName = Thread.currentThread().getStackTrace()[2].getClassName() + " -> ";
        Log.info(getCallingClassName + message);
    }

    public static void warn(String message) {
        String getCallingClassName = Thread.currentThread().getStackTrace()[2].getClassName() + " -> ";
        Log.warn(getCallingClassName + message);
    }

    public static void error(String message) {
        String getCallingClassName = Thread.currentThread().getStackTrace()[2].getClassName() + " -> ";
        Log.error(getCallingClassName + message);
    }

    public static void fatal(String message) {
        String getCallingClassName = Thread.currentThread().getStackTrace()[2].getClassName() + " -> ";
        Log.fatal(getCallingClassName + message);
    }

    public static void debug(String message) {
        String getCallingClassName = Thread.currentThread().getStackTrace()[2].getClassName() + " -> ";
        Log.debug(getCallingClassName + message);
    }

}