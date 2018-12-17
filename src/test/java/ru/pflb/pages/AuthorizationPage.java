package ru.pflb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.pflb.tech.page.PageObject;

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

    public WebElement getPasswordField(){
        return (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.elementToBeClickable(By.name("passwd")));
    }

    public void setLogin(String login){
        loginField.sendKeys(login);
    }

    public void setPassword(String password){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.name("passwd"))).sendKeys(password);
    }

}