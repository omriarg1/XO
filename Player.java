//OFEK CASPI - 208895367 Omri argaman - 314772351
package XO2;
import java.awt.Point;

public abstract class Player {
 private final  XO playerType;
    public Player(XO playerType) {
    	this.playerType=playerType;
    }
    public XO getPlayerType() {
    	return playerType;
    }
}
