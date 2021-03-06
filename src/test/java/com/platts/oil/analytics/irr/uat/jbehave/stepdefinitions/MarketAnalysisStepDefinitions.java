package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.model.AppPages;
import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import com.platts.oil.analytics.irr.uat.pages.components.Navigation;
import com.platts.oil.analytics.irr.uat.questions.DisplayedArticle;
import com.platts.oil.analytics.irr.uat.questions.DisplayedMarketIndex;
import com.platts.oil.analytics.irr.uat.questions.DisplayedPage;
import com.platts.oil.analytics.irr.uat.tasks.*;
import com.platts.oil.analytics.irr.uat.util.*;
import com.platts.oil.analytics.irr.uat.utils.OrdinalToInt;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static com.platts.oil.analytics.irr.uat.util.matchers.MarketAnalysisDataMatchers.hasSameId;
import static com.platts.oil.analytics.irr.uat.util.matchers.MarketAnalysisDataMatchers.hasSameContents;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class MarketAnalysisStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Steps
    DisplayedArticle theDisplayedArticle;
    @Steps
    DisplayedMarketIndex theDisplayedMarketIndex;
    @Steps
    DisplayedPage theDisplayedPage;

    @Given("$actor is logged into the WEA application with username $username and password $password")
    public void i_am_logged_into_wea(String actor, String username, String password) {
        theActorNamed(actor).attemptsTo(LoginToApp.withUsernameAndPassword(username, password));
    }

    @Given("$actor is on the Market Insight page")
    public void i_am_on_the_market_insight_page(String actor) {
        theActorNamed(actor).should(seeThat(theDisplayedPage, equalTo(AppPages.MarketInsight)));
    }

    @Given("$actor clicked on the Market Insight link")
    public void i_clicked_on_the_market_insight_link(String actor) {
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(Navigation.MARKET_INSIGHT_NAV_BUTTON_JS));
    }

    @When("$actor clicks on the Market Insight page")
    public void i_click_on_the_page(String actor) {
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(Navigation.MARKET_INSIGHT_NAV_BUTTON_JS));
    }

    @When("$actor selects the $index article from the index")
    public void i_select_the_first_article_from_index(String actor, String ordinal) throws Throwable {
        Integer index = OrdinalToInt.INSTANCE.getIntegerForOrdinal(ordinal);
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(MarketInsightPage.articleForIndex(--index)));
    }

    @Then("$actor sees the $selected Market Insight article")
    public void i_see_the_latest_market_analysis(String actor, String selected) throws Throwable {
        // Check that the actor is on the right page
        theActorNamed(actor).should(seeThat(theDisplayedPage, equalTo(AppPages.MarketInsight)));

        // Load our static data for page comparison
        List<MarketAnalysisData> articleList = MarketAnalysisStaticLoader.getLoader().loadFromFile();
        int index = OrdinalToInt.INSTANCE.getIntegerForOrdinal(selected);
        MarketAnalysisData currentArticle = articleList.get(--index);

        // Compare the static data with the page data
        theActorNamed(actor).should(seeThat(theDisplayedArticle, hasSameId(currentArticle)));

    }

    @Then("$actor sees the Market Insight index")
    public void i_see_the_page_index(String actor) {

        List<MarketAnalysisData> articleList = MarketAnalysisStaticLoader.getLoader().loadFromFile();
        theActorNamed(actor).should(seeThat(theDisplayedMarketIndex, hasSameContents(articleList)));

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
