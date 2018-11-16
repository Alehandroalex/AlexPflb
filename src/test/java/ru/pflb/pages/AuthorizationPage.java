package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.PageObject;

public class AuthorizationPage extends PageObject {

    public AuthorizationPage(){
    }

    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a.HeadBanner-Button-Enter")
    public WebElement enterButton;

    @FindBy(name = "login")
    public WebElement loginField;

    @FindBy(name = "passwd")
    public WebElement passwordField;

    @FindBy(css = "span.passport-Button-Text")
    public WebElement enterToMail;
}
