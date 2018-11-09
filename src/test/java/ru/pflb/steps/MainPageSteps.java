package ru.pflb.steps;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import ru.pflb.pages.MainPage;
import ru.pflb.tech.BaseStep;
import ru.pflb.tech.Context;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class MainPageSteps extends BaseStep {

    MainPage mainPage;

    public MainPageSteps(Context context){
        super(context);
        mainPage = context.getPageObjectManager().getMainPage();
    }

    @Then("^login \"([^\"]*)\" appears near avatar$")
    public void loginAppearsNearAvatar(String login) throws Throwable{
        WebElement userNameElement = mainPage.getUserNameElement();
        assertThat(userNameElement.isDisplayed(), equalTo(true));
        assertThat(userNameElement.getText(), equalTo(login));
    }

}
