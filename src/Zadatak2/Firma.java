package Zadatak2;

public class Firma extends Proizvodjac {
	
	//● string podatak PIB
	private String PIB;
	
	//● kostruktor koji prima ime i PIB i setuje ih
	public Firma(String ime, String PIB) {
		super(ime);
		this.PIB = PIB;
	}


	//● metodu ​dodajProizvod​ koja dobije objekat Proizvod i cenu, ako nađe proizvod u nizu proizvoda
	//firme menja cenu, a ako ga ne nađe dodaje ga i postavlja cenu.
	//CENA se postavlja tako što se dobijena vrednost poveća za 40%
	@Override
	public void dodajProizvod(Proizvod proizvod, float cena) {
		if(this.N.contains(proizvod)) {
			int index = this.N.indexOf(proizvod);
			this.cene.set(index, cena + cena*40/100);
		}
		else {
			this.N.add(proizvod);
			this.cene.add(cena + cena*40/100);
		}
	}

}
