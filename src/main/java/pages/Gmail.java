package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Gmail extends BasePage {

    public Gmail(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        open("http://gmail.com");
    }

    public void login(String userName, String password) {
        $("#Email").sendKeys(userName + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);
    }

}
