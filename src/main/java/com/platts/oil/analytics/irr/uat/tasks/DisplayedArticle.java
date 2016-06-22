package com.platts.oil.analytics.irr.uat.tasks;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import com.platts.oil.analytics.irr.uat.pages.MarketInsightPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.yaml.snakeyaml.error.Mark;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class DisplayedArticle implements Question<MarketAnalysisData> {

    public MarketAnalysisData answeredBy(Actor actor) {
        // Create new model
        MarketAnalysisData article = new MarketAnalysisData();
        String title = getElementText(actor, MarketInsightPage.CURRENT_ARTICLE_TITLE_JS);
        String publishedDate = getElementText(actor, MarketInsightPage.CURRENT_ARTICLE_DATE_JS);
        DateFormat df = new SimpleDateFormat("d M, Y");
        Date pblshDate;
        try {
            pblshDate = df.parse(publishedDate);
        } catch (ParseException e) {
            System.out.println(e);
            pblshDate = null;
        }
        article.setTitle(title);
        article.setPublishedDate(pblshDate);
        return article;
    }

    private String getElementText(Actor actor, String js) {
        String id = (String) BrowseTheWeb.as(actor).evaluateJavascript(js);
        return BrowseTheWeb.as(actor).findBy("#"+id).getText();
    }

}
