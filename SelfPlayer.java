package XO2;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;
public class SelfPlayer extends Player implements Runnable {
	private SelfGame SelfGame;
	private UserGame UserGame;
	private final boolean isUserGame;
	public SelfPlayer(SelfGame Game,XO playerType) {
		super(playerType);
		this.SelfGame=Game;
		isUserGame=false;
	}
	public SelfPlayer(UserGame Game,XO playerType) {
		super(playerType);
		this.UserGame=Game;
		isUserGame=true;
	}
	public void run() {
		if(!isUserGame) {
		while(SelfGame.checkWinner()==null)
		{
			if(SelfGame.getcurrentTurn()!=this.getPlayerType())
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else {
				  if(SelfGame.getTurnCounter()==25) {
					  System.out.println("Board is full");
					  SelfGame.EndGame();
					  break;
				  }
				  else {
					  synchronized(SelfGame) {//critical code
				  this.MakeMove(SelfGame.getFreeCells());
			      SelfGame.printBoard();
			      SelfGame.incturnCounter();
					  }
				  }
			}
		}
		 XO winner=SelfGame.checkWinner();
		 if(!SelfGame.hasgameEnded())
		 if(winner!=null) {
			 SelfGame.EndGame();
		 System.out.println("The winner is: "+ winner.toString());
		 }
		}
		else {
			while(UserGame.checkWinner()==null)
			{
				if(UserGame.getcurrentTurn()!=this.getPlayerType())
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				else {
					  if(UserGame.getTurnCounter()==25) {
						  System.out.println("Board is full");
						  UserGame.EndGame();
						  break;
					  }
					  else {
						  synchronized(UserGame) {//critical code
					   System.out.println("Computer's turn");
				      this.MakeMove(UserGame.getFreeCells());
				      UserGame.printBoard();
				      UserGame.incturnCounter();
						  }
					  }
				}
			}
			 XO winner=UserGame.checkWinner();
			 if(!UserGame.hasgameEnded())
			 if(winner!=null) {
				 UserGame.EndGame();
			 System.out.println("The winner is: "+ winner.toString());
			 }
		}
	}
    public void MakeMove(Vector<Point> freePoints){
    	if(!isUserGame) {
    	Random rnd = new Random();
    	Point pointToFill = freePoints.elementAt(rnd.nextInt(0, freePoints.size()));
        SelfGame.fillPoint(pointToFill, getPlayerType());
    	}
    	else {
    		Random rnd = new Random();
        	Point pointToFill = freePoints.elementAt(rnd.nextInt(0, freePoints.size()));
            UserGame.fillPoint(pointToFill, getPlayerType());
    	}
    }
}
