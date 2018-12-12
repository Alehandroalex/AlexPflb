package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.PageObject;

import java.util.regex.Pattern;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(linkText = "Черновики")
    public WebElement draft;

    @FindBy(linkText = "Отправленные")
    public WebElement sent;

    @FindBy(className = "mail-MessageSnippet-Content")
    public WebElement letter;

    @FindBy(css = "span.mail-MessageSnippet-Item_sender > span")
    public WebElement recipient;

    @FindBy(css = "span.mail-MessageSnippet-Item_subject")
    public WebElement topic;

    @FindBy(css = "span.mail-MessageSnippet-Item_firstline > span")
    public WebElement body;

    @FindBy(className = "_nb-checkbox-flag")
    public WebElement checkbox;

    @FindBy(css = "button[data-action='save']")
    public WebElement saveAndGo;

    @FindBy(css = "div._nb-popup-i")
    public WebElement saveWindow;

    @FindBy(css = "div.mail-Toolbar-Item_delete")
    public WebElement delete;

    @FindBy(css = "span.mail-ComposeButton-Refresh")
    public WebElement refresh;

    @FindBy(linkText = "Письмо отправлено.")
    public WebElement letterWasSent;

    @FindBy(css = "div.ns-view-messages-item-box")
    public WebElement newLetter;

    @FindBy(css = "div.mail-User-Name")
    public WebElement userAvatar;

    @FindBy(linkText = "Выйти из сервисов Яндекса")
    public WebElement logOut;

    public WebElement getWriteLetterButton(){
        return (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("mail-ComposeButton-Text")));
    }

    public WebElement getUserNameElement(){
        return (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("mail-User-Name")));
    }

    public WebElement getUserMenu(){
        return (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("b-user-dropdown")));
    }
}