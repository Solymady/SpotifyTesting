import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnlineBoutiqueTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePageHot homePageHot;
    private ProductPage productPage;
    private CartPage cartPage;


    @BeforeEach
    public void setUp() throws MalformedURLException {
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
       RemoteWebDriver DriverFactory = new RemoteWebDriver(new URL("http://16.171.132.126:4444"), options);

        homePageHot = new HomePageHot(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);// to launch Chrome without GUI
    }

//    //@BeforeEach
//    public void setUp() throws MalformedURLException {
//      //  driver = new ChromeDriver();
//       // wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//      //  driver.manage().window().maximize();
//        driver = DriverFactory.getDriver();
//        driver.get("https://cymbal-shops.retail.cymbal.dev/");
//        homePageHot = new HomePageHot(driver);
//        productPage = new ProductPage(driver);
//        cartPage = new CartPage(driver);
//
//    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPlaceOrderAndVerifyCheckoutWithCurrencyAndMessage() {
        String currency = "USD";
        String expectedMessage = "Your order is complete!";

        try {
            homePageHot.selectCurrency(currency);
            homePageHot.selectHotProduct();
            productPage.addToCart();
            cartPage.enterShippingAndPaymentDetails();
            cartPage.placeOrder();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            assertTrue(checkoutPage.isOnCheckoutPage(), "Checkout page URL validation failed!");
            assertTrue(checkoutPage.validateSuccessMessage(expectedMessage), "Success message validation failed!");
            assertTrue(checkoutPage.validateTotalPaymentCurrency(currency), "Total payment currency validation failed!");
            System.out.println("Test passed: Order completed successfully in " + currency + "!");
        } catch (Exception e) {
            System.out.println("Test failed: Unable to complete the order.");
            e.printStackTrace();
        }
    }


}
