package TestComponents;

import Components.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        System.out.println(result.getName() + " TEST STARTED.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "TEST PASSED");
        System.out.println(result.getName() + " TEST PASSED.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        String filePath = null;
        try {
            filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("------------------------------");
        System.out.println("Start date and time of the test : " + context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        System.out.println("End date and time of the test : " + context.getEndDate());
        System.out.println("------------------------------");


    }
}
