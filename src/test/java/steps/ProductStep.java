package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;

@Log4j2
public class ProductStep {

    WebDriver driver;
    ProductPage productPage;

    private final String ADD_TO_CART_PATTERN = "//*[text() ='%s']/ancestor::div[@class='inventory_item']" +
            "//button[text()='Add to cart']";

    public ProductStep (WebDriver driver){
        this.driver=driver;
        productPage = new ProductPage(driver);
    }

    @Step ("Добавление товара с именем: '{product}' в корзину")
    public void addProductToCart (String product) {
        productPage.isPageOpened();
        productPage.addToCart(product);
        log.info("Добавление товара с именем {} в корзину", product);
    }
}
