//OFEK CASPI - 208895367 Omri argaman - 314772351
package XO2;
import java.awt.Point;
import java.util.Vector;
enum XO {X,O,E};//E is empty; for easy winner check

class Game {
	private XO[][] GameBoard;
	private int turnCounter;
	public void setMatch() {//set all cells in board to Empty
		GameBoard=new XO[5][5];
		turnCounter=0;
		for(int i=0;i<GameBoard.length;i++)
			for(int j =0;j<GameBoard.length;j++)
				GameBoard[i][j]=XO.E;
	}
	public  void printBoard() {
		System.out.println("----------");
		for(int i =0;i<GameBoard.length;i++) {
			for(int j=0;j<GameBoard.length;j++)
			{ if(GameBoard[i][j]!=null)
			    System.out.print("" +GameBoard[i][j]+"|"+"");
			  else System.out.print("- ");
			}
			System.out.println("\n----------");
		}
	}
	public synchronized void incturnCounter() {
		turnCounter++;
	}
	public synchronized int getTurnCounter() {
		return turnCounter;
	}
	public XO getTurn() {
		if(turnCounter % 2==0)
			return XO.X;
		else return XO.O;
	}
	public Vector<Point> getFreeCells() {
	 	Vector<Point> freePoints=new Vector<Point>();
	 	for(int i =0;i<GameBoard.length;i++) 
				for(int j=0;j<GameBoard.length;j++)
				     if(GameBoard[i][j]==XO.E) {
				    	 freePoints.add(new Point(i,j));
				    	 }
	 	return freePoints;
	 }
	public void fillPoint(Point pointToFill,XO type) {
		GameBoard[pointToFill.x][pointToFill.y]=type;
	}
	public XO getCell(int row,int col) {
		return GameBoard[row][col]; 
	}
	public  synchronized XO checkWinner() {
		String row="";
		String col="";
		for(int i =0;i<GameBoard.length;i++) {//check rows,cols
			for(int j=0;j<GameBoard.length;j++)
			{
				row+=GameBoard[i][j].toString();   
				col+=GameBoard[j][i].toString();
			}	
			if(row.contains("OOOO")|| col.contains("OOOO"))
				return XO.O;
			else if(row.contains("XXXX")|| col.contains("XXXX"))
				return XO.X;
			else col=row="";
		}
		String[] diagonals = new String[5];
		for(int i=0;i<GameBoard.length;i++) {//check all diagonal lines at once
	     diagonals[0]+=GameBoard[i][i].toString();
	     if(i<GameBoard.length-1){
	    	 diagonals[1]+=GameBoard[i][i+1].toString();
	    	 diagonals[2]+=GameBoard[i+1][i].toString();//i=0 
	    	 diagonals[3]+=GameBoard[GameBoard.length-i-1][i+1].toString();
	    	 diagonals[4]+=GameBoard[GameBoard.length-i-2][i].toString();
	    	 }
		}
		for(String s: diagonals)
		{
			if(s.contains("XXXX"))
				return XO.X;
			else if(s.contains("OOOO"))
				return XO.O;
		}
		return null;//null if no winner
	}
}
