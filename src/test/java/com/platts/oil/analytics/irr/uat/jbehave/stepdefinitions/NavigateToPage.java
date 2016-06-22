package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.tasks.EnterTextIntoField;
import com.platts.oil.analytics.irr.uat.tasks.LoginToApp;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class NavigateToPage {

    @Managed
    WebDriver janesBrowser;

    @Steps
    EnterTextIntoField enterTextIntoField;

    @Given("$actor is logged into the WEA application")
    public void i_am_logged_into_wea(String actor) {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBeloningTo(actor)));
        theActorNamed(actor).attemptsTo(LoginToApp.withUsernameAndPassword("user@user.com", "user"));
    }

    @When("$actor clicks on the $page page")
    public void i_click_on_the_page(String actor) {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBeloningTo(actor)));
    }

    @Then("$actor sees the latest $page")
    public void i_see_the_latest_market_analysis(String actor) {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBeloningTo(actor)));
    }

    private WebDriver theBrowserBeloningTo(String actor) {
        switch (actor) {
            case "Jane" :
                return janesBrowser;
            default:
                return janesBrowser;
        }
    }

}
