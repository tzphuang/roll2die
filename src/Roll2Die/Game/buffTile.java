package Roll2Die.Game;

import java.awt.image.BufferedImage;

public class buffTile extends interactiveTile{

    public buffTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
        randomizeRandomNum();
    }

    @Override
    protected void randomizeRandomNum() {
        /*random num [1-3] for later use
         * for example:
         * in calculations to subtract from a range of [1-5]
         * that (random [1-5] - [1-3]) will be added onto the buff stats of the playerCharacter
         * */
        setRandomNum( (int)(Math.random() * 3) + 1 );
    }

    @Override
    public void applyTileRandomInteraction(PlayerCharacter currentPlayerCharacter) { //applies a random number +/- to each buff

        int rand = (int)(Math.random() * 6) + 1;
        //adds ([1-6] - [1-3]) to current playerBuff > StrBuff
        currentPlayerCharacter.getMyPlayerBuffs().setStrBuff(currentPlayerCharacter.getMyPlayerBuffs().getStrBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 6) + 1;
        //adds ([1-6] - [1-3]) to current playerBuff > IntBuff
        currentPlayerCharacter.getMyPlayerBuffs().setIntBuff(currentPlayerCharacter.getMyPlayerBuffs().getIntBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 2);
        //adds [0-2] to current playerBuff >  DexBuff
        currentPlayerCharacter.getMyPlayerBuffs().setDexBuff(currentPlayerCharacter.getMyPlayerBuffs().getDexBuff() + rand);

        rand = (int)(Math.random() * 6) + 1;
        //adds ([1-6] - [1-3]) to current playerBuff > VitBuff
        currentPlayerCharacter.getMyPlayerBuffs().setVitBuff(currentPlayerCharacter.getMyPlayerBuffs().getVitBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 6) + 1;
        //adds ([1-6] - [1-3]) to current playerBuff > WisBuff
        currentPlayerCharacter.getMyPlayerBuffs().setWisBuff(currentPlayerCharacter.getMyPlayerBuffs().getWisBuff() + (rand - getRandomNum()));

        //adds (5 * [1-3]) to current playerBuff > LukBuff
        currentPlayerCharacter.getMyPlayerBuffs().setLukBuff(currentPlayerCharacter.getMyPlayerBuffs().getLukBuff() + (5 * getRandomNum()));
    }
}
