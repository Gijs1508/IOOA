package week2_fig;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Figuur {
    public double lengteZijde1 = 1.0;
    public double lengteZijde2 = 1.0;
    public double lengteZijde3 = 1.0;
    public String achtergrondkleur = "Wit";
    public String omtrekkleur = "Zwart";


    public static void main(String[] args) {
        Driehoek driehoek = new Driehoek(5, 5, 5, "Blauw", "Grijs");
        Vierkant vierkant = new Vierkant(4, "Groen", "Geel");
        Vierhoek vierhoek = new Vierhoek(3, 6, "Paars", "Rood");

        ArrayList<Figuur> figuren = new ArrayList<Figuur>(Arrays.asList(driehoek, vierkant, vierhoek));
        System.out.println(driehoek.showInfo());
        System.out.println(vierkant.showInfo());
        System.out.println(vierhoek.showInfo());

    }

    public double getLengteZijde1() {
        return lengteZijde1;
    }

    public double getLengteZijde2() {
        return lengteZijde2;
    }

    public double getLengteZijde3() {
        return lengteZijde3;
    }

    public String getAchtergrondkleur() {
        return achtergrondkleur;
    }

    public String getOmtrekKleur(){
        return omtrekkleur;
    }

    public void setLengteZijde1(double number){
        this.lengteZijde1 = number;
    }

    public void setLengteZijde2(double number){
        this.lengteZijde2 = number;
    }

    public void setLengteZijde3(double number){
        this.lengteZijde3 = number;
    }

    public void setAchtergrondKleur(String kleur){
        this.achtergrondkleur = kleur;
    }

    public void setOmtrekKleur(String kleur){
        this.omtrekkleur = kleur;
    }

}
