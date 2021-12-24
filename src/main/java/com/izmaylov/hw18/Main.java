package com.izmaylov.hw18;

import com.izmaylov.hw18.model.Box;
import com.izmaylov.hw18.parser.ParsFrom;

public class Main {
    public static void main(String[] args) {
        Box boxXml = ParsFrom.xml("practiceXml.xml");
        System.out.println(boxXml);
        Box boxJson = ParsFrom.json("practiceJson.json");
        System.out.println(boxJson);
    }
}
