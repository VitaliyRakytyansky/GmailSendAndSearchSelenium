package pages;


import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Menu extends BasePage {

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void refresh() {
        $(".asf").click();
    }

    public void goToInbox() {
        $("a[title^='Inbox']").click();
    }

    public void goToSent() {
        $(By.linkText("Sent Mail")).click();
    }
}

