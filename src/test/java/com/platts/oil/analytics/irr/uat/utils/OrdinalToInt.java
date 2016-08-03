package com.platts.oil.analytics.irr.uat.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathan_cone on 8/3/2016.
 */
public enum OrdinalToInt {

    INSTANCE;
    private static final Map<String, Integer> ordinalMap = Collections.unmodifiableMap(initializeMap());

    private static Map<String, Integer> initializeMap() {
        Map<String, Integer> mMap = new HashMap<>();
        mMap.put("first", 1);
        mMap.put("second", 2);
        mMap.put("third", 3);
        mMap.put("fourth", 4);
        mMap.put("fifth", 5);
        mMap.put("sixth", 6);
        mMap.put("seventh", 7);
        mMap.put("eighth", 8);
        mMap.put("ninth", 9);
        mMap.put("tenth", 10);
        mMap.put("latest", 1);
        return mMap;
    }

    public Integer getIntegerForOrdinal(String ordinal) throws Exception {
        Integer result = ordinalMap.get(ordinal.toLowerCase());
        if(result != null) {
            return result;
        } else {
            throw new Exception("No match for that ordinal: "+ordinal);
        }
    }

}
