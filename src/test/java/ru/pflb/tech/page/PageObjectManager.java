package ru.pflb.tech.page;

import org.openqa.selenium.WebDriver;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.HomePage;
import ru.pflb.pages.LetterEditorPage;
import ru.pflb.pages.main.MainPage;

public class PageObjectManager {

    private AuthorizationPage authorizationPage;
    private LetterEditorPage letterEditorPage;
    private MainPage mainPage;
    private HomePage homePage;

    public void setDriver(WebDriver driver){
        this.authorizationPage = new AuthorizationPage(driver);
        this.letterEditorPage = new LetterEditorPage(driver);
        this.mainPage = new MainPage(driver);
        this.homePage = new HomePage(driver);
    }

    public AuthorizationPage getAuthorizationPage(){
        return authorizationPage;
    }

    public LetterEditorPage getLetterEditorPage(){
        return letterEditorPage;
    }

    public MainPage getMainPage(){
        return mainPage;
    }

    public HomePage getHomePage(){
        return homePage;
    }
}