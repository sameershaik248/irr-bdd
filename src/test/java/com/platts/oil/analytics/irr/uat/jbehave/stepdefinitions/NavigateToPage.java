package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.tasks.LoginToApp;
import com.platts.oil.analytics.irr.uat.tasks.OpenAnApp;
import com.platts.oil.analytics.irr.uat.util.MarketAnalysisStaticLoader;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class NavigateToPage {

    @Managed
    WebDriver janesBrowser;

    @Given("$actor is logged into the $app application with username $username and password $password")
    public void i_am_logged_into_wea(String actor, String app, String username, String password) {
        theActorNamed(actor).attemptsTo(LoginToApp.withUsernameAndPassword(username, password));
    }

    @When("$actor clicks on the $page page")
    public void i_click_on_the_page(String actor) {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBelongingTo(actor)));
    }

    @Then("$actor sees the latest $page")
    public void i_see_the_latest_market_analysis(String actor) {
        List<MarketAnalysisData> list = MarketAnalysisStaticLoader.getLoader().loadFromFile();
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBelongingTo(actor)));
    }

    @WhenPageOpens
    private void loginUser(String actor) {

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
