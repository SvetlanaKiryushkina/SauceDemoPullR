package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;

import static org.testng.Assert.assertEquals;

public class CartTestNew extends BaseTest {

    @Test(testName = "Проверка, что товар находится в корзине")
    @Description("Проверка, что товар находится в корзине")
    @Owner("Светлана")
    @Feature("Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Тимофей")
    public void checkCart() {
        loginPage.open();
        loginPage.login(user, password);
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickToCart();
        CartPage cartPage = new CartPage(driver);
        String productName = cartPage.getProductNameFromCart(0);
        assertEquals(productName,
                "Sauce Labs Backpack",
                "Товар отсутствует в корзине");
    }

    @Test(testName = "Проверка перехода на страницу Checkout")
    @Description("Проверка, что товар находится в корзине")
    @Owner("Светлана")
    @Feature("Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Тимофей")
    public void checkClickCheckout() {
        loginPage.open();
        loginPage.login(user, password);
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickToCart();
        cartPage.clickCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        assertEquals(checkoutPage.getPageTitle(), "Checkout: Your Information",
                "Пользователь не перешёл на страницу Checkout");
    }

    @Test(testName = "Проверка количества товаров в корзине после добавления")
    @Description("Проверка количества товаров в корзине после добавления")
    @Owner("Светлана")
    @Feature("Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Lead("Тимофей")
    public void checkClickRemove() {
        loginStep.auth(user, password);
        productStep.addProductToCart("Sauce Labs Backpack");
        productStep.addProductToCart("Sauce Labs Bike Light");
        productPage.clickToCart();
        cartPage.isPageOpened();
        assertEquals(cartPage.getItemsCount(), 2, "Количество не соответствует");
    }

    @Test(testName = "Проверка перехода на страницу оформления заказа")
    @Description("Проверка перехода на страницу оформления заказа")
    public void checkCheckoutPageFromCart() {
        loginStep.auth(user, password);
        productStep.addProductToCart("Sauce Labs Backpack");
        cartPage.open()
                .isPageOpened();
        cartStep.clickCheckButton();
    }
}
