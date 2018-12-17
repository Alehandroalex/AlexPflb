package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageObject;

import java.util.ArrayList;
import java.util.List;

public class LetterEditorPage extends PageObject {

    public LetterEditorPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@name='to']")
    public WebElement recipientField;

    @FindBy(xpath = "//div[@name='to']/span")
    public List<WebElement> recipientElements;

    @FindBy(css = "label.mail-Compose-Field_subject input")
    public WebElement topicField;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public WebElement bodyField;

    @FindBy(css = "button.js-send-button")
    public WebElement sentLetter;

    @FindBy(css = "svg.svgicon-mail--Close")
    public WebElement closeLetter;

    public List<String> getRecipients(){
        List<String> recipients = new ArrayList<>(recipientElements.size());
        for(WebElement recipientElement : recipientElements){
            recipients.add(recipientElement.getAttribute("data-yabble-email"));
        }
        return recipients;
    }

}