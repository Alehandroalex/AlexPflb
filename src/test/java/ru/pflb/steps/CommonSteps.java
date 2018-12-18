package ru.pflb.steps;

import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.CommonPage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

public class CommonSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class);

    private CommonPage commonPage;

    public CommonSteps(Context context){
        super(context);
        LOGGER.debug("CommonSteps is created");
        commonPage = new CommonPage(getDriver());
    }

    @Then("^should appears the text \"([^\"]*)\"$")
    public void shouldAppearsTheText(String text){
        commonPage.getElementWithText(text).isDisplayed();
    }


}
