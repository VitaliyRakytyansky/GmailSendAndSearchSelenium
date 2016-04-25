package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Winterfall on 21.04.2016.
 */
public class CustomCondition {

    public static ExpectedCondition<List> textsOf(final List<WebElement> elements, final String... expectedTexts){
        return new ExpectedCondition<List>() {

            private ArrayList<String> actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                actualTexts = new ArrayList<String>();
                for (WebElement element : elements) {
                    actualTexts.add(element.getText());
                }
                if (actualTexts.size() != expectedTexts.length) {
                    return null;
                } else {
                    for (int i = 0; i < actualTexts.size(); i++) {
                        if (!actualTexts.get(i).contains(expectedTexts[i])) {
                            return null;
                        }
                    }
                    return elements;
                }
            }

            public String toString() {
                return String.format("\nExpected texts to be present: %s\n but actual texts are: %s\n",
                        Arrays.toString(expectedTexts), Arrays.toString(actualTexts.toArray()));
            }
        };
    }

    public static ExpectedCondition<WebElement> nthElementContainsText(final List<WebElement> elements, final int index, final String expectedText){
        return new ExpectedCondition<WebElement>() {

            private String actualText;

            public WebElement apply(WebDriver driver) {
                try {
                    actualText = elements.get(index).getText();
                    if (actualText.contains(expectedText)) {
                        return elements.get(index);
                    } else {
                        return null;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
            }

            public String toString() {
                return String.format("\nExpected text to be present in %s element: %s\n but actual text is: %s\n",
                        index, expectedText, actualText);
            }
        };
    }
}
