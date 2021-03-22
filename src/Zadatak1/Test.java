package Zadatak1;

import java.util.ArrayList;

public class Test {
	
	/*
	● kreira jednog poljoprivrednika Marka Markovića sa brojem hektara 2 i jednu firmu Poljolink sa PIB-om 20133
	● Marku dodaje na spisak proizvoda grašak i repu i setuje im cene na 50 i 100
	● firmi Poljolink dodaje šećer i repu po cenama 400 i 100
	● formira niz Proizvođača i smešta u njega Marka i Poljolink
	● ispisuje string reprezentaciju svih elemenata niza
	● ispisuje nazive i cene proizvoda koje Marko proizvodi*/

	public static void main(String[] args) {
		
		Poljoprivrednik polj = new Poljoprivrednik("Marko Markovic", 2);
		Firma firma = new Firma("Poljolink", "20133");
		
		polj.dodajProizvod("grasak", 50);
		polj.dodajProizvod("repa", 100);
		
		firma.dodajProizvod("secer", 400);
		firma.dodajProizvod("repa", 100);
		
		ArrayList<Proizvodjac> proizvodjaci = new ArrayList<Proizvodjac>();
		proizvodjaci.add(polj);
		proizvodjaci.add(firma);
		
		for(int i = 0; i < proizvodjaci.size(); ++i) {
			System.out.println(proizvodjaci.get(i));
		}
		
		for(int i = 0; i < polj.getProizvodi().size(); ++i) {
			System.out.println("Proizvod " + (i+1) + ". " + polj.getProizvodi().get(i) + 
								", Cena: " + polj.getCena(polj.getProizvodi().get(i)));
		}

	}

}
