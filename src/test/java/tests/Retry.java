package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//Здесь реализована логика: если тест зафейлин, то стартони его еще раз
/*
В случае, если нужно уменьшить или увеличить количество повторных тестов,
 необходимо изменить значение maxTry. В этом примере неудачные тесты будут выполняться 3 раза,
 пока не завершатся успешно. В случае сбоя в третий раз выполнение теста будет остановлено,
 и TestNG отметит этот случай как неудачный.
 */

@Log4j2
public class Retry implements IRetryAnalyzer {

    private int attempt = 1;
    private static final int MAX_RETRY = 3;//количество повторений

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (attempt < MAX_RETRY) {
                attempt++;
                iTestResult.setStatus(ITestResult.FAILURE);
                log.warn("Retrying once again");
                return true;
            } else {
                iTestResult.setStatus(ITestResult.FAILURE);
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
