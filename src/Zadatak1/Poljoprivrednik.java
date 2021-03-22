package Zadatak1;

public class Poljoprivrednik extends Proizvodjac {
 
	//● Privatni atribut ​brojHektara*/
	private int brojHektara;
	
	//● konstruktor koji prima ime i broj hektara i setuje ih
	public Poljoprivrednik(String naziv, int brojHektara) {
		super(naziv);
		this.brojHektara = brojHektara;
	}

	//● metodu ​getCena​ koja prima naziv proizvoda, traži ga u nizu proizvoda, nalazi odgovarajuću
	//cenu i cenu umanjuje za po 2% sa svaki hektar preko prvog
	@Override
	public float getCena(String naziv) {
		if(this.brojHektara >= 2) {
			if(this.getProizvodi().contains(naziv)) {
				int index = this.getProizvodi().indexOf(naziv);
				float cena = this.getCene().get(index);
				cena = (float) (cena - (this.brojHektara - 1)*2.0/100*cena);
				return cena;
			}
		}
		else if(this.getProizvodi().contains(naziv)) {
			int index = this.getProizvodi().indexOf(naziv);
			return this.getCene().get(index);
		}
		return 0;
	}

}
