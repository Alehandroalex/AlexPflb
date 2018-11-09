package ru.pflb.tech;

import org.openqa.selenium.WebDriver;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.LetterPage;
import ru.pflb.pages.MainPage;

public class PageObjectManager {

    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private LetterPage letterPage = new LetterPage();
    private MainPage mainPage = new MainPage();

    void setDriver(WebDriver driver){
        this.authorizationPage.setDriver(driver);
        this.letterPage.setDriver(driver);
        this.mainPage.setDriver(driver);
    }

    public AuthorizationPage getAuthorizationPage(){
        return authorizationPage;
    }

    public LetterPage getLetterPage(){
        return letterPage;
    }

    public MainPage getMainPage(){
        return mainPage;
    }
}
