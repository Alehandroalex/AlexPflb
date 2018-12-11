package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.LetterPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

public class LetterPageSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(LetterPageSteps.class);

    LetterPage letterPage;

    public LetterPageSteps(Context context){
        super(context);
        LOGGER.debug("LetterPageSteps is created");
        letterPage = context.getPageObjectManager().getLetterPage();
    }

    @Then("^write email recipient \"([^\"]*)\"$")
    public void writeEmailRecipient(String recipient) throws Throwable{
        letterPage.recipient.sendKeys(recipient);
    }

    @And("^write message subject topic \"([^\"]*)\"$")
    public void writeMessageSubjectTopic(String topic) throws Throwable{
        letterPage.topicField.sendKeys(topic);
    }

    @And("^write text \"([^\"]*)\"$")
    public void writeText(String text) throws Throwable{
        letterPage.bodyOfLetter.sendKeys(text);
    }

    @Then("^close letter$")
    public void closeLetter() throws Throwable{
        letterPage.closeLetter.click();
    }

    @And("^click button send$")
    public void clickButtonSend() throws Throwable{
        letterPage.sentLetter.click();
    }
}