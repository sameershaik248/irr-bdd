package com.platts.oil.analytics.irr.uat.model;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;

/**
 * Created by jonathan_cone on 6/21/2016.
 */
public class Actors {
    public static Actor theActorNamed(String name) {

        if (!Serenity.hasASessionVariableCalled(name)) {
            Serenity.setSessionVariable(name).to(Actor.named(name));
        }
        return Serenity.sessionVariableCalled(name);
    }
}
