package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class CartStep {

    CartPage cartPage;
    CheckoutPage checkoutPage;

    public CartStep(WebDriver driver) {
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void clickCheckButton(){
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
    }
}
