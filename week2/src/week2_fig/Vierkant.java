package week2_fig;

public class Vierkant extends Figuur{
    public Vierkant(){
        this.lengteZijde1 = 1.0;
        this.achtergrondkleur = "Wit";
        this.omtrekkleur = "Zwart";
    }

    public Vierkant(double lengteZijde1, String achtergrondkleur, String omtrekkleur){
        this.lengteZijde1 = lengteZijde1;
        this.achtergrondkleur = achtergrondkleur;
        this.omtrekkleur = omtrekkleur;
    }

    public double berekenOmtrek(){
        return this.lengteZijde1 * 4;
    }


    public String showInfo(){
        return String.format("De zijdes hebben de lengtes %s, die ervoor zorgen dat de vierkant een omtrek van %s heeft.", this.lengteZijde1, berekenOmtrek());
    }
}
