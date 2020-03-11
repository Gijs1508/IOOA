package week1_list;

public class oef1 {
    Persoon[] personen = new Persoon[]{
            new Persoon("Gijs", 19),
            new Persoon("Mees", 18),
            new Persoon("Kasper", 17),
            new Persoon("Niels", 19),
            new Persoon("Koen", 17)
    };


    public static void main(String[] args) {
        oef1 main = new oef1();
        Persoon persoon = new Persoon();
        for(int y = 0; y < main.personen.length; y++){
            Persoon.namenLijst.add(main.personen[y]);
        }

        System.out.println(Persoon.namenlijstOutput());
    }
}
