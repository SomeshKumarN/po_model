package com.framework.base;

import com.framework.util.Constants;
import com.framework.util.EventListener;
import com.framework.util.Log;
import com.framework.util.ScriptUtil;
import com.gmail.data.TestData;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ScriptHelper {

    public static WebDriver driver;
    public static Properties properties;
    public static EventFiringWebDriver e_f_driver;
    public static EventListener eventListener;
    public static WebDriverWait driverWait;

    public ScriptHelper() {
        try {
            properties = new Properties();
            FileInputStream inputProperties = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            properties.load(inputProperties);
            PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/main/resources/log4j.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh");
        Constants.CURRENT_DATE = dateFormat.format(new Date());
        System.setProperty("current.date", Constants.CURRENT_DATE);
        System.setProperty("logfilename",  String.valueOf(Constants.LOG_FILE_NAME++));
        if (TestData.BROWSER.equals("chrome") & TestData.OPERATING_SYSTEM.equals("windows")) {
            System.setProperty("webdriver.chrome.driver", "src/browser_driver/chromedriver1.exe");
            driver = new ChromeDriver();
            driverWait = new WebDriverWait(driver, 60);
        } else if (TestData.BROWSER.equals("chrome") & TestData.OPERATING_SYSTEM.equals("ubuntu")) {
            System.setProperty("webdriver.chrome.driver", "src/browser_driver/chromedriver");
            driver = new ChromeDriver();
            driverWait = new WebDriverWait(driver, 60);
        } else if (TestData.BROWSER.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "src/browser_driver/geckodriver.exe");
            driver = new FirefoxDriver();
            driverWait = new WebDriverWait(driver, 60);
        }

        e_f_driver = new EventFiringWebDriver(driver);
        eventListener = new EventListener();
        e_f_driver.register(eventListener);
        driver = e_f_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(ScriptUtil.PAGE_LOADING_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(ScriptUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        Log.plainLine();
        driver.get(TestData.BASEURL);
    }
}
