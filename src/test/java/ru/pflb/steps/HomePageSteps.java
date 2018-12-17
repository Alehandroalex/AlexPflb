package ru.pflb.steps;

import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.HomePage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

public class HomePageSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(HomePageSteps.class);

    private HomePage homePage;

    public HomePageSteps(Context context){
        super(context);
        LOGGER.debug("HomePageSteps is created");
        homePage = context.getPageObjectManager().getHomePage();
    }

    @Then("^should be button \"([^\"]*)\"$")
    public void shouldBeButton(String arg0) throws Throwable{
        homePage.getToGetMail().isDisplayed();
    }

}