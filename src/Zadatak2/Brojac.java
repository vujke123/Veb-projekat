package Zadatak2;

public class Brojac {
	
	//● privatni celobrojni podatak vrd
	private int vrd;
	
	//● metodu getNext koja uvećava vrd za 1 i vraća je
	public int getNext() {
		++this.vrd;
		return this.vrd;
	}
	
	//● metodu reset koja vraća vrd na početnu vrednost
	public void reset() {
		this.vrd = 0;
	}
}
