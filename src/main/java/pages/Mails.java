package pages;
import static core.CustomCondition.nthElementContainsText;
import static core.CustomCondition.textsOf;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Mails extends BasePage {

    @FindBy(css = "[role='main'] .zA")
    public static List<WebElement> mails;

    public Mails(WebDriver driver) {
        super(driver);
    }

    public void send(String email, String mailSubject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).sendKeys(email + Keys.ENTER);
        $(By.name("subjectbox")).sendKeys(mailSubject);
        $(byText("Send")).click();
    }

    public void searchBySubject(String subjectText) {
        $(By.name("q")).sendKeys("subject: " + subjectText, Keys.ENTER);
    }

    public void assertMail(int index, String emailAttributeText) {
        assertThat(nthElementContainsText(mails, index, emailAttributeText));
    }

    public void assertMails(String... emailAttributeTexts) {
        assertThat(textsOf(mails, emailAttributeTexts));
    }

}
