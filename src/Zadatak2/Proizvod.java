package Zadatak2;

import java.util.ArrayList;

public abstract class Proizvod {

	/*● privatni celobrojni podatak ​ID​ (svaki proizvod ima svoj ID, ID se dodeljuje počevši od 1 do 50)
● privatnu promenljivu ​b​ tipa ​Brojač​ koju koristi za preuzimanje sledeće vrednosti za ID
● privatnu char promenljivu ​tip */ 
	private String naziv;
	private int ID;
	private Brojac b = new Brojac();
	private char tip;

//● javni niz ​listaProizvoda​ koji pripada klasi i koji sadrži reference na sve registrovane proizvode
	public ArrayList<Proizvod> listaProizvoda = new ArrayList<Proizvod>();
	
//● javnu metodu klase koja vraća referencu na ​listaProizvoda
	public ArrayList<Proizvod> getProizvode(){
		return this.listaProizvoda;
	}
//● konstruktor koji prima naziv i tip proizvoda i baca izuzetak tipa greška. 
//Konstruktor proverava da li već postoji proizvod pod datim imenom i ako postoji diže izuzetak
//tipa Greška sa odgovarajućim komentarom, a ako ne postoji korišćenjem b određuje vrednost za 
//ID i postavlja je, zatim setuje naziv i tip.
	public Proizvod(String naziv, char tip) {
		boolean postoji = false;
		for(int i = 0; i < this.listaProizvoda.size(); ++i) {
			if(this.listaProizvoda.get(i).getNaziv().equals(naziv)) {
				postoji = true;
			}
		}
		if(postoji) {
			Greska greska = new Greska("Proizvod sa datim imenom vec postoji");
		}
		else {
			this.naziv = naziv;
			this.tip = tip;
			this.ID = b.getNext();
		}
	}
//● metoda ​dodajUListuProizvoda​ koja proizvod koji dobija u argumentu dodaje u ​listaProizvoda
	public void dodajUListuProizvoda(Proizvod proizvod) {
		this.listaProizvoda.add(proizvod);
	}
//● metoda ​nađiProizvod​ koja dobije string ime i u ​listaProizvoda​ traži proizvod sa datim imenom
//i vraća objekat tipa ​Proizvod​ ako ga je našao a null ako nije.
	public Proizvod nadjiProizvod(String ime) {
		for(int i = 0; i < this.listaProizvoda.size(); ++i) {
			if(this.listaProizvoda.get(i).getNaziv().equals(ime)) {
				return this.listaProizvoda.get(i);
			}
		}
		return null;
	}
	
//● getter​ i ​setter​ za naziv
//● getter-e​ za ID i tip
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getID() {
		return ID;
	}
	public char getTip() {
		return tip;
	}
	
	//● string reprezentaciju oblika ID naziv
	@Override
	public String toString() {
		String povratna = "ID: " + this.ID + "\n";
		povratna += "Naziv: " + this.naziv;
		
		return povratna;
	}
}
