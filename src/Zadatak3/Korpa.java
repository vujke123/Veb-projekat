package Zadatak3;

import java.util.ArrayList;

public class Korpa extends Vrednosno {
	

	//	● privatni niz zapisa o artiklima u korpi ​sadržaj​, privatni podatak ​max​ tipa integer koji 
	//predstavlja maksimalnu vrednost potrošačke korpe;
	private ArrayList<Zapis> sadrzaj = new ArrayList<Zapis>();
	private int max;
	
	//	● konstruktor koji dobija maksimalnu vrednost korpe;
	public Korpa(int max) {
		this.max = max;
	}
	
	//	● metodu ​dodaj​ koja prima zapis o atriklu i smešta ga u sadržaj, ako bi vrednost korpe prešla
	//	dozvoljenu diže grešku;
	public void dodaj(Zapis zapis) {
		if(sadrzaj.size() < max) {
			this.sadrzaj.add(zapis);
		}
		else {
			Exception e = new Exception("Vrednost korpe presla maksimalnu.");
			e.printStackTrace();
		}
	}

	
	//	● vrednost korpe prestavlja sumu vrednosti svih artikala u njoj;
	@Override
	public double vrednost() {
		double pom = 0;
		for(int i = 0; i < this.sadrzaj.size(); ++i) {
			pom += this.sadrzaj.get(i).getVrednost();
		}
		return pom;
	}
	
	//	● string reprezentacija sadrži zapise o svim atriklima u njoj i to u formi [(naziv artikla, količina,
	//	jedinica mere i vrednost artikla),[(naziv artikla, količina, jedinica mere i vrednost artikla),...].
	@Override
	public String toString() {
		String povratna = "[";
		
		for(int i = 0; i < this.sadrzaj.size(); i++) {
			povratna += "(" + this.sadrzaj.get(i).getArtikal().toString() + ", " 
					+ this.sadrzaj.get(i).getKolicina() + ", " 
					+ this.sadrzaj.get(i).getArtikal().getJm().toString() + ", " 
					+ this.sadrzaj.get(i).getVrednost() + ")";
			if(i != (this.sadrzaj.size() - 1)) {
				povratna += ",";
			}
		}
		
		povratna += "]";
		return povratna;
	}
	
}
