package com.platts.oil.analytics.irr.uat.questions;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class DisplayedMarketIndex implements Question<List<MarketAnalysisData>> {

    public List<MarketAnalysisData> answeredBy(Actor actor) {
        List<MarketAnalysisData> marketInsightIndex = new ArrayList<>();
        Long numArticles = getIndexLength(actor);
        for(int i = 0; i < numArticles; i++) {
            if(checkIndexVisible(actor, i)) marketInsightIndex.add(getIndexItemData(actor, i));
        }
        return marketInsightIndex;
    }

    private MarketAnalysisData getIndexItemData(Actor actor, int index) {
        MarketAnalysisData marketData = new MarketAnalysisData();
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript
                (String.format(MarketInsightPage.ARTICLE_ID_FOR_INDEX_ARTICLES, index));
        String title = getElementText(actor, String.format(MarketInsightPage.INDEX_ARTICLE_TITLE_JS, index));
        marketData.setId(id);
        marketData.setTitle(title);
        return marketData;
    }

    private boolean checkIndexVisible(Actor actor, int index) {
        return (boolean) BrowseTheWeb.as(actor).evaluateJavascript(String.format(MarketInsightPage.INDEX_ARTICLE_VISIBLE_JS, index));
    }

    private Long getIndexLength(Actor actor) {
        return (Long) BrowseTheWeb.as(actor).evaluateJavascript(MarketInsightPage.NUMBER_OF_ARTICLES_IN_INDEX);
    }

    private String getElementText(Actor actor, String js) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(js);
        return BrowseTheWeb.as(actor).findBy("#"+id+"-innerCt").getText();
    }

}
