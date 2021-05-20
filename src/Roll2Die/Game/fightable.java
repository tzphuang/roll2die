package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class fightable extends Stationary{

    private int monsterHP;
    private int maxMonsterHp;

    fightable(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);

        //sets the default monster hp if not declared to 100
        //it should be changed within the child classes of fightable
        this.monsterHP = 100;
        this.maxMonsterHp = 100;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public void setMonsterHP(int monsterHP) {
        this.monsterHP = monsterHP;
    }

    public int getMaxMonsterHp() {
        return maxMonsterHp;
    }

    public void setMaxMonsterHp(int maxMonsterHp) {
        this.maxMonsterHp = maxMonsterHp;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);

        // draws over the currentMonsterHitBox with Red to make it more obvious
        // which hitboxes are the monsters
        if(drawHitBox){
            gameImage.setColor(Color.RED);
            gameImage.drawRect(this.getX(),this.getY(),this.getImg().getWidth(),this.getImg().getHeight());
        }
    }

}
