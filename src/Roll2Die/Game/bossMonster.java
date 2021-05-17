package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class bossMonster extends fightable{

    // Some bosses will be very big and have lots of hp
    // this means that the player should be able to attack those extra hitboxes and deal multiple damage
    protected ArrayList<Rectangle> bossExtraHitBoxes;

    bossMonster(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);
    }

    public ArrayList<Rectangle> getBossExtraHitBoxes() {
        return bossExtraHitBoxes;
    }

    public void setBossExtraHitBoxes(ArrayList<Rectangle> bossExtraHitBoxes) {
        this.bossExtraHitBoxes = bossExtraHitBoxes;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);

        if(drawHitBox){

            //draws all extra hitboxes to the screen
            gameImage.setColor(Color.RED);
            for(int index = 0; index < bossExtraHitBoxes.size(); index++){
                gameImage.drawRect((int) bossExtraHitBoxes.get(index).getX(), (int) bossExtraHitBoxes.get(index).getY(), (int) bossExtraHitBoxes.get(index).getWidth(), (int) bossExtraHitBoxes.get(index).getHeight());
            }
            gameImage.drawRect(this.getX(),this.getY(),this.getImg().getWidth(),this.getImg().getHeight());
        }

    }
}
