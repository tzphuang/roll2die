package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class kraken extends bossMonster{


    kraken(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);


        Rectangle extraHitBox = new Rectangle(0, 0, 100, 100);
        bossExtraHitBoxes.add(extraHitBox);

        extraHitBox = new Rectangle(100, 0, 100, 100);
        bossExtraHitBoxes.add(extraHitBox);

        extraHitBox = new Rectangle(200, 0, 100, 100);
        bossExtraHitBoxes.add(extraHitBox);

        extraHitBox = new Rectangle(300, 0, 100, 100);
        bossExtraHitBoxes.add(extraHitBox);
    }
}
