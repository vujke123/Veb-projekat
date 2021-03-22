package Zadatak3;

public abstract class Artikal {

	//● ima privatni ​naziv​ tipa String i privatnu konstantnu jedinicu mere ​jm​;
	private String naziv;
	private JedinicaMere jm;
	
	//● konstruktor koji prima string koji predstavlja naziv artikla i jedinicu mere i setuje ih;
	public Artikal(String naziv, JedinicaMere jm) {
		this.naziv = naziv;
		this.jm = jm;
	}
	
	//● string reprezentaciju koja sadrži naziv artikla;
	@Override
	public String toString() {
		return "Naziv: " + this.naziv;
	}

	//● getter​ i ​setter​ za jedinicu mere.
	public JedinicaMere getJm() {
		return jm;
	}

	public void setJm(JedinicaMere jm) {
		this.jm = jm;
	}
	
	
	

}
