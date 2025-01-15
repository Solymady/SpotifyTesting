package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Private locators
    private By emailField = By.id("email");
    private By addressField = By.id("street_address");
    private By zipCodeField = By.id("zip_code");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By countryField = By.id("country");
    private By cardNumberField = By.id("credit_card_number");
    private By expirationMonthField = By.id("credit_card_expiration_month");
    private By expirationYearField = By.id("credit_card_expiration_year");
    private By cvvField = By.id("credit_card_cvv");
    private By placeOrderButton = By.className("cymbal-button-primary");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterShippingAndPaymentDetails() {
        driver.findElement(emailField).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys("someone@example.com");
        driver.findElement(addressField).sendKeys("1600 Amphitheatre Parkway");
        driver.findElement(zipCodeField).sendKeys("94043");
        driver.findElement(cityField).sendKeys("Mountain View");
        driver.findElement(stateField).sendKeys("CA");
        driver.findElement(countryField).sendKeys("United States");
        driver.findElement(cardNumberField).sendKeys("4432801561520454");
        driver.findElement(expirationMonthField).sendKeys("January");
        driver.findElement(expirationYearField).sendKeys("2026");
        driver.findElement(cvvField).clear();
        driver.findElement(cvvField).sendKeys("123");
    }

    public void placeOrder() {
        // Wait until the "Place Order" button is clickable
        WebElement placeOrder = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrder.click();
    }
}
