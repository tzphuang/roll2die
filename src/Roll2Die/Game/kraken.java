package Roll2Die.Game;

import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class kraken extends bossMonster{


    public kraken(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);
        this.setMonsterHP(GameConstants.KRAKEN_MAX_HP_VALUE);
        this.setMaxMonsterHp(GameConstants.KRAKEN_MAX_HP_VALUE);


        //the below added extra hitboxes are just place holders
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
