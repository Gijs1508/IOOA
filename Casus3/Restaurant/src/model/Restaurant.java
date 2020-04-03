package model;

public class Restaurant{

	private Kok Kok = null;
	private Ober Ober = null;
	public static final int AANTALTAFELS = 10;
	public static final int AANTALBESTELLINGEN = 20;
	public static final int MINIMALE_BEREIDINGSTIJD = 750;
	public static final int MAXIMALE_BEREIDINGSTIJD = 1500;

	public Restaurant() {
	}

	public void start() throws InterruptedException {
		Balie balie = new Balie();
		balie.genereerBestellingen();
		new Thread(new Kok("1", balie)).start();
		new Thread(new Kok("2", balie)).start();
		new Thread(new Ober("1", balie)).start();
		new Thread(new Ober("2", balie)).start();
	}
}
