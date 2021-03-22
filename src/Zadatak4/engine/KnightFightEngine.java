package Zadatak4.engine;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Zadatak4.types.Figure;
import Zadatak4.types.King;
import Zadatak4.types.Knight;

public class KnightFightEngine {

	private int moves = 0;
	private String next;
	private Figure[][] board = new Figure[8][8];
	
	private static final int initFigureNumber = 4;
	private String arrayBoardName[] = { "A", "B", "C", "D", "E", "F", "G", "H" };  
	private enum eBoardTransform {A,B,C,D,E,F,G,H};
	
	
	public int getMoves() {
		return moves;
	}
	
	public void increasMove(){
		++this.moves;
		if(this.next.equals(Figure.getBlackColor()))
			this.next = Figure.getWhiteColor();
		else 
			this.next = Figure.getBlackColor();
	}
	
	public String getNext() {
		return next;
	}
	
	private King getKing(Figure[] arrayFigures){
		King figureKing = null;
		for (int i = 0; i < arrayFigures.length; i++) {
			if(arrayFigures[i] instanceof King)
				figureKing = (King) arrayFigures[i];
		}
		return figureKing;
	}
	
	public static void main(String[] args) {
		KnightFightEngine test= new KnightFightEngine();
		test.initialize();
		test.printBoard();
		Figure[] blackFigures = test.getFigures(Figure.getBlackColor());
		Figure[] whiteFigures = test.getFigures(Figure.getWhiteColor());
		
		King whiteKing = test.getKing(whiteFigures);
		King blackKing = test.getKing(blackFigures);
		
		int[] whiteKingCords = test.getPosition(whiteKing);
		int[] blackKingCords = test.getPosition(blackKing);
		test.move(whiteKingCords[0], test.arrayBoardName[whiteKingCords[1]], whiteKingCords[0]+1, test.arrayBoardName[whiteKingCords[1]]);
		test.printBoard();
		
		test.move(blackKingCords[0], test.arrayBoardName[blackKingCords[1]], blackKingCords[0]-1, test.arrayBoardName[blackKingCords[1]]);
		test.printBoard();
		
		test.move(whiteKingCords[0]+1, test.arrayBoardName[whiteKingCords[1]], whiteKingCords[0]+2, test.arrayBoardName[whiteKingCords[1]]);
		test.printBoard();
		
		test.move(blackKingCords[0]-1, test.arrayBoardName[blackKingCords[1]], blackKingCords[0]-2, test.arrayBoardName[blackKingCords[1]]);
		test.printBoard();
		
		String winner = test.getWinner();
		if(winner == null)
			System.out.println("No winner");
		else 
			System.out.println(winner);
		Scanner in = new Scanner(System.in);
		while(test.getWinner() == null) //Extra za ljude koji hoce da igraju
		{
			System.err.println("Na redu je : " + test.getNext().toUpperCase());
			System.out.println("Uneti 'exit' za zaustavljanje");
			
			System.out.println("Unesite figuru koju zelite da izaberete kao 2,A:" + test.getNext().toUpperCase());
			String line = in.nextLine();
			if(line.toLowerCase().equals("exit"))
				break;
			String gotCords[] = line.split(",");
			System.out.println("Unesite figuru koju zelite da pomerite kao 3,A:" + test.getNext().toUpperCase());
			String toCords[] = in.nextLine().split(",");
			int gotX = Integer.parseInt(gotCords[0]);	
			int toX = Integer.parseInt(toCords[0]);
			test.move(gotX, gotCords[1],toX, toCords[1]);
			test.printBoard();
		}
		in.close();
		System.err.flush();
		System.out.flush();
		System.out.println();
		System.err.println("Winner = " + test.getWinner());		
	}
	
	
	public void deployFigure(Figure figure,int i,int seed){
		Random random = new Random(System.currentTimeMillis()*seed);
		boolean placed = false;
		while(!placed){
			int val = random.nextInt(8);
			if (this.board[i][val] == null){
				figure.setCord_x(i);
				figure.setCord_y(val);
				if(i == 0)
					figure.setColor(Figure.getWhiteColor());
				else if (i == 7)
					figure.setColor(Figure.getBlackColor());
				this.board[i][val] = figure;
				placed = true;
			}
		}
	}

