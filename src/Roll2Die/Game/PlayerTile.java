package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerTile extends OverWorldTile{
    int moveCounter;

    public PlayerTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum, int currMoveCounter) {
        super(currX, currY, currAngle, currImage, currStepNum);
        this.moveCounter = currMoveCounter;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }
}
