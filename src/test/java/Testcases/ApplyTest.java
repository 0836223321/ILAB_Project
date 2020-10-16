package Testcases;

import Base.TestBase;
import Listeners.ExtentReport;
import Pages.PageObject.ApplyPage;
import Utilities.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class ApplyTest extends TestBase {

    ExtentReport extentReport = new ExtentReport();

    @BeforeTest
    public void setUp() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\Executables\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(("https://www.ilabquality.com/training/"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }
    }
        @Test(dataProviderClass = DataProvider.class, dataProvider = "ReadData")
        public void applyTest(Hashtable<String, String> data) throws InterruptedException {

            extentReport.start(data.get("Test_Case_Description"));

            try {
                ApplyPage applyPage = new ApplyPage();
                applyPage.apply(data.get("Name"), data.get("Email"), data.get("Phone_Number"),data.get("Error_Message"));

            } catch (Exception e) {
                extentReport.failure("Application Failed");
                Assert.assertTrue(isElementPresent(By.id("//li[contains(.,'Application Successful .')]")), "Failed to send application");

            }
            //Assert.fail("Failed to send application");
            extentReport.success("Application Sent");
        }


        @AfterTest
        public void tearDown(){
            extentReport.onFinish();
            driver.quit();
        }
}