	public void move(int fromX,String fromY,int toX,String toY){
		int nFromY;
		int nToY;
		try{
			nFromY = eBoardTransform.valueOf(fromY).ordinal();
			nToY = eBoardTransform.valueOf(toY).ordinal();
			if (!Figure.check_new_cordinates(fromX, nFromY) || !Figure.check_new_cordinates(toX, nToY))
				throw new IndexOutOfBoundsException("Invalid Coordinates");
		}catch(Error e){
			System.err.println("Out of range of board");
			return;
		}
		Figure gotFigure = this.board[fromX][nFromY]; 
		if(gotFigure == null)
		{
			System.err.println("No figure there");
			return;
		}
		
		if(gotFigure.getColor() != this.getNext())
		{
			System.err.println("Not your turn");
			return;
		}
			
		if(!gotFigure.move(toX, nToY))
		{
			System.err.println("Can't move figure there");
			return; 
		}
		Figure gotToFigure = this.board[toX][nToY];
		if(gotToFigure != null)
			if(gotToFigure.getColor().equals(gotFigure.getColor()))
			{
				System.err.println("Can't move on your own figure");
				return;
			}
		
		this.board[toX][nToY] = gotFigure;
		gotFigure.setCord_x(toX);
		gotFigure.setCord_y(nToY);
		this.board[fromX][nFromY] = null;
		increasMove();
		
		
	}
	
	public Figure[] getFigures(String color){
		List<Figure> returning = new ArrayList<Figure>();
		for (int i = 0; i < board[0].length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				Figure found = this.board[i][j];
				if(found != null)
					{
						if(found.getColor().equals(color))
							returning.add(found);
					}
			}
		}
		return returning.toArray(new Figure[returning.size()]);
	}
	
	public int[] getPosition(Figure figure){
		int[] cords = new int[2];
		for (int i = 0; i < board[0].length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				Figure found = this.board[i][j];
				if(found != null)
					{
						if(found.equals(figure))
						{
							cords[0] = i;
							cords[1] = j;
						}
					}
			}
		}
		return cords;
	}
	
	public String getWinner(){
		boolean foundWhite = false;
		boolean foundBlack = false;
		for (int i = 0; i < board[0].length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				Figure found = this.board[i][j];
				if(found != null)
					if(found instanceof King)
					{
						if(found.getColor().equals(Figure.getBlackColor()))
							foundBlack = true;
						else if(found.getColor().equals(Figure.getWhiteColor()))
							foundWhite = true;
					}
			}
		}
		if(!foundWhite)
			return Figure.getBlackColor();
		else if(!foundBlack)
			return Figure.getWhiteColor();
		else
			return null;
	}
	
	public void printBoard(){
		
		for (int i = -1; i < this.board[0].length; ++i) {
			if(i==-1)
				System.out.printf("%9s","");
			else 
				System.out.printf("%9s",i);
			
			for (int j = 0; j < this.board[0].length; ++j) {
				if(i == -1)	{
					System.out.printf("%9s",arrayBoardName[j]);
				}
				else {
					String newFigure = "+";
					if(this.board[i][j] != null)
						newFigure = this.board[i][j].toString();
					System.out.printf("%9s",newFigure);	
				}
			}
			System.out.println("");
			
		}
		System.out.println("");
	}
	
	public void initialize(){
		this.next = Figure.getWhiteColor();
		boolean first = true;
		Figure toAddUp;
		Figure toAddDown;
		for(int i=0;i< initFigureNumber;++i)
			{
				if(first)
				{
					toAddUp = new King();
					toAddDown = new King();
					first = false;
				}
				else
				{
					toAddUp = new Knight();
					toAddDown = new Knight();	
				}
				this.deployFigure(toAddUp, 0,244);
				this.deployFigure(toAddDown, 7,111);
			}
		}	
		
	}
	

