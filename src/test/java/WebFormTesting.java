import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WebFormTesting {

    WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testTextInput() {
        driver.get(baseURL);

        WebElement testInput = driver.findElement(By.cssSelector("#my-text-id"));

        String inputText = "test1";
        testInput.sendKeys(inputText);

        String inputText1=testInput.getDomProperty("value");
        assertEquals(inputText,inputText1);
    }

    @Test
    public void testTextArea() {
        driver.get(baseURL);

        WebElement testInput = driver.findElement(By.name("my-textarea"));

        String inputArea = "test area test";
        testInput.sendKeys(inputArea);

        String inputText1=testInput.getDomProperty("value");
        assertEquals(inputArea,inputText1);
    }

    @Test
    public void testDisabledInput() {
        driver.get(baseURL);

        WebElement disabledInput = driver.findElement(By.name("my-disabled"));

        assertFalse(disabledInput.isEnabled());
    }

    @Test
    public void testReadonly(){
        driver.get(baseURL);
        WebElement readonlyInput = driver.findElement(By.name("my-readonly"));
        readonlyInput.sendKeys("test");
        String inputText=readonlyInput.getDomProperty("value");
        assertEquals("Readonly input",inputText);

        readonlyInput.sendKeys("");
        String inputText1=readonlyInput.getDomProperty("value");
        assertEquals("Readonly input",inputText1);

    }


    @Test
    public void Dropdown() {
        driver.get(baseURL);

        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select select = new Select(selectElement);

        //List<WebElement> optionList = select.getOptions();
        //List<WebElement> selectedOptionList = select.getFirstSelectedOption();



    }






}
