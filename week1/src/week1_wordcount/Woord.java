package week1_wordcount;

import week1_list.Persoon;

import java.util.ArrayList;

public class Woord {
    String woord;
    int teller;
    public static ArrayList<Woord> woordenLijst = new ArrayList<Woord>();



    public Woord(String woord, int teller){
        this.woord = woord;
        this.teller = teller;
    }

    public String toString(){
        return String.format(this.woord + "\t" +  this.teller);
    }

    public static String getWoord() {
        return String.format(this.woord);
    }

    public static String namenlijstOutput(){
        String output = "";

        for (Woord woord : woordenLijst){
            output += woord.toString() + "\n";
        }
        return output;
    }
}
