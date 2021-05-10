package Roll2Die.Game;

import Roll2Die.Resource;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerCharacter extends Moving{

    private int playerDamage; //how much damage the player can deal on collision
    private int magicNum; //if magicNum == 1, spawn a fireball

    //player's stats after buffs + debuffs
    private int currentSTR;
    private int currentINT;
    private int currentDEX;
    private int currentVIT;
    private int currentWIS;
    private int currentLUK;

    private playerStats myPlayerStats;
    private playerBuff myPlayerBuffs;
    //myPlayerDebuffs is basically reusing the playerBuff class to make it a pseudo debuff class
    //all stats are of positive value in the "myPlayerDebuffs" but the calculations are done by subtracting
    private playerBuff myPlayerDebuffs;

    boolean isInvul;
    int tickTimerStartOfInvul;
    int tickTimerEndOfInvul;

    ArrayList<Moving> magicCastedArrayList; //we can have more than one casted magic

    public PlayerCharacter(int currX, int currY, int currVX, int currVY, float currAngle, BufferedImage currImg){
        super(currX, currY, currVX, currVY, currAngle, currImg);

        this.myPlayerStats = new playerStats("Player T", 100, 100, 25, 0, 0);
        this.myPlayerBuffs = new playerBuff(1,1,1,1,1,1);
        this.myPlayerDebuffs = new playerBuff(1, 1, 1, 1, 1,1);
        statsUpdate();

        this.magicCastedArrayList = new ArrayList<>();
    }

    public playerStats getMyPlayerStats() {
        return myPlayerStats;
    }

    public playerBuff getMyPlayerBuffs() {
        return myPlayerBuffs;
    }

    public playerBuff getMyPlayerDebuffs() {
        return myPlayerDebuffs;
    }

    public int getCurrentSTR() {
        return currentSTR;
    }

    public int getCurrentINT() {
        return currentINT;
    }

    public int getCurrentDEX() {
        return currentDEX;
    }

    public int getCurrentVIT() {
        return currentVIT;
    }

    public int getCurrentWIS() {
        return currentWIS;
    }

    public int getCurrentLUK() {
        return currentLUK;
    }

    //update stats with formula (base stat + buff - debuff) for all stats
    public void statsUpdate(){
        this.currentSTR = myPlayerStats.getBaseSTR() + myPlayerBuffs.getStrBuff() - myPlayerDebuffs.getStrBuff();
        this.currentINT = myPlayerStats.getBaseINT() + myPlayerBuffs.getIntBuff() - myPlayerDebuffs.getIntBuff();
        this.currentDEX = myPlayerStats.getBaseDEX() + myPlayerBuffs.getDexBuff() - myPlayerDebuffs.getDexBuff();
        this.currentVIT = myPlayerStats.getBaseVIT() + myPlayerBuffs.getVitBuff() - myPlayerDebuffs.getVitBuff();
        this.currentWIS = myPlayerStats.getBaseWIS() + myPlayerBuffs.getWisBuff() - myPlayerDebuffs.getWisBuff();
        this.currentLUK = myPlayerStats.getBaseLUK() + myPlayerBuffs.getLukBuff() - myPlayerDebuffs.getLukBuff();

        //makes sure if any stat is lowered too much by a debuff that itll still remain 1
        if(1 > currentSTR){
            this.currentSTR = 1;
        }
        if(1 > currentINT){
            this.currentINT = 1;
        }
        if(1 > currentDEX){
            this.currentDEX = 1;
        }
        if(1 > currentVIT){
            this.currentVIT = 1;
        }
        if(1 > currentWIS){
            this.currentWIS = 1;
        }
        if(1 > currentLUK){
            this.currentLUK = 1;
        }

        //playerDamage per collision = weapon atk + str
        this.playerDamage = this.myPlayerStats.getATK() + this.currentSTR;

    }


    public void spawnMagic(){
        Projectile currProjectile;

        switch(magicNum){
            case 1:
                currProjectile = new Fireball(this.getX(), this.getY(), 0, 0, this.getAngle(), Resource.getResourceImg("fireball"), this.currentINT);
                break;

            default:
                System.out.println("spawnMagic went to default, something is wrong!");
                break;
        }
    }
    @Override
    public void collisionDetected(GameObject currentObjectCollided) {

    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }
}
