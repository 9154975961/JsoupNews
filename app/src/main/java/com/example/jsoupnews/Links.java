package com.example.jsoupnews;

import java.util.ArrayList;
import java.util.List;

public class Links {

    private static List<String> links= new ArrayList<>();

    public static void addLinks (String link){
        links.add(link);
    }

    public static List<String> getLinks() {
        return links;
    }
}
