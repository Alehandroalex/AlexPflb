package ru.pflb.tech;

import org.openqa.selenium.WebDriver;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.HomePage;
import ru.pflb.pages.LetterPage;
import ru.pflb.pages.MainPage;

public class PageObjectManager {

    private AuthorizationPage authorizationPage;
    private LetterPage letterPage;
    private MainPage mainPage;
    private HomePage homePage;

    void setDriver(WebDriver driver){
        this.authorizationPage = new AuthorizationPage(driver);
        this.letterPage = new LetterPage(driver);
        this.mainPage = new MainPage(driver);
        this.homePage = new HomePage(driver);
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

    public HomePage getHomePage(){
        return homePage;
    }
}