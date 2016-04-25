package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static core.ConciseAPI.$;

public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void goToInbox() {
        $("a[title^='Inbox']").click();
    }

    public static void goToSent() {
        $(By.linkText("Sent Mail")).click();
    }
}

