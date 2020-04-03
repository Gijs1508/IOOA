package model;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class Balie {

	private ArrayBlockingQueue<Bestelling> bestellingen = null;
	private ArrayBlockingQueue<Maaltijd> maaltijden = null;

	public Balie() {
		this.bestellingen = new ArrayBlockingQueue<Bestelling>(20);
		this.maaltijden = new ArrayBlockingQueue<Maaltijd>(20);
	}

	// Nieuwe bestelling plaatsen die kok de bereidt
	public void plaatsBestelling(Bestelling b) throws InterruptedException {bestellingen.put(b);}

	// Er zijn nog bestellingen om te bereiden
	public boolean erZijnNogBestellingen() {
		return !bestellingen.isEmpty();
	}
		
	// Kok pakt bestelling om te bereiden
	public Bestelling pakBestelling() throws InterruptedException {
		Bestelling res = null;
		if(erZijnNogBestellingen()){
			res = bestellingen.take();
		}
		return res;
	}

	// Kok plaatst maaltijd voor bezorging
	public void plaatsMaaltijd(Maaltijd m) throws InterruptedException {maaltijden.put(m);}

	// Er zijn nog maaltijden die ober kan bezorgen
	public boolean erZijnNogMaaltijden() {
		return !maaltijden.isEmpty();
	}

	// Ober pakt een maaltijd om te bezorgen
	public Maaltijd pakMaaltijd() throws InterruptedException {
		Maaltijd res = null;
		res = maaltijden.take();
		return res;
	}
	
	public void genereerBestellingen() throws InterruptedException {
		for (int i = 0; i < Restaurant.AANTALBESTELLINGEN; i++) {
			int tafelnummer = Util.randInt(1, Restaurant.AANTALTAFELS);
			int bereidingstijd = Util.randInt(Restaurant.MINIMALE_BEREIDINGSTIJD, Restaurant.MAXIMALE_BEREIDINGSTIJD);
			Bestelling b = new Bestelling(bereidingstijd, tafelnummer);
			this.plaatsBestelling(b);
		}
	}

	public ArrayBlockingQueue<Bestelling> getBestellingen() {
		return this.bestellingen;
	}
}
