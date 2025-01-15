package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventTypesPage {
    private WebDriver driver;

    private By pageHeaderBy = By.xpath("//h3[text()='Event Types']");
    private By createEventButtonBy = By.id("create-event");
    // Example: Create event button

    // Constructor
    public EventTypesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify if the Event Types page is displayed
    public boolean isEventTypesPageDisplayed() {
        return driver.findElement(pageHeaderBy).isDisplayed();
    }

    // Get the page header text
    public String getPageHeaderText() {
        return driver.findElement(pageHeaderBy).getText();
    }

    // Click the "Create Event" button
    public void clickCreateEventButton() {
        driver.findElement(createEventButtonBy).click();
    }
}
