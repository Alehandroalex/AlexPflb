package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageObject;

public class LetterPage extends PageObject {

    public LetterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@name='to']")
    public WebElement recipientField;

    @FindBy(css = "label.mail-Compose-Field_subject input")
    public WebElement topicField;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public WebElement bodyField;

    @FindBy(css = "button.js-send-button")
    public WebElement sentLetter;

    @FindBy(css = "svg.svgicon-mail--Close")
    public WebElement closeLetter;

}