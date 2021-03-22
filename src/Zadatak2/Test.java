package Zadatak2;

import java.util.ArrayList;

import Zadatak2.Firma;
import Zadatak2.Poljoprivrednik;

public class Test {
	
	/*● kreira dva poljoprivredna (grašak i repa) i jedan industrijski proizvod (šećer)
	● kreira jednog poljoprivrednika Marka Markovića i jednu firmu Poljolink
	● Marku dodaje na spisak proizvode grašak i repu i setuje im cene na 50 i 100, a zatim ponovo
	dodaje grašak sa cenom 100
	● firmi Poljolink dodaje šećer i repu po cenama 400 i 100
	● formira niz Proizvođača i smešta u njega Marka i Poljolink
	● ispisuje string reprezentaciju svih elemenata niza*/

	public static void main(String[] args) {
		Poljoprivredni proizvod1 = new Poljoprivredni("Grasak");
		Poljoprivredni proizvod2 = new Poljoprivredni("Repa");
		Industrijski ind1 = new Industrijski("Secer");
		
		Poljoprivrednik polj = new Poljoprivrednik("Marko Markovic");
		Firma firma = new Firma("Poljolink", "20133");
		
		polj.dodajProizvod(proizvod1, 50);
		polj.dodajProizvod(proizvod2, 100);
		polj.dodajProizvod(proizvod1, 100);
		
		firma.dodajProizvod(ind1, 400);
		firma.dodajProizvod(proizvod2, 100);
		
		ArrayList<Proizvodjac> proizvodjaci = new ArrayList<Proizvodjac>();
		
		proizvodjaci.add(polj);
		proizvodjaci.add(firma);
		
		for(int i = 0; i < proizvodjaci.size(); ++i) {
			System.out.println(proizvodjaci.get(i));
		}
	}

}
