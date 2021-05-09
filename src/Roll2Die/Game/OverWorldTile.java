package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OverWorldTile extends Stationary{

    private int stepNum;

    public OverWorldTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage);
        stepNum = currStepNum;
    }

    public int getStepNum() {
        return stepNum;
    }

    public void setStepNum(int stepNum) {
        this.stepNum = stepNum;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }
}
