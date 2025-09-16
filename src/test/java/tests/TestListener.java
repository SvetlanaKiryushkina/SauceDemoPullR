package tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

import static tests.AllureUtils.takeScreenshot;

//стандартный класс, в котором описано, что тест стартанул, что прошел успешно и т.д
//привязывается ко всем тестам в BaseTest
@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("======================================== STARTING TEST {} ========================================%n", iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("======================================== FINISHED TEST {} Duration: {} ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));
        //WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        //takeScreenshot(driver);//добавили, что бы сделать скриншот при падении теста
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.warn("======================================== FAILED TEST %s Duration: {} ========================================%n", iTestResult.getName(),
                getExecutionTime(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("======================================== SKIPPING TEST {} ========================================%n", iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
