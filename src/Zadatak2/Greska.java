package Zadatak2;

public class Greska extends Exception{
	
	/*Tip ​Greška koji predstavlja Exception i u konstruktoru prima string koji se postavlja 
	 * kao vrednost message promenljive.*/
	
	public Greska(String message) {
		super(message);
	}

}
