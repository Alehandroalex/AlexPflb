package ru.pflb.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.pflb.models.Letter;
import ru.pflb.pages.LetterPage;
import ru.pflb.tech.step.BaseStep;
import ru.pflb.tech.step.Context;

import static org.hamcrest.Matchers.*;
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

    @And("^add letter's \"([^\"]*)\" recipient \"([^\"]*)\"$")
    public void addLetterSRecipient(String letterAlias, String recipient) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        if(letter.getRecipientList().size() > 0){
            letterPage.recipientField.sendKeys(" ");
        }
        letterPage.recipientField.sendKeys(recipient);
        letter.addRecipient(recipient);
    }

    @And("^set letter's \"([^\"]*)\" topic to \"([^\"]*)\"$")
    public void setLetterSTopicTo(String letterAlias, String topic) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        letterPage.topicField.sendKeys(topic);
        letter.setTopic(topic);
    }

    @And("^set letter's \"([^\"]*)\" body to \"([^\"]*)\"$")
    public void setLetterSBodyTo(String letterAlias, String body) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        letterPage.bodyField.sendKeys(body);
        letter.setBody(body);
    }

    @Then("^recipients should be as in \"([^\"]*)\"$")
    public void recipientsShouldBeAsIn(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        assertThat(letterPage.getRecipients(), containsInAnyOrder(letter.getRecipientList().toArray()));
    }

    @And("^topic should be as in \"([^\"]*)\"$")
    public void topicShouldBeAsIn(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        assertThat(letterPage.topicField.getAttribute("value"), equalTo(letter.getTopic()));
    }

    @And("^body should be as in \"([^\"]*)\"$")
    public void bodyShouldBeAsIn(String letterAlias) throws Throwable{
        Letter letter = context.getLetter(letterAlias);
        assertThat(letterPage.bodyField.getAttribute("value"), startsWith(letter.getBody()));
    }

    @Then("^close the letter$")
    public void closeTheLetter() throws Throwable{
        letterPage.closeLetter.click();
    }


    @And("^send the letter$")
    public void sendTheLetter() throws Throwable{
        letterPage.sentLetter.click();
    }

    @When("^recipient should equals to \"([^\"]*)\"$")
    public void recipientShouldEqualsTo(String recipient) throws Throwable{
        assertEquals(recipient, letterPage.recipientField.getText());
    }

    @And("^topic should equals to \"([^\"]*)\"$")
    public void topicShouldEqualsTo(String topic) throws Throwable{
        assertEquals(topic, letterPage.topicField.getText());
    }

    @And("^body should equals to \"([^\"]*)\"$")
    public void bodyShouldEqualsTo(String body) throws Throwable{
        assertEquals(body, letterPage.bodyField.getText());
    }
}