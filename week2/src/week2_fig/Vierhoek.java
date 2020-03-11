package week2_fig;

public class Vierhoek extends Figuur{

    public Vierhoek(){
        this.lengteZijde1 = 1.0;
        this.lengteZijde2 = 1.0;
        this.achtergrondkleur = "Wit";
        this.omtrekkleur = "Zwart";
    }

    public Vierhoek(double lengteZijde1, double lengteZijde2, String achtergrondkleur, String omtrekkleur){
        this.lengteZijde1 = lengteZijde1;
        this.lengteZijde2 = lengteZijde2;
        this.achtergrondkleur = achtergrondkleur;
        this.omtrekkleur = omtrekkleur;
    }

    public double berekenOmtrek(){
        return (this.lengteZijde1 * 2) + (this.lengteZijde2 * 2);
    }


    public String showInfo(){
        return String.format("De zijdes hebben de lengtes %s en %s, die ervoor zorgen dat de vierhoek een omtrek van %s heeft.", this.lengteZijde1, this.lengteZijde2, berekenOmtrek());
    }
}
