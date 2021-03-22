package Zadatak3;

public class Zapis {
	
	//● privatne podatke ​artikal​ tipa Artikal, ​količina​ tipa float i ​jedCena​ tipa float koja predstavlja 
	//cenu atrikla po jedinici mere
	private Artikal artikal;
	private float kolicina;
	private float jedCena;
	//● vrednost atrikla predstavlja ukupnu cenu, odnosno računa se kao proizvod količine i cene po
	//jedinici mere
	private float vrednost;
	
	//● konstruktor koji prima vrednosti za sva tri atributa i setuje ih;
	public Zapis(Artikal artikal, float kolicina, float jedCena) {
		this.artikal = artikal;
		this.kolicina = kolicina;
		this.jedCena = jedCena;
		this.vrednost = this.kolicina * this.jedCena;
	}

	//● getter-e​ i ​setter-e​ za sve atribute
	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public float getKolicina() {
		return kolicina;
	}

	public void setKolicina(float kolicina) {
		this.kolicina = kolicina;
	}

	public float getJedCena() {
		return jedCena;
	}

	public void setJedCena(float jedCena) {
		this.jedCena = jedCena;
	}
	
	public float getVrednost() {
		return this.vrednost;
	}

	//● string reprezentacija sadrži naziv artikla, količinu, jedinicu mere i vrednost artikla.
	@Override
	public String toString() {
		String povratna = this.artikal.toString() + "\n";
		povratna += "Kolicina: " + this.kolicina + "\n";
		povratna += "Jedinica mere: " + this.artikal.getJm().toString() + "\n";
		povratna += "Vrednost: " + this.vrednost;
		
		return povratna;
	}
}
