package model;

import java.util.concurrent.TimeUnit;

public class Ober implements Runnable {

	private String id;
	private Balie balie = null;
	private static final int BEZORGTIJD = 10;

	public Ober(String id, Balie balie) {
		this.id = id;
		this.balie = balie;
	}

	public void bezorgMaaltijden() throws InterruptedException {
		int x = 0;
		while (balie.erZijnNogBestellingen()) {
			Maaltijd maaltijd = balie.pakMaaltijd();
			bezorgMaaltijd(maaltijd);
		}
		if(x == 0 && balie.getBestellingen().size() == 0) {
			Maaltijd maaltijd = balie.pakMaaltijd();
			bezorgMaaltijd(maaltijd);
			x = 1;
		}
	}

	private void bezorgMaaltijd(Maaltijd m) {
		try {
			TimeUnit.MILLISECONDS.sleep(BEZORGTIJD);
			System.out.println("Ober " + this.id + " bezorgt maaltijd " + m.getTafelnummer());
		}
		catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		try {
			bezorgMaaltijden();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
