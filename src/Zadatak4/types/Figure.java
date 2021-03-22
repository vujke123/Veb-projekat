package Zadatak4.types;

public abstract class Figure {
	protected String color;
	protected int cord_x = -1;
	protected int cord_y = -1;
	
	private static final String black_color = "crna";
	private static final String white_color = "bela";
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color.toLowerCase().equals(black_color) || color.toLowerCase().equals(white_color))
			this.color = color;
	}
	
	public void setCord_x(int x){
		this.cord_x = x;
	}
	
	public void setCord_y(int y){
		this.cord_y = y;
	}
	
	public int getCord_x() {
		return cord_x;
	}

	public int getCord_y() {
		return cord_y;
	}


	public abstract boolean move(int cord_x,int cord_y);
	
	public abstract String toString();
	
	public static boolean check_new_cordinates(int new_cord_x,int new_cord_y){
		if(new_cord_x > 8 || new_cord_x < 0)
			return false;
		if(new_cord_y > 8 || new_cord_y < 0)
			return false;
		return true;
	}
		
	public static String getBlackColor() {
		return black_color;
	}

	public static String getWhiteColor() {
		return white_color;
	}

}
