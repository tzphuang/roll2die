package Roll2Die.Game;

import java.awt.image.BufferedImage;

public class debuffTile extends interactiveTile{

    public debuffTile(int currX, int currY, float currAngle, BufferedImage currImage, int currStepNum) {
        super(currX, currY, currAngle, currImage, currStepNum);
        randomizeRandomNum();
    }

    @Override
    protected void randomizeRandomNum() {
        /*random num [1-3] for later use
         * for example:
         * in calculations to subtract from a range of [1-5]
         * that (random [1-5] - [1-3]) will be added onto the debuff stats of the playerCharacter
         * */
        setRandomNum( (int)(Math.random() * 3) + 1 );
    }

    @Override
    public void applyTileRandomInteraction(PlayerCharacter currentPlayerCharacter) { //applies a random number +/- to each buff

        int rand = (int)(Math.random() * 5) + 1;
        //adds ([1-5] - [1-3]) to current playerDebuff > StrBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setStrBuff(currentPlayerCharacter.getMyPlayerDebuffs().getStrBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 5) + 1;
        //adds ([1-5] - [1-3]) to current playerDebuff > IntBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setIntBuff(currentPlayerCharacter.getMyPlayerDebuffs().getIntBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 1);
        //adds [0-1] to current playerDebuff >  DexBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setDexBuff(currentPlayerCharacter.getMyPlayerDebuffs().getDexBuff() + rand);

        rand = (int)(Math.random() * 5) + 1;
        //adds ([1-5] - [1-3]) to current playerDebuff > VitBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setVitBuff(currentPlayerCharacter.getMyPlayerDebuffs().getVitBuff() + (rand - getRandomNum()));

        rand = (int)(Math.random() * 5) + 1;
        //adds ([1-5] - [1-3]) to current playerDebuff > WisBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setWisBuff(currentPlayerCharacter.getMyPlayerDebuffs().getWisBuff() + (rand - getRandomNum()));

        //adds (3 * [1-3]) to current playerDebuff > LukBuff
        currentPlayerCharacter.getMyPlayerDebuffs().setLukBuff(currentPlayerCharacter.getMyPlayerDebuffs().getLukBuff() + (3 * getRandomNum()));


    }
}
