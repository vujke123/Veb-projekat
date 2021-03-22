package Zadatak4.types;

import org.w3c.dom.ranges.RangeException;

public class King extends Figure {

	private static final String label = "K";
	
	public King(){
		super();
	}
	
	public King(int x,int y,String color){
		if(!Figure.check_new_cordinates(x, y))
			throw new RangeException((short) 0,"Out of chess board exeption");
		this.cord_x = x;
		this.cord_y = y;
		this.setColor(color);
	}
	
	@Override
	public boolean move(int cord_x, int cord_y) {
		if(!Figure.check_new_cordinates(cord_x,cord_y))
			return false;
		int divergions_x = Math.abs(this.getCord_x() - cord_x);
		int divergions_y = Math.abs(this.getCord_y() - cord_y);
		if(divergions_x == 0 && divergions_y == 0)
			return false;
		if(divergions_x <= 1 && divergions_y <= 1)
			return true;
		return false;
	}

	@Override
	public String toString() {
		String returning = label + "[" +this.getColor() + "]";
		return returning;
	}

}
