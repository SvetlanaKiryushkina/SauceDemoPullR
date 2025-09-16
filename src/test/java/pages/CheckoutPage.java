package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class CheckoutPage extends BasePage {

    private final By TITLE = By.xpath("//*[text()='Checkout: Your Information']");
    private final By NAME_PAGE = By.xpath("//*[text() ='Checkout: Your Information']");

    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public String getPageTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Override
    public CheckoutPage isPageOpened(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_PAGE));
        return this;
    }
}
