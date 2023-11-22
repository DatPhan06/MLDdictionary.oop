package com.example.myjavafxapp.translator;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class UrlToText {
    static String urlToText(URL url) throws IOException {
        URLConnection urlConn = url.openConnection(); //Open connection
        //Adding header for user agent is required. Otherwise, Google rejects the request
        urlConn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0) Gecko/20100101 Firefox/4.0");
        Reader r = new java.io.InputStreamReader(urlConn.getInputStream(), StandardCharsets.UTF_8);//Gets Data Converts to string
        StringBuilder buf = new StringBuilder();
        while (true) {//Reads String from buffer
            int ch = r.read();
            if (ch < 0)
                break;
            buf.append((char) ch);
        }
        return buf.toString();
    }
}
