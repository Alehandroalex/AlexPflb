package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageObject;

import java.util.ArrayList;
import java.util.List;

public class LetterViewerPage extends PageObject {

    public LetterViewerPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "div.mail-Message-Head-Floor_recipient div.js-contact-actions-dropdown")
    public List<WebElement> recipientList;

    @FindBy(css = "div.mail-Message-Toolbar-Subject_message")
    public WebElement topic;

    @FindBy(css = "div.mail-Message-Body-Content")
    public WebElement body;

    public List<String> getRecipients(){
        List<String> recipients = new ArrayList<>(recipientList.size());
        for(WebElement recipientElement : recipientList){
            recipients.add(recipientElement.getAttribute("data-email"));
        }
        return recipients;
    }

}