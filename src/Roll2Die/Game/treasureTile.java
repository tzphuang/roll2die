package Roll2Die.Game;

import java.awt.image.BufferedImage;

public class treasureTile extends interactiveTile{

    public treasureTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
        randomizeRandomNum();
    }

    @Override
    protected void randomizeRandomNum() {
        setRandomNum( (int)(Math.random() * 3) + 1 ); //random num [1-3] for later use
    }

    @Override
    public void applyTileRandomInteraction(PlayerCharacter currPlayerChar) {
        switch( getRandomNum() ){
            case 1:
                int extraGold = (int)(Math.random() * 2000) + 1; // [1-2000] range
                currPlayerChar.getMyPlayerStats().setGold(currPlayerChar.getMyPlayerStats().getGold() + extraGold);
                break;

            case 2:
                int extraHPpots = (int)(Math.random() * 3) + 1; // [1-3] range
                currPlayerChar.getMyPlayerStats().setPotHP(currPlayerChar.getMyPlayerStats().getPotHP() + extraHPpots);
                break;

            case 3:
                int extraMPpots = (int)(Math.random() * 3) + 1; // [1-3] range
                currPlayerChar.getMyPlayerStats().setPotMP(currPlayerChar.getMyPlayerStats().getPotMP() + extraMPpots);
                break;

            default:
                System.out.println("default switch case applied, problem in treasureTile");
                break;

        }


    }
}
