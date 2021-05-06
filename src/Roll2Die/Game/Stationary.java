package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Stationary extends GameObject{

    Stationary(int currX, int currY, float currAngle, BufferedImage currImage){
        super(currX, currY, currAngle, currImage);
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }
}
