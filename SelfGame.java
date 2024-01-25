package XO2;

import java.awt.Point;
import java.util.Vector;

public class SelfGame extends Game {
boolean hasgameEnded;
 public XO getcurrentTurn() {
	 return this.getTurn();
 }
 public  void EndGame() {
	 hasgameEnded=true;
 }
 public boolean hasgameEnded() {
	 return hasgameEnded;
 }
 public void StartMatch(SelfPlayer playerX,SelfPlayer playerO) {
	 this.setMatch();
	 hasgameEnded=false;
	 Thread tX = new Thread(playerX);
	 Thread tO = new Thread(playerO);
	 tX.start();
	 tO.start();
 }
}
