package TestComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.MainPage;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    static Properties properties;
    public MainPage mainPage;

    @BeforeMethod
    public void setUp() {
        properties = ConfigReader.initializeProperties();
        driver = DriverSetup.initializeDriver(properties.getProperty("browser"));
    }
    @BeforeMethod(alwaysRun = true,dependsOnMethods = "setUp")
    public MainPage launchApplication() {
        mainPage = new MainPage(driver);
        return mainPage;
    }

    @AfterMethod
    public void driverClose() {
        driver.quit();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }
}

