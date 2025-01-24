package testdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Facade {

    protected static long default_waiting_timeout = 45;

    SoftAssert softAssert = new SoftAssert();
    WebDriver driver = null;

    public void softAssertContainsTextInElement(WebElement element, String text) throws Exception {
        String elementText = element.getText();
        softAssert.assertTrue(elementText.contains(text));
        softAssert.assertAll();
    }

    public void softAssertMatchesTextInElement(WebElement element, String text) throws Exception {
        String elementText = element.getText();
        softAssert.assertEquals(elementText, text);
        softAssert.assertAll();
    }

    public void webClick(WebElement element) throws Exception {
        waitForElementVisible(element);
        waitForElementClickable(element);
        try {
            element.click();
        } catch (Exception e) {
        }
    }

    private void waitForElementVisible(WebElement element) throws Exception {
        Duration timeout = Duration.ofSeconds(default_waiting_timeout);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
        }
    }

    private void waitForElementClickable(WebElement element) throws Exception {
        Duration timeout = Duration.ofSeconds(default_waiting_timeout);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
        }
    }

    public void webCloseSession() {
        if(driver != null) {
            driver.quit();
        }
    }

}
