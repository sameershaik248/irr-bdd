package com.platts.oil.analytics.irr.uat.tasks;

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

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class DisplayedMarketIndex implements Question<ArrayList<MarketAnalysisData>> {

    public ArrayList<MarketAnalysisData> answeredBy(Actor actor) {
        ArrayList<MarketAnalysisData> marketInsightIndex = new ArrayList<>();
        int numArticles = getIndexLength(actor);
        for(int i = 1; i < numArticles; i++) {
            marketInsightIndex.add(getIndexItemData(actor, i));
        }
        return marketInsightIndex;
    }

    private MarketAnalysisData getIndexItemData(Actor actor, int index) {
        MarketAnalysisData marketData = new MarketAnalysisData();
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript
                (String.format(MarketInsightPage.ARTICLE_ID_FOR_INDEX_ARTICLES, index));
        String title = getElementText(actor, index, MarketInsightPage.INDEX_ARTICLE_TITLE_JS);
        String pubDate = getElementText(actor, index, MarketInsightPage.INDEX_ARTICLE_DATE_JS);
        marketData.setId(id);
        marketData.setTitle(title);
        Date publishDate;
        try {
            DateFormat df = new SimpleDateFormat("d M, Y");
            publishDate = df.parse(pubDate);
        } catch (ParseException e) {
            System.out.println(pubDate);
            publishDate = null;
        }
        marketData.setPublishedDate(publishDate);
        return marketData;
    }

    private int getIndexLength(Actor actor) {
        return (int) BrowseTheWeb.as(actor).evaluateJavascript(MarketInsightPage.NUMBER_OF_ARTICLES_IN_INDEX);
    }

    private String getElementText(Actor actor, int index, String js) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(js);
        return BrowseTheWeb.as(actor).findBy("#"+id).getText();
    }

}
