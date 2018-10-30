package com.gmail.data;

import com.framework.base.ScriptHelper;

public class TestData extends ScriptHelper {
    public static String BASEURL = properties.getProperty("baseUrl");
    public static String BROWSER = properties.getProperty("browserName");
    public static String OPERATING_SYSTEM = properties.getProperty("operatingSystem");

    public static String GMAIL_USERNAME = properties.getProperty("gmailUserName");
    public static String GMAIL_PASSWORD = properties.getProperty("gmailPassword");

}
