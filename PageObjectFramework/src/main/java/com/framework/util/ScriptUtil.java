package com.framework.util;

import com.framework.base.ScriptHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class ScriptUtil extends ScriptHelper {

    public static long PAGE_LOADING_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 15;

    public static void takeScreenshotAtEndOfTest() throws IOException {
        Log.info("Taking screenshot of the current screen");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/test-output/FailureScreenshots/" + System.currentTimeMillis() + ".png"));
    }

    public static void waitForElement(WebElement element) {
        Log.info("Waiting for element till it get visible");
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getTooltipFromChart(WebElement element, WebElement tooltipElement, int offset) {
        Actions builder = new Actions(driver);
        waitForElement(element);
        Log.info("Hover element based on offset value");
        Point p = element.getLocation();
        builder.moveToElement(element).moveByOffset(offset, 0).build().perform();
        waitForElement(tooltipElement);
        return tooltipElement.getText();
    }

    public static void doubleClickByElementOffset(WebElement element, int offset) {
        Actions builder = new Actions(driver);
        waitForElement(element);
        Log.info("Double click the element based on the offset value");
        Point p = element.getLocation();
        builder.moveToElement(element).moveByOffset(offset, 0).doubleClick().build().perform();
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void explicitWait(long seconds) {
        try {
            Log.info("Waiting explicitly for "+seconds+"seconds for better performance");
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        boolean status = false;
        try {
            Log.info("Check element is displayed");
            if (element.isDisplayed()) {
                Log.info("Element is displayed on the screen");
                status = true;
            }
        } catch (Exception e) {
            Log.info("Element is NOT displayed on the screen");
            status = false;
        }
        return status;
    }

}
