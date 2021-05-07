package Roll2Die.Game;

public class playerBuff {
    private int strBuff;
    private int intBuff;
    private int dexBuff;
    private int vitBuff;
    private int wisBuff;
    private int lukBuff;

    playerBuff(int currSTR, int currINT, int currDEX, int currVIT, int currWIS, int currLUK){
        this.strBuff = currSTR;
        this.intBuff = currINT;
        this.dexBuff = currDEX;
        this.vitBuff = currVIT;
        this.wisBuff = currWIS;
        this.lukBuff = currLUK;
    }

    public int getStrBuff() {
        return strBuff;
    }

    public void setStrBuff(int strBuff) {
        this.strBuff = strBuff;
    }

    public int getIntBuff() {
        return intBuff;
    }

    public void setIntBuff(int intBuff) {
        this.intBuff = intBuff;
    }

    public int getDexBuff() {
        return dexBuff;
    }

    public void setDexBuff(int dexBuff) {
        this.dexBuff = dexBuff;
    }

    public int getVitBuff() {
        return vitBuff;
    }

    public void setVitBuff(int vitBuff) {
        this.vitBuff = vitBuff;
    }

    public int getWisBuff() {
        return wisBuff;
    }

    public void setWisBuff(int wisBuff) {
        this.wisBuff = wisBuff;
    }

    public int getLukBuff() {
        return lukBuff;
    }

    public void setLukBuff(int lukBuff) {
        this.lukBuff = lukBuff;
    }
}
