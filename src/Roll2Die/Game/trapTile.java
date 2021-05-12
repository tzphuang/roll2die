package Roll2Die.Game;

import java.awt.image.BufferedImage;

public class trapTile extends interactiveTile{


    public trapTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
        randomizeRandomNum();
    }

    @Override
    protected void randomizeRandomNum() {
        setRandomNum( (int)(Math.random() * 3) + 1 ); //random num [1-3] for later use
    }

    @Override
    public void applyTileRandomInteraction(PlayerCharacter currPlayerChar) {
        //uses random number stored to perform a random action on the playerCharacter
        switch( getRandomNum() ){
            case 1: //randomly decrements playerHP randomly by 5/10/15/20/25
                currPlayerChar.getMyPlayerStats().setPlayerHP(currPlayerChar.getMyPlayerStats().getPlayerHP() - (5 * ((int)(Math.random() * 5) + 1)));

                //if player hp is less than 1, set it to 1
                if(1 > currPlayerChar.getMyPlayerStats().getPlayerHP()){
                    currPlayerChar.getMyPlayerStats().setPlayerHP(1);
                }
                break;

            case 2: //randomly decrements playerMP randomly by 5/10/15/20/25
                currPlayerChar.getMyPlayerStats().setPlayerMP(currPlayerChar.getMyPlayerStats().getPlayerMP() - (5 * ((int)(Math.random() * 5) + 1)));

                //if player mp is less than 1, set it to 1
                if(1 > currPlayerChar.getMyPlayerStats().getPlayerMP()){
                    currPlayerChar.getMyPlayerStats().setPlayerMP(1);
                }
                break;

            case 3: //randomly decrements playerHP and playerMP randomly each by 5/10/15

                //for hp
                currPlayerChar.getMyPlayerStats().setPlayerHP(currPlayerChar.getMyPlayerStats().getPlayerHP() - (3 * ((int)(Math.random() * 5) + 1)));

                //if player hp is less than 1, set it to 1
                if(1 > currPlayerChar.getMyPlayerStats().getPlayerHP()){
                    currPlayerChar.getMyPlayerStats().setPlayerHP(1);
                }

                //for mp
                currPlayerChar.getMyPlayerStats().setPlayerMP(currPlayerChar.getMyPlayerStats().getPlayerMP() - (3 * ((int)(Math.random() * 5) + 1)));

                //if player mp is less than 1, set it to 1
                if(1 > currPlayerChar.getMyPlayerStats().getPlayerMP()){
                    currPlayerChar.getMyPlayerStats().setPlayerMP(1);
                }

                break;

            default:
                System.out.println("default switch case applied, problem in trapTile");
                break;

        }
    }
}
