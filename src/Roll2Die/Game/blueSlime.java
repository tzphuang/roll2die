package Roll2Die.Game;

import Roll2Die.GameConstants;

import java.awt.image.BufferedImage;

public class blueSlime extends regularMonster{

    public blueSlime(int currX, int currY, float currAngle, BufferedImage currImage) {
        super(currX, currY, currAngle, currImage);
        setMonsterHP(GameConstants.BLUESLIME_MAX_HP_VALUE);
        setMaxMonsterHp(GameConstants.BLUESLIME_MAX_HP_VALUE);
    }
}
