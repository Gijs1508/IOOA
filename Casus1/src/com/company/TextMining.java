package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class TextMining {
    static String fileLocation = "C:/Users/cross/Desktop/hsleiden/Jaar1_Periode3/IOOA/casus/";
    
    public static void main(String[] args) {
        TextMining main = new TextMining();
        TextFileUtilities textReading = new TextFileUtilities();
        HashMap<String, Integer> word2frequency = new HashMap<String, Integer>();

        // Opdracht 3
        ArrayList<String> regels = textReading.leesRuweTekst(main.fileLocation);
        // print de regels in de console
        //textReading.toonTekst(regels);

        textReading.zetTekstOmInWoorden(regels);

        // Opdracht 6
        word2frequency = textReading.telWoorden(regels, word2frequency);
        // print de hashmap in de console
        // textReading.toonHashMap(word2frequency);

        // Opdracht 7
        textReading.schrijfWoordFrequentieNaarFile(main.fileLocation, word2frequency);
    }
}
