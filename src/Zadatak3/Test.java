package Zadatak3;

import java.util.ArrayList;

public class Test {

	/*● napraviti niz vrednosnih objekata ​red
	● napraviti 2 korpe, u prvu ubaciti dva pakovanja šećera, jedno od jednog kilograma, drugo od
	pola, u drugu ubaciti dva pakovanja mleka od po 1 litra
	● u red ubaciti 2 korpe i jedno mleko od 0.7 l
	● odštampati ukupnu vrednost svih artikala u tom redu*/
	
	public static void main(String[] args) {
		ArrayList<Vrednosno> red = new ArrayList<Vrednosno>();
		
		Korpa korpa1 = new Korpa(3);
		Korpa korpa2 = new Korpa(3);
		
		Secer secer = new Secer("Podravka");
		Mleko mleko = new Mleko("Imlek");
		
		korpa1.dodaj(new Zapis(secer, 1, 100));
		korpa1.dodaj(new Zapis(secer, 1, 50));
		
		korpa2.dodaj(new Zapis(mleko, 1, 150));
		korpa2.dodaj(new Zapis(mleko, 1, 150));
		
		red.add(korpa1);
		red.add(korpa2);
		
		float vrednost = 0;
		for(int i = 0; i < red.size(); ++i) {
			vrednost += red.get(i).vrednost();
		}
		
		System.out.println(vrednost);
		
		for(int i = 0; i < red.size(); ++i) {
			System.out.println(red.get(i));
		}
		

	}

}
