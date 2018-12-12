package ru.pflb.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.pages.LetterPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

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

    @Then("^close the letter$")
    public void closeTheLetter() throws Throwable{
        letterPage.closeLetter.click();
    }

    @And("^click button send$")
    public void clickButtonSend() throws Throwable{
        letterPage.sentLetter.click();
    }

    @When("^recipient should equals to \"([^\"]*)\"$")
    public void recipientShouldEqualsTo(String recipient) throws Throwable{
        assertEquals(recipient, letterPage.recipient.getText());
    }

    @And("^topic should equals to \"([^\"]*)\"$")
    public void topicShouldEqualsTo(String topic) throws Throwable{
        assertEquals(topic, letterPage.topicField.getText());
    }

    @And("^body should equals to \"([^\"]*)\"$")
    public void bodyShouldEqualsTo(String body) throws Throwable{
        assertEquals(body, letterPage.bodyOfLetter.getText());
    }
}