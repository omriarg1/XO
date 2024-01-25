package XO2;

public class UserGame extends Game {
	boolean hasgameEnded;
	 public void StartMatch(SelfPlayer Computer,UserPlayer User) {
		 this.setMatch();
		 hasgameEnded=false;
		 Thread tComputer=new Thread(Computer);
		 Thread tUser=new Thread(User);
		 tComputer.start();
		 tUser.start();
	 }
	 public  void EndGame() {
		 hasgameEnded=true;
	 }
	 public boolean hasgameEnded() {
		 return hasgameEnded;
	 }
	 public XO getcurrentTurn() {
		 return this.getTurn();
	 }
	 
}
