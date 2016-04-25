import org.junit.Test;

import static core.Helpers.getUniqueText;
import static pages.Gmail.*;
import static pages.Mails.*;
import static pages.Menu.*;

public class GmailTest extends BaseTest {

    public static String mailSubject = getUniqueText("Letter");


    @Test
    public void testSearchLifeCycle(){

        open();
        login(TestData.email, TestData.password);
        send(TestData.email, mailSubject);

        refresh();
        assertMail(0, mailSubject);

        goToSent();
        assertMail(0, mailSubject);

        goToInbox();
        searchBySubject(mailSubject);

        assertMails(mailSubject);

    }

}
