package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.model.AppPages;
import com.platts.oil.analytics.irr.uat.pages.SinglePlayPage;
import com.platts.oil.analytics.irr.uat.pages.components.Navigation;
import com.platts.oil.analytics.irr.uat.tasks.ClickSenchaButton;
import com.platts.oil.analytics.irr.uat.tasks.DisplayedPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by jonathan_cone on 7/21/2016.
 */
public class SinglePlayStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Steps
    DisplayedPage theDisplayedPage;

    @When("$actor clicks on the $well play page")
    public void i_click_on_single_play_page(String actor, String well) {
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(Navigation.PLAY_DETAILS_NAV_BUTTON_JS));
        BrowseTheWeb.as(theActorNamed(actor)).waitForTextToAppear(well);
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(SinglePlayPage.SINGLE_MENU(well)));
    }

    @Then("$actor sees the $well single play page")
    public void i_should_see_the_single_play_page(String actor, String well) {
        theActorNamed(actor).should(seeThat(theDisplayedPage, equalTo(AppPages.SinglePlay)));
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
