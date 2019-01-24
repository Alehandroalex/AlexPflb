package ru.pflb.steps;

import cucumber.api.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.AuthorizationPage;
import ru.pflb.pages.HomePage;
import ru.pflb.tech.configuration.Configuration;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

public class AuthorizationSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(AuthorizationSteps.class);

    private AuthorizationPage authorizationPage;
    private HomePage homePage;

    public AuthorizationSteps(Context context){
        super(context);
        LOGGER.debug("AuthorizationSteps is created");
        authorizationPage = new AuthorizationPage(getDriver());
        homePage = new HomePage(getDriver());
    }

    @Given("^login to mail$")
    public void loginToMail(){
        homePage.open();
        authorizationPage.enterButton.click();
        authorizationPage.setLogin(Configuration.LOGIN);
        takeScreenshot();
        if(! authorizationPage.isPresentPasswordField()){
            authorizationPage.enter.click();
        }
        authorizationPage.setPassword(Configuration.PASSWORD);
        authorizationPage.enter.click();
    }
}