package Roll2Die.Game;

import Roll2Die.GameConstants;

public class playerStats {
    //player's general stats
    private String name;
    private int playerHP;
    private int playerMP;
    private int gold;
    private int ATK; // this represents player "weapon" stat
    private int DEF; // this represents player "armor" stat
    private int potHP; //how many hp pots the player has
    private int potMP; //how many mp pots the player has

    private int MaxPlayerHp;
    private int MaxPlayerMp;

    //player's base stats they should never change
    private final int baseSTR = 10; // used to calculate ATK
    private final int baseINT = 10; // used to calculate damage done by magic
    private final int baseDEX = 3; // used to determine how many hitboxes can be attacked in a single mouse drag
    private final int baseVIT = 10; // used to calculate health regen
    private final int baseWIS = 10; // used to calculate mana regen
    private final int baseLUK = 1; // used to determine how much extra gold you get after a battle


    playerStats(String currName, int currHP, int currMP, int currGold, int currATK, int currDEF, int currPotHP, int currPotMP){
        this.name = currName;
        this.playerHP = currHP;
        this.playerMP = currMP;
        this.gold = currGold;
        this.ATK = currATK;
        this.DEF = currDEF;
        this.potHP = currPotHP;
        this.potMP = currPotMP;
        this.MaxPlayerHp = GameConstants.PLAYER_MAX_HP_VALUE;
        this.MaxPlayerMp = GameConstants.PLAYER_MAX_MP_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerMP() {
        return playerMP;
    }

    public void setPlayerMP(int playerMP) {
        this.playerMP = playerMP;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getMaxPlayerHp() {
        return MaxPlayerHp;
    }

    public void setMaxPlayerHp(int maxPlayerHp) {
        MaxPlayerHp = maxPlayerHp;
    }

    public int getMaxPlayerMp() {
        return MaxPlayerMp;
    }

    public void setMaxPlayerMp(int maxPlayerMp) {
        MaxPlayerMp = maxPlayerMp;
    }

    public int getPotHP() {
        return potHP;
    }

    public void setPotHP(int potHP) {
        this.potHP = potHP;
    }

    public int getPotMP() {
        return potMP;
    }

    public void setPotMP(int potMP) {
        this.potMP = potMP;
    }

    public int getBaseSTR() {
        return baseSTR;
    }

    public int getBaseINT() {
        return baseINT;
    }

    public int getBaseDEX() {
        return baseDEX;
    }

    public int getBaseVIT() {
        return baseVIT;
    }

    public int getBaseWIS() {
        return baseWIS;
    }

    public int getBaseLUK() {
        return baseLUK;
    }

}
