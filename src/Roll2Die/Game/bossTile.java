package Roll2Die.Game;

import Roll2Die.Launcher;

import java.awt.image.BufferedImage;

public class bossTile extends fightableTile{

    public bossTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
    }

    @Override
    public void initiateMonsterFightEnvironment(Launcher lf) {
        System.out.println("landed on a bossTile");
    }
}
