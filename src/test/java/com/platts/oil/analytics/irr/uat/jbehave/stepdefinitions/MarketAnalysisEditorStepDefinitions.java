package com.platts.oil.analytics.irr.uat.jbehave.stepdefinitions;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import com.platts.oil.analytics.irr.uat.tasks.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static com.platts.oil.analytics.irr.uat.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static com.platts.oil.analytics.irr.uat.util.matchers.MarketAnalysisDataMatchers.hasSameTitle;


/**
 * Created by jonathan_cone on 7/1/2016.
 */
public class MarketAnalysisEditorStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Steps DisplayedArticle theDisplayedArticle;

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

    @When("$actor enters the article data into the editor and published the content")
    public void i_enter_data_into_the_editor(String actor) {
        MarketAnalysisData sampleData = getSampleArticle();
        theActorNamed(actor).attemptsTo(InputArticleContent.doInput(sampleData));
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(MarketInsightPage.ARTICLE_EDITOR_PUBLISH_JS));
    }

    @When("$actor clicks to Delete the current article")
    public void i_click_to_delete_the_article(String actor) {
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(MarketInsightPage.DELETE_ARTICLE_ID_JS));
        theActorNamed(actor).attemptsTo(ClickSenchaButton.forComponent(MarketInsightPage.CONFIRM_DELETE_ARTICLE_ID_JS));
    }

    @Then("$actor sees the article they just published on Market Insight Page")
    public void i_see_the_published_article(String actor) {
        MarketAnalysisData sampleData = getSampleArticle();
        theActorNamed(actor).should(seeThat(theDisplayedArticle, hasSameTitle(sampleData)));
    }

    @Then("$actor sees the article editor")
    public void i_see_the_article_editor(String actor) {
        theActorNamed(actor).should(seeThat(ComponentDisplayed.displayed(MarketInsightPage.ARTICLE_EDITOR_WINDOW_LENGTH_JS,
                MarketInsightPage.ARTICLE_EDITOR_WINDOW_ID_JS), equalTo(true)));
    }

    // Load sample data for entry into Insight Editor
    private MarketAnalysisData getSampleArticle() {
        MarketAnalysisData sampleData = new MarketAnalysisData();
        sampleData.setTitle("July IRR Commentary");
        sampleData.setSlug("• Oil plays receive a minor bump to IRR as gas plays continue to slip\n" +
            "• Marcellus Wet has been split into two separate plays, to account for multiple natural gas price points\n" +
            "• As the STACK play develops, returns are proving to be impressive");
        sampleData.setBody(loadArticleContent());
        return sampleData;
    }

    private String loadArticleContent() {
        try {
            return Files.readAllLines(Paths.get(ClassLoader.getSystemResource("article_content.txt").toURI()), Charset.defaultCharset())
                    .stream().collect(Collectors.joining("<br/>"));
        } catch (Exception e) {
            return null;
        }
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
