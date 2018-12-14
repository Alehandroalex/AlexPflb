package ru.pflb.pages.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.pflb.tech.page.PageElement;

public class UserMenu extends PageElement {

    public UserMenu(WebDriver driver, WebElement root){
        super(driver, root);
    }

    @FindBy(linkText = "Выйти из сервисов Яндекса")
    public WebElement logOut;

    public void clickLogoutButton(){
        logOut.click();
    }
}
