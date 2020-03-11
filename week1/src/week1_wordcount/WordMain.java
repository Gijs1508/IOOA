package week1_wordcount;

import week1_list.Persoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordMain {
    String dirPath = "C:/Users/cross/Desktop/";
    File filePath = new File(dirPath + "wordcount.txt");

    public void readWords() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line = br.readLine();
        String[] words = line.split(" ");

        for (int x = 0; x < words.length; x++) {
            if(words[x].contains("?")){
                words[x] = words[x].replace("?", "");
            } else if(words[x].contains(".")){
                words[x] = words[x].replace(".", "");
            } else if(words[x].contains(",")){
                words[x] = words[x].replace(",", "");
            }

            System.out.println(Woord.woordenLijst.size());

            if(Woord.getWoord() == words[x]){
                Woord.woordenLijst.add(new Woord(words[x], Woord.woordenLijst.get(x).teller += 1));
            } else {
                Woord.woordenLijst.add(new Woord(words[x], 1));
            }
        }


        System.out.println(Woord.namenlijstOutput());

    }

    public static void printwordList(ArrayList<Woord> wordList){
        String output = "";

        for (Woord woord : wordList){
            output += woord.toString() + "\n";
        }
        System.out.println(output);
    }

    public static void main(String[] args) throws IOException {
        WordMain main = new WordMain();
        main.readWords();
    }
}
