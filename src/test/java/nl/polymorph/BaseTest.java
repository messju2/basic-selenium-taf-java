package nl.polymorph;

import actions.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        String url = "https://www.polymorph.nl";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void checkHomePageLoginLogout() throws Exception {
        WebActions webactions = new WebActions(driver);
        webactions.checkHomePageLink();
        webactions.clickToLogin();
        webactions.checkMyAccountWelcomeText();
        webactions.logOut();
    }

    @AfterTest
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}