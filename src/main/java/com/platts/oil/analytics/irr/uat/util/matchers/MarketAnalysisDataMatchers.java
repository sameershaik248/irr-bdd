package com.platts.oil.analytics.irr.uat.util.matchers;

import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.List;

/**
 * Created by connor_hendrix on 6/23/2016.
 */
public class MarketAnalysisDataMatchers {

    public static Matcher<MarketAnalysisData> hasSameId(final MarketAnalysisData expectedArticle) {
        return new BaseMatcher<MarketAnalysisData>() {
            @Override
            public boolean matches(final Object item) {
                final MarketAnalysisData article = (MarketAnalysisData) item;
                return expectedArticle.getId().equals(article.getId());
            }
            @Override
            public void describeTo(final Description description) {
                description.appendText("getId should return ").appendValue(expectedArticle.getId());
            }
        };
    }

    public static Matcher<List<MarketAnalysisData>> hasSameContents(final List<MarketAnalysisData> expectedArticleList) {
        return new BaseMatcher<List<MarketAnalysisData>>() {
            @Override
            public boolean matches(final Object list) {
                final List<MarketAnalysisData> listOfArticles = (List<MarketAnalysisData>) list;
                for(int i = 0; i < listOfArticles.size(); i++) {
                    boolean result = expectedArticleList.get(i).getId().equals(listOfArticles.get(i).getId());
                    if(!result) return false;
                }
                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("List of articles should return ").appendValue(true);
            }
        };
    }
}
