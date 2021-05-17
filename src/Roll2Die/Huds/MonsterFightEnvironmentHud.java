package Roll2Die.Huds;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.fightable;

import java.awt.*;

public class MonsterFightEnvironmentHud extends GameHuds{
    PlayerCharacter playerCharacter;
    fightable monster;

    MonsterFightEnvironmentHud(PlayerCharacter currPlayerCharacter, fightable currMonster){
        this.playerCharacter = currPlayerCharacter;
        this.monster = currMonster;
    }


    @Override
    public void drawImage(Graphics gameImage) {

    }
}
