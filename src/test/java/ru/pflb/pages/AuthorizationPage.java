package ru.pflb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.PageObject;

public class AuthorizationPage extends PageObject {

    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a.HeadBanner-Button-Enter")
    public WebElement enterButton;

    @FindBy(name = "login")
    public WebElement loginField;

    @FindBy(xpath = "//span[text()='Войти']")
    public WebElement enter;

    @FindBy(name = "passwd")
    public WebElement passwordField;

}