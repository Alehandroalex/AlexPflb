package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.HomePage;
import ru.pflb.pages.main.MainPage;
import ru.pflb.tech.konfiguratin.Configuration;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

public class AuthorizationSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(AuthorizationSteps.class);

    AuthorizationPage authorizationPage;
    HomePage homePage;

    public AuthorizationSteps(Context context){
        super(context);
        LOGGER.debug("AuthorizationSteps is created");
        authorizationPage = context.getPageObjectManager().getAuthorizationPage();
        homePage = context.getPageObjectManager().getHomePage();
    }

    @Given("^login to mail$")
    public void loginToMail(){
        homePage.open();
        authorizationPage.enterButton.click();
        authorizationPage.setLogin(Configuration.LOGIN);
        if(! authorizationPage.passwordField.isDisplayed()){
            authorizationPage.enter.click();
        }
        authorizationPage.setPassword(Configuration.PASSWORD);
        authorizationPage.enter.click();
    }

    @Then("^login \"([^\"]*)\" missing on screen$")
    public void loginMissingOnScreen(String arg0) throws Throwable{
        homePage.getToGetMail().isDisplayed();
    }
}