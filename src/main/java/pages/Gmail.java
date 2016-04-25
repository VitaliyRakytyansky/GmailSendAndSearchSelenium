package pages;

import org.openqa.selenium.Keys;

import static core.ConciseAPI.$;


public class Gmail {

    public static void login(String userName, String password) {
        $("#Email").sendKeys(userName + Keys.ENTER);
        $("#Passwd").sendKeys(password + Keys.ENTER);
    }

}
