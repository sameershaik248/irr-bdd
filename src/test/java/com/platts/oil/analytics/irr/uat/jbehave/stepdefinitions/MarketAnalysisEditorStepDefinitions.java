package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import com.platts.oil.analytics.irr.uat.tasks.ComponentDisplayed;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by jonathan_cone on 7/1/2016.
 */
public class MarketAnalysisEditorStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Steps
    ComponentDisplayed theComponentDisplayed;

    @Given("$actor is on the Market Insight Editor page")
    public void i_am_on_the_market_insight_page(String actor) {

    }

    @Given("$actor is an editor and sees the POST button")
    public void i_am_an_editor(String actor) {
        theActorNamed(actor).should(seeThat(theComponentDisplayed.displayed(MarketInsightPage.POST_ARTICLE_LENGTH_JS, MarketInsightPage.POST_ARTICLE_ID_JS), equalTo(true)));
    }

    @When("$actor clicks on the POST button")
    public void i_click_on_the_post_button(String actor) {

    }

    @Then("$actor sees the article editor")
    public void i_see_the_article_editor(String actor) {

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
