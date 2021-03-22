package Zadatak2;

public class Poljoprivrednik extends Proizvodjac {
	
	//● kostruktor koji prima ime setuje ga
	public Poljoprivrednik(String ime) {
		super(ime);
	}

	//● metodu ​dodajProizvod​ koja dobija objekat Proizvod i cenu. Na početku proverava da li je
	//proizvod tipa P, pa ako nije diže izuzetak Greska sa odgovarajućim komentarom. Ako je proizvod
	//odgovarajućeg tipa, on proverava da li proizvod postoji u nizu njegovih proizvoda, ako ga 
	//pronađe, menja cenu, u suprotnom ga dodaje i postavlja cenu.
	//CENA se postavlja tako što se dobijena vrednost poveća za 20%.
	@Override
	public void dodajProizvod(Proizvod proizvod, float cena) {
		if(proizvod.getTip() == 'P') {
			if(this.N.contains(proizvod)) {
				int index = this.N.indexOf(proizvod);
				this.cene.set(index, cena + cena*20/100);
			}
			else {
				this.N.add(proizvod);
				this.cene.add(cena + cena*20/100);
			}
		}
		else {
			Greska greska = new Greska("Proizvod koji je prosledjen nije tipa P.");
		}

	}

}
