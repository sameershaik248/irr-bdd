package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import com.platts.oil.analytics.irr.uat.tasks.ClickSenchaButton;
import com.platts.oil.analytics.irr.uat.tasks.ComponentDisplayed;
import com.platts.oil.analytics.irr.uat.tasks.EnterTextIntoField;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by jonathan_cone on 7/1/2016.
 */
public class MarketAnalysisEditorStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Given("$actor is on the Market Insight Editor page")
    public void i_am_on_the_market_insight_page(String actor) {

    }

    @Given("$actor is an editor and sees the POST button")
    public void i_am_an_editor(String actor) {
        theActorNamed(actor).should(seeThat(ComponentDisplayed.displayed(MarketInsightPage.POST_ARTICLE_LENGTH_JS,
                MarketInsightPage.POST_ARTICLE_ID_JS), equalTo(true)));
    }

    @Given("$actor sees the article editor")
    public void i_see_the_editor(String actor) {
        theActorNamed(actor).should(seeThat(ComponentDisplayed.displayed(MarketInsightPage.ARTICLE_EDITOR_WINDOW_LENGTH_JS,
                MarketInsightPage.ARTICLE_EDITOR_WINDOW_ID_JS), equalTo(true)));
    }

    @When("$actor clicks on the POST button")
    public void i_click_on_the_post_button(String actor) {
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(MarketInsightPage.POST_ARTICLE_ID_JS));
    }

    @When("$actor enters the article data into the editor")
    public void i_enter_data_into_the_editor(String actor) {
        theActorNamed(actor).attemptsTo(EnterTextIntoField.thisTextForComponent("July Insights", MarketInsightPage.ARTICLE_EDITOR_TITLE_JS));
    }

    @Then("$actor sees the article editor")
    public void i_see_the_article_editor(String actor) {
        theActorNamed(actor).should(seeThat(ComponentDisplayed.displayed(MarketInsightPage.ARTICLE_EDITOR_WINDOW_LENGTH_JS,
                MarketInsightPage.ARTICLE_EDITOR_WINDOW_ID_JS), equalTo(true)));
    }

    private WebDriver theBrowserBelongingTo(String actor) {
        switch (actor) {
            case "jane" :
                return janesBrowser;
            default:
                return janesBrowser;
        }
    }

}
