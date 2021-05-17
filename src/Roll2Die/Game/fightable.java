package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class fightable extends Stationary{

    fightable(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);
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
