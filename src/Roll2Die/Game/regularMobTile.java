package Roll2Die.Game;

import Roll2Die.Launcher;

import java.awt.image.BufferedImage;

public class regularMobTile extends fightableTile{

    public regularMobTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
    }

    /*
    * initiateMonsterFightEnvironment should randomly load up a new monster
    * send that monster to the monster fight environment
    * initiate the monster fight environment with the new monster
    * while resetting the timer and everything else for a new fight
    * then switch the launcher lf to the MonsterFightEnvironment panel
    */
    @Override
    public void initiateMonsterFightEnvironment(Launcher lf) {



        System.out.println("landed on a regularMobTile on tile number: " + getStepNum());
    }
}
