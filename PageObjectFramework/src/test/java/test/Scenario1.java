package test;

import com.framework.base.ScriptHelper;
import com.framework.util.Log;
import com.gmail.data.TestData;
import com.gmail.pages.GMail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scenario1 extends ScriptHelper {
    GMail gMail;

    public Scenario1() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        gMail = new GMail();
    }

    @Test
    public void GmailLoginTest() {
        Log.startTesting("Validate Pie Chart Tooltip Vulnerability Count Aggregation");
        gMail.loginIntoGmail(TestData.GMAIL_USERNAME,TestData.GMAIL_PASSWORD);
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
