package Roll2Die.Game;

import Roll2Die.Launcher;

import java.awt.image.BufferedImage;

public abstract class fightableTile extends OverWorldTile{

    public fightableTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
    }

    public abstract void initiateMonsterFightEnvironment(Launcher lf);
}
