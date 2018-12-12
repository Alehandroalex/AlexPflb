package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.PageObject;

public class LetterPage extends PageObject {

    public LetterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@name='to']")
    public WebElement recipient;

    @FindBy(css = "label.mail-Compose-Field_subject input")
    public WebElement topicField;

    @FindBy(xpath = "//textarea[@role='textbox']")
    public WebElement bodyOfLetter;

    @FindBy(css = "button.js-send-button")
    public WebElement sentLetter;

    @FindBy(css = "svg.svgicon-mail--Close")
    public WebElement closeLetter;

}