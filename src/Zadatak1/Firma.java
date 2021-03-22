package Zadatak1;

public class Firma extends Proizvodjac {

	//● Privatni string atribut ​PIB
	private String PIB;
	
	//● konstruktor koji prima ime i PIB i setuje ih
	public Firma(String naziv, String PIB) {
		super(naziv);
		this.PIB = PIB;
	}
	
	//● metodu ​getCena​ koja prima naziv proizvoda, traži ga u nizu proizvoda, nalazi odgovarajuću
	//cenu i vrati je
	@Override
	public float getCena(String naziv) {
		if(this.getProizvodi().contains(naziv)) {
			int index = this.getProizvodi().indexOf(naziv);
			return this.getCene().get(index);
		}
		return 0;
	}

}
