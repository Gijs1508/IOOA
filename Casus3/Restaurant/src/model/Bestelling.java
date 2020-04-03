package model;

public class Bestelling {

	private int bereidingstijd;
    private int tafelnummer;
    
    public Bestelling(int bereidingstijd, int bestelNummer) {
    	this.bereidingstijd = bereidingstijd;
    	this.tafelnummer = bestelNummer;
    }

	public int getBereidingstijd() {
		return bereidingstijd;
	}

	public int getTafelnummer() {
		return tafelnummer;
	}
	
}