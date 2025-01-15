package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By successMessageLocator = By.cssSelector("div.col-12.text-center > h3");
    private By totalPaymentLocator = By.className("col-6 pr-md-0 text-right");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public boolean isOnCheckoutPage() {
        return wait.until(ExpectedConditions.urlContains("https://cymbal-shops.retail.cymbal.dev/cart/checkout"));
    }

    public String getSuccessMessage() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return successMessage.getText();
    }

    public boolean validateSuccessMessage(String expectedMessage) {
        String actualMessage = getSuccessMessage();
        return actualMessage.contains(expectedMessage);
    }

    public String getTotalPayment() {
        WebElement totalPaymentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPaymentLocator));
        return totalPaymentElement.getText();
    }

    public boolean validateTotalPaymentCurrency(String expectedCurrency) {
        String totalPayment = getTotalPayment();
        return totalPayment.contains(expectedCurrency);
    }
}
