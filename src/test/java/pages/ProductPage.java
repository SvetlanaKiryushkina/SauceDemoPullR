package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CartPage;

public class ProductPage extends BasePage {

    private final By TITLE = By.className("title");
    private final String ADD_TO_CART_PATTERN = "//*[text() ='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']";
    private final By NAME_PAGE = By.xpath("//*[text() ='Products']");
    private final By TOCART_BUTTON = By.cssSelector(".shopping_cart_link");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");//переход на страницу товаров
    }

    @Step("Добавление товара с именем: '{product}' в корзину")
    public void addToCart(String product) {//добавление товара в корзину
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Нажатие на кнопку корзина")
    public CartPage clickToCart() {//клик по иконке корзины
        driver.findElement(TOCART_BUTTON).click();
        return new CartPage(driver);
    }

    public ProductPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_PAGE));
        return this;
    }
}
