package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Created by jonathan_cone on 7/6/2016.
 */
public class InputArticleContent implements Task {

    private MarketAnalysisData sampleData;

    public InputArticleContent(MarketAnalysisData sampleData) {
        this.sampleData = sampleData;
    }

    @Step("{0} inputs content into article editor")
    public<T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterTextIntoField.thisTextForComponent(sampleData.getTitle(), MarketInsightPage.ARTICLE_EDITOR_TITLE_JS));
        actor.attemptsTo(EnterTextIntoTinyMce.withText(sampleData.getBody()));
        actor.attemptsTo(EnterTextIntoTextarea.thisTextForComponent(sampleData.getSlug(), MarketInsightPage.ARTICLE_EDITOR_EXERPT_JS));
    }

    public static InputArticleContent doInput(MarketAnalysisData sampleData) { return instrumented(InputArticleContent.class, sampleData);  }

}
