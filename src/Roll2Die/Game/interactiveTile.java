package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class interactiveTile extends OverWorldTile{

    private int randomNum;

    public interactiveTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
    }

    protected abstract void randomizeRandomNum();

    public abstract void applyTileRandomInteraction(PlayerCharacter currentPlayerCharacter);

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }
}
