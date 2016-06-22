package com.platts.oil.analytics.irr.uat.pages.components;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Created by jonathan_cone on 6/22/2016.
 */
public class Navigation extends PageObject {

    private static final String ALL_PLAYS_NAV_BUTTON = "ALL PLAYS";
    private static final String PLAY_DETAILS_NAV_BUTTON = "PLAY DETAILS";
    private static final String MARKET_INSIGHT_NAV_BUTTON = "MARKET INSIGHT";
    private static final String REFERENCE_NAV_BUTTON = "REFERENCE";

    public static final Target marketInsightButton = Target.the("Market Insight Nav Button")
            .located(By.linkText(MARKET_INSIGHT_NAV_BUTTON));
    public static final Target playDetailsButton = Target.the("Plays Details Nav Button")
            .located(By.linkText(PLAY_DETAILS_NAV_BUTTON));
    public static final Target bakkenPlayButton = Target.the("Bakken Play Button")
            .located(By.linkText("Bakken"));

}
