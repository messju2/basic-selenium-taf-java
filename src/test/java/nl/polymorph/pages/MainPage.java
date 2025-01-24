package nl.polymorph.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//h1[@class = 'wp-block-heading has-text-align-left']") public WebElement homeText;
    @FindBy(xpath = "//a[@href='https://polymorph.nl/my-account/']") public WebElement login;
    @FindBy(id = "username") public WebElement userName;
    @FindBy(id = "password") public WebElement passWord;
    @FindBy(name = "login") public WebElement loginButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);  // Initialize PageFactory elements
    }

}
