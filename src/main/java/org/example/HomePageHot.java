package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageHot {

    private WebDriver driver;
    private WebDriverWait wait;

    // Private locators
    private By currencySelector = By.name("currency_code");
    private By hotProduct = By.className("hot-product-card");

    public HomePageHot(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectCurrency(String currency) {
        WebElement currencyDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(currencySelector));
        currencyDropdown.click();

        By currencyOption = By.cssSelector("option[value='" + currency + "']");
        WebElement currencyElement = wait.until(ExpectedConditions.elementToBeClickable(currencyOption));
        currencyElement.click();
    }

    public void selectHotProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(hotProduct));
        product.click();
    }
}
