package Zadatak1;

import java.util.ArrayList;

public abstract class Proizvodjac {
	
	/*Privatni string atribut ​naziv
	● privatni string atribut ​adresa
	● privatni niz stringova ​proizvodi
	● privatni niz float vrednosti ​cene*/
	
	private String naziv;
	private String adresa;
	private ArrayList<String> proizvodi = new ArrayList<String>();
	private ArrayList<Float> cene = new ArrayList<Float>();
	
	//● konstruktor koji prima naziv i setuje ga
	public Proizvodjac(String naziv) {
		this.naziv = naziv;
	}
	
	//● metodu ​dodajProizvod​ koja prima naziv i cenu proizvoda, pa ih dodaje u odgovarajuće nizove
	public void dodajProizvod(String nazivProizvoda, float cenaProizvoda) {
		this.proizvodi.add(nazivProizvoda);
		this.cene.add(cenaProizvoda);
	}
	
	//● apstraktnu metodu ​getCena​ koja prima string i vraća float
	public abstract float getCena(String naziv);
	
	//● metodu ​prebroj​ koja vraća ceo broj koji predstavlja broj elemanata niza proizvodi
	public int prebroj() {
		return this.proizvodi.size();
	}
	
	//● metodu ​izbaciProizvod​ koja prima naziv proizvoda, nalazi ga u nizu i izbacuje ga (odgovarajuća cena takođe mora biti izbačena)
	public void izbaciProizvod(String naziv) {
		if(this.proizvodi.contains(naziv)) {
			int index = this.proizvodi.indexOf(naziv); //Nadjemo index elementa na kom se nalazi zeljeni proizvod
			this.proizvodi.remove(index); //Izbacimo proizvod iz liste proizvoda
			this.cene.remove(index); //Izbacimo cenu proizvoda iz liste cena, kako bi se odrzala relacija
		}
	}
	
	//● string reprezentaciju koja sadrži naziv, adresu firme kao i spisak svih proizvoda sa cenama
	@Override
	public String toString() {
		String povratna = "";
		povratna += "Naziv: " + this.naziv + "\n";
		povratna += "Adresa: " + this.adresa + "\n";
		povratna += "Proizvodi :\n";
		
		for(int i = 0; i < this.proizvodi.size(); ++i) {
			povratna += "" + (i + 1) + ". " + this.proizvodi.get(i) + "\n";
		}
		return povratna;
	}


	//● gettere​ i ​settere​ za sve promenljive osim ​settera​ za nizove
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public ArrayList<String> getProizvodi() {
		return proizvodi;
	}

	public ArrayList<Float> getCene() {
		return cene;
	}
} 
