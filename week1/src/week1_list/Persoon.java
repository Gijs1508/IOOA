package week1_list;

import java.util.ArrayList;

public class Persoon {
    String naam;
    int leeftijd;
    public static ArrayList<Persoon> namenLijst = new ArrayList<Persoon>();

    public Persoon(String naam, int leeftijd){
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public Persoon(){

    }

    public String getNaam() {
        return this.naam;
    }

    public int getLeeftijd() {
        return this.leeftijd;
    }

    public String toString(){
        return String.format(this.naam + "\t" +  this.leeftijd);
    }

    public static String namenlijstOutput(){
        String output = "";

        for (Persoon persoon : namenLijst){
            output += persoon.toString() + "\n";
        }
        return output;
    }
}
