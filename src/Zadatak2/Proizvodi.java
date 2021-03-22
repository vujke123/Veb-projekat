package Zadatak2;

import java.util.ArrayList;

public interface Proizvodi {

	//● metodu ​dajListuProizvoda​ koja vraća niz objekata tipa ​Proizvod
	public ArrayList<Proizvod> dajListuProizvoda();
	
	//● metodu ​cena​ koja prima string naziv i vraća float cenu
	public float cena(String naziv);
	
	//● metodu ​cena​ koja prima objekat tipa ​proizvod​ i vraća float cenu
	public float cena(Proizvod proizvod);
}
