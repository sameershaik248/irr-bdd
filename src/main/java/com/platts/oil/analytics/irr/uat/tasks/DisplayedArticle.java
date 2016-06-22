package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class DisplayedArticle implements Question<Boolean> {

    public Boolean answeredBy(Actor actor) {
        // Create new model
        String heading = getElementText(actor, MarketInsightPage.CURRENT_ARTICLE_HEADING_JS);
        String publishedDate = getElementText(actor, MarketInsightPage.CURRENT_ARTICLE_DATE_JS);
        String content = getElementText(actor, MarketInsightPage.CURRENT_ARTICLE_CONTENT_JS);
        return true;
    }

    private String getElementText(Actor actor, String js) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(js);
        return BrowseTheWeb.as(actor).findBy("#"+id);
    }

}
