package week2_fig;

public class Driehoek extends Figuur{

    public Driehoek(){}

    public Driehoek(int lengteZijde1, int lengteZijde2, int lengteZijde3, String achtergrondkleur, String omtrekkleur){
        this.lengteZijde1 = lengteZijde1;
        this.lengteZijde2 = lengteZijde2;
        this.lengteZijde3 = lengteZijde3;
        this.achtergrondkleur = achtergrondkleur;
        this.omtrekkleur = omtrekkleur;
    }

    public double berekenOmtrek(){
        return this.lengteZijde1 + this.lengteZijde2 + this.lengteZijde3;
    }


    public String showInfo(){
        return String.format("De zijdes hebben de lengtes %s, %s en %s, die ervoor zorgen dat de driehoek een omtrek van %s heeft.", this.lengteZijde1, this.lengteZijde2, this.lengteZijde3, berekenOmtrek());
    }

}
