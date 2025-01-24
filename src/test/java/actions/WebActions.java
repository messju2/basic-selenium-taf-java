package actions;

import nl.polymorph.pages.MainPage;
import nl.polymorph.pages.MyAccount;
import testdrivers.Facade;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebActions extends Facade {

    WebDriver driver;
    MainPage mainpage;
    MyAccount myaccount;
    private Properties properties;
    private final String appConfigPath = "./src/main/config/settings.properties";

    public WebActions(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
        this.mainpage = new MainPage(driver);
        this.myaccount = new MyAccount(driver);

        File ConfigFile= new File(appConfigPath);
        try {
            FileInputStream configFileReader = new FileInputStream(ConfigFile);
                properties = new Properties();
        try {
            properties.load(configFileReader);
            configFileReader.close();
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }  catch (FileNotFoundException e)
    {
        System.out.println(e.getMessage());
        throw new RuntimeException("config.properties not found at config file path " + appConfigPath);
    }
}

    public void checkHomePageLink() throws Exception {
        softAssertContainsTextInElement(mainpage.homeText, "Blog");
    }

    public void clickToLogin() throws Exception {
        softAssertMatchesTextInElement( mainpage.login, "My Account");
        webClick(mainpage.login);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        mainpage.userName.sendKeys(username);
        mainpage.passWord.sendKeys(password);

        webClick(mainpage.loginButton);
    }

    public void checkMyAccountWelcomeText() throws Exception {
        softAssertContainsTextInElement(myaccount.myAccountWelcomeText, "Welcome, test ");
    }

    public void logOut() throws Exception {
        webClick(myaccount.logoutButton);
    }

}
