package Zadatak2;

import java.util.ArrayList;

public abstract class Proizvodjac implements Proizvodi {
	
	//● niz ​N​ objekata Proizvod
	//● niz float cene, čiji prvi element ima vrednost cene prvog proizvoda iz prethodnog niza, drugi drugog itd.
	//● string ime
	public ArrayList<Proizvod> N = new ArrayList<Proizvod>();
	public ArrayList<Float> cene = new ArrayList<Float>();
	private String ime;

	//● konstruktor koji prima ime
	public Proizvodjac(String ime) {
		this.ime = ime;
	}
	
	//● metodu ​dajListuProizvoda​ koja vraća niz proizvoda
	@Override
	public ArrayList<Proizvod> dajListuProizvoda() {
		return this.N;
	}
	
	//● apstraktanu metodu ​dodajProizvod​ koja prima objekat ​Proizvod​ i cenu
	public abstract void dodajProizvod(Proizvod proizvod, float cena);
	
	//● metodu ​nađiProizvod​ koja prima string sa nazivom proizvoda i traži proizvod u nizu ​N​ sa
	//takvim imenom, pa ako nađe vraća indeks nađenog objekta, inače vraća -1
	public int nadjiProizvod(String naziv) {
		for(int i = 0; i < this.N.size(); ++i) {
			if(this.N.get(i).getNaziv().equals(naziv)) {
				return i;
			}
		}
		return -1;
	}
	
	//● metodu ​nađiProizvod​ koja prima objekat Proizvod i traži ga u nizu ​N​, pa ako nađe vraća indeks
	//nađenog objekta, inače vraća -1
	public int nadjiProizvod(Proizvod proizvod) {
		return this.N.indexOf(proizvod);
	}
	
	//● metodu ​cena​ koja prima string sa nazivom proizvoda i vraća cenu tog proizvoda ako postoji u
	//nizu ​N ​inaće vraća -1
	@Override
	public float cena(String naziv) {
		for(int i = 0; i < this.N.size(); ++i) {
			if(this.N.get(i).getNaziv().equals(naziv)) {
				return this.cene.get(i);
			}
		}
		return -1;
	}
	
	//metod ​cena​ koji prima objekat proizvod i vraća njegovu cenu ako postoji u nizu ​N ​inaće vraća
	//-1
	@Override
	public float cena(Proizvod proizvod) {
		int index = this.N.indexOf(proizvod);
		if(index != -1) {
			return this.cene.get(index);
		}
		return -1;
	}
	
	//● string reprezentaciju koja sadrži ime i opise svih proizvoda iz niza ​N
	@Override
	public String toString() {
		String povratna = "";
		povratna += "Naziv: " + this.ime + "\n";
		povratna += "Proizvodi :\n";
		
		for(int i = 0; i < this.N.size(); ++i) {
			povratna += "" + (i + 1) + ". " + this.N.get(i).getNaziv() + "\n";
		}
		return povratna;
	}

}
