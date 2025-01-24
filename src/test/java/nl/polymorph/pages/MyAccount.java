package nl.polymorph.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    @FindBy(xpath = "//div[@class='user-registration-MyAccount-content']") public WebElement myAccountWelcomeText;
    @FindBy(linkText = "Logout") public WebElement logoutButton;
    @FindBy(linkText = "Confirm and log out") public WebElement confirmLogout;
    @FindBy(id = "username") public WebElement userName;

    public MyAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);  // Initialize PageFactory elements
    }

}
