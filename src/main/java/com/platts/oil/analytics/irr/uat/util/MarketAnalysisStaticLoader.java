package com.platts.oil.analytics.irr.uat.util;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;
import com.platts.oil.analytics.irr.uat.model.MarketAnalysisData;

/**
 * Created by connor_hendrix on 6/22/2016.
 */
public class MarketAnalysisStaticLoader {

    public static MarketAnalysisStaticLoader getLoader() {
        return new MarketAnalysisStaticLoader();
    }

    public  List<MarketAnalysisData> loadFromFile() {

        List<MarketAnalysisData> mAnalysisRows = new ArrayList<>();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File inputFile = new File(classLoader.getResource("market_analysis_test_data.xml").getFile());
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList rowList = doc.getElementsByTagName("ROW");
            for (int temp = 0; temp < rowList.getLength(); temp++) {
                Node nNode = rowList.item(temp);
                    Element eElement = (Element) nNode;
                    NodeList columns = eElement.getElementsByTagName("COLUMN");
                    DateFormat format = new SimpleDateFormat("dd-MMM-yy");

                    MarketAnalysisData row = new MarketAnalysisData(columns.item(0).getTextContent(),
                            columns.item(1).getTextContent(),
                            columns.item(2).getTextContent(),
                            columns.item(3).getTextContent(),
                            format.parse(columns.item(4).getTextContent()),
                            columns.item(5).getTextContent().equals("1"));
                    mAnalysisRows.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mAnalysisRows;
    }
}
