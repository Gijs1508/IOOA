package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextFileUtilities {

    // Opdracht 2
    public static ArrayList<String> leesRuweTekst(String fileLocation) {
        // hier worden de regels in gezet
        ArrayList<String> Regels = new ArrayList<String>();
        try {
            // instantieer het bestand dat gebruikt gaat worden
            FileInputStream file = new FileInputStream(fileLocation + "dik_trom.txt");
            // lees het bestand uit
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String regel = myReader.nextLine();
                if(!regel.isEmpty()) { //check of de zin niet leeg is
                    // voeg de regel toe aan de arraylist
                    Regels.add(regel);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Regels;


    }

    // Opdracht 3
    public void toonTekst(ArrayList<String> regels) {
        // pak elke losse regel en print die
        for (int i = 0; i < regels.size(); i++) {
            System.out.println(regels.get(i));
        }
    }

    // Opdracht 4
    public ArrayList<String[]> zetTekstOmInWoorden(ArrayList<String> regels){
        ArrayList<String[]> opgeschoondeWoorden = new ArrayList<String[]>();
        for (String regel : regels) {
            // Zet alle woorden uit de zin in een array
            String[] woorden = regel.split(" ");
            // voeg de array met losse woorden toe aan de ArrayList 
            opgeschoondeWoorden.add(opSchonenWoord(woorden));
        }
        // Alle opgeschoonde woorden tonen (opdracht 5)
        // toonWoorden(opgeschoondeWoorden);

        return opgeschoondeWoorden;
    }

    // Opdracht 5
    public String[] opSchonenWoord(String[] woorden) {
        // Pak alle losse woorden uit de woorden array
        for (int j = 0; j < woorden.length; j++) {
            // Haal de spaties weg
            woorden[j] = woorden[j].trim();
            // Haal de hoofdletters weg
            woorden[j] = woorden[j].toLowerCase();
            // Haal alle non alfabetische tekens weg
            woorden[j] = woorden[j].replaceAll("[^A-Za-z]", "");
        }
        return woorden;
    }

    //Opdracht 6
    public HashMap<String, Integer> telWoorden(ArrayList<String> regels, HashMap<String, Integer> word2frequency){
        ArrayList<String[]> woorden = zetTekstOmInWoorden(regels);
        // Pak de losse arrays die gevuld zijn met woorden
        for (int j = 0; j < woorden.size(); j++) {
            // Pak de losse woorden uit de arrays
            for (int i = 0; i < woorden.get(j).length; i++) {
                String woord = woorden.get(j)[i];
                // Check of het woord al in de hashmap zit
                if(!word2frequency.containsKey(woord)){
                    // zo niet, voeg het woord toe 
                    word2frequency.put(woord, 1);
                } else {
                    // als het woord er wel in zit, update m dan met de integer + 1
                    word2frequency.put(woord, word2frequency.get(woord) + 1);
                }
            }

        }
        // Sorteer de HashMap
        return sortByValue(word2frequency);
    }

    // Hier wordt de hashmap gesorteerd op value
    public static HashMap<String, Integer> sortByValue(final HashMap<String, Integer> word2freq) {
        return word2freq.entrySet()
                .stream()
                .sorted((HashMap.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    // Opdracht 7
    public void schrijfWoordFrequentieNaarFile(String fileLocation, HashMap<String, Integer> word2freq)  {
        try {
            String file = fileLocation + "results.txt";
            File outputFile = new File(file);
            if(outputFile.createNewFile()){
                System.out.println("Bestand aangemaakt. Ik voeg de resultaten toe.");
                voegToeAanBestand(file, word2freq);
            } else {
                System.out.println("Bestand bestond al, dus ik update de inhoud.");
                voegToeAanBestand(file, word2freq);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void voegToeAanBestand(String outputFile, HashMap<String, Integer> word2freq){
        try {
            FileWriter fileToWrite = new FileWriter(outputFile);

            for(String i : word2freq.keySet()) {
                fileToWrite.write(i + "\t" + word2freq.get(i) + "\n");
            }
            fileToWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Opdracht 5 : woorden tonen in console
    public void toonWoorden(ArrayList<String[]> opgeschoondeWoorden) {
        for (int j = 0; j < opgeschoondeWoorden.size(); j++) {
            for (int i = 0; i < opgeschoondeWoorden.get(j).length; i++) {
                System.out.println(opgeschoondeWoorden.get(j)[i]);
            }
        }
    }

    // Opdracht 6: hashmap printen in console
    public void toonHashMap(HashMap<String, Integer> word2freq){
        for(String i : word2freq.keySet()){
            System.out.println(i + "\t" + word2freq.get(i));
        }
    }
}
