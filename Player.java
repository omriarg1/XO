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
