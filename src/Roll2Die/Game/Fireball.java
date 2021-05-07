package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Fireball extends Projectile{


    Fireball(int currX, int currY, int currVX, int currVY, float currAngle, BufferedImage currImg, int currDamage){
        super(currX, currY, currVX, currVY, currAngle, currImg, currDamage);
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }

    public void collisionDetected(GameObject currentObjectCollided){
        super.collisionDetected(currentObjectCollided);
    }

}
