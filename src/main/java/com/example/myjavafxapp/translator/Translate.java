package com.example.myjavafxapp.translator;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import static com.example.myjavafxapp.translator.GoogleTranslate.*;
import static com.example.myjavafxapp.translator.UrlToText.*;

public class Translate {
    public static String translate(String text) throws IOException {
        return translate(Locale.getDefault().getLanguage(), text);
    }

    public static String translate(String targetLanguage , String text) throws IOException {
        return translate("auto", targetLanguage, text);
    }

    public static String translate(String sourceLanguage , String targetLanguage , String text) throws IOException {
        String urlText = generateURL(sourceLanguage, targetLanguage, text);
        String rawData = urlToText(new URL(urlText));//Gets text from Google
        String[] raw = rawData.split("\"");//Parses the JSON
        if (raw.length < 2) {
            return null;
        }
        JSONArray arr = new JSONArray(rawData);
        JSONArray arr1 = arr.getJSONArray(0);
        StringBuilder trans = new StringBuilder();
        for (int i = 0; i < arr1.length(); i++) {
            JSONArray arr2 = arr1.getJSONArray(i);
            trans.append(arr2.get(0).toString());
        }
        return trans.toString();//Returns the translation
    }
}
