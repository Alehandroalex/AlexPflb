package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.tech.page.PageObject;


import java.util.List;

import static org.openqa.selenium.By.name;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AuthorizationPage extends PageObject {

    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "a.HeadBanner-Button-Enter")
    public WebElement enterButton;

    @FindBy(name = "login")
    private WebElement loginField;

//    @FindBy(xpath = "//button[child::span[text()='Войти']]")
//    public WebElement enter;

    @FindBy(xpath = "//span[text()='Войти']")
    public WebElement enter;

    @FindBy(css = "input#passp-field-passwd")
    public WebElement passwordField;

    public void setLogin(String login){
        loginField.sendKeys(login);
    }

    public void setPassword(String password){
        new WebDriverWait(driver, 30).until(elementToBeClickable(name("passwd"))).sendKeys(password);
    }

    public boolean isPresentPasswordField (){
        List<WebElement> list = driver.findElements(new By.ByCssSelector("input#passp-field-passwd"));
        return list.size() > 0 && list.get(0).isDisplayed();
    }

}