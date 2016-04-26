import org.junit.Test;
import pages.Gmail;
import pages.Mails;
import pages.Menu;

import static core.Helpers.getUniqueText;

import core.Configuration;

public class GmailTest extends BaseTest {

    public static String mailSubject = getUniqueText("Letter");

    static {
        Configuration.timeout = 8;
    }

    Gmail gmail = new Gmail(driver);
    Mails mails = new Mails(driver);
    Menu menu = new Menu(driver);

    @Test
    public void testSearchLifeCycle() {

        gmail.visit();
        gmail.login(TestData.email, TestData.password);
        mails.send(TestData.email, mailSubject);

        menu.refresh();
        mails.assertMail(0, mailSubject);

        menu.goToSent();
        mails.assertMail(0, mailSubject);

        menu.goToInbox();
        mails.searchBySubject(mailSubject);

        mails.assertMails(mailSubject);

    }

}
