package Roll2Die.Huds;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.fightable;
import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MonsterFightEnvironmentHud extends GameHuds{

    private PlayerCharacter playerCharacter;
    private fightable monster;
    private int fontSize = 40;

    public MonsterFightEnvironmentHud(PlayerCharacter currPlayerCharacter, fightable currMonster){
        this.playerCharacter = currPlayerCharacter;
        this.monster = currMonster;
    }

    private void drawMonsterHealthBar(Graphics gameImage){
        BufferedImage monsterHud = new BufferedImage(GameConstants.MONSTER_HUD_HP_BAR_LENGTH, GameConstants.MONSTER_HUD_HP_BAR_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dMonsterHud = monsterHud.createGraphics();
        g2dMonsterHud.setFont(new Font("Helvetica", Font.BOLD, 25));

        g2dMonsterHud.setColor(Color.RED); //setting color for hp bar color

        double pixelPerHp = GameConstants.MONSTER_HP_BAR_LENGTH / monster.getMaxMonsterHp();
        int monsterHealthBarLength = (int) (pixelPerHp * monster.getMonsterHP());
        g2dMonsterHud.fillRect(100, 25, monsterHealthBarLength, GameConstants.MONSTER_HP_BAR_HEIGHT);

        g2dMonsterHud.setColor(Color.YELLOW); //setting color for text

        String currDrawString;
        currDrawString = "HP: " + monster.getMonsterHP();
        g2dMonsterHud.drawString(currDrawString, 0, 50);

        gameImage.drawImage(monsterHud, GameConstants.MONSTER_HUD_HP_BAR_X, GameConstants.MONSTER_HUD_HP_BAR_Y, null);
    }

    private void drawPlayerHealthBar(Graphics gameImage){
        BufferedImage playerHud = new BufferedImage(GameConstants.GAME_SCREEN_WIDTH, GameConstants.GAME_SCREEN_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dplayerHud = playerHud.createGraphics();
        g2dplayerHud.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dplayerHud.setColor(Color.GREEN); //setting color for hp bar color
        double pixelPerHp = GameConstants.PLAYER_HP_BAR_LENGTH / playerCharacter.getMyPlayerStats().getMaxPlayerHp();
        int playerHealthBarLength = (int) (pixelPerHp * playerCharacter.getMyPlayerStats().getPlayerHP());
        g2dplayerHud.fillRect(GameConstants.PLAYER_HP_BAR_X, GameConstants.PLAYER_HP_BAR_Y, playerHealthBarLength, GameConstants.PLAYER_HP_BAR_HEIGHT);

        g2dplayerHud.setColor(Color.CYAN); //setting color for hp bar color
        pixelPerHp = GameConstants.PLAYER_MP_BAR_LENGTH / playerCharacter.getMyPlayerStats().getMaxPlayerMp();
        int playerManaBarLength = (int) (pixelPerHp * playerCharacter.getMyPlayerStats().getPlayerHP());
        g2dplayerHud.fillRect(GameConstants.PLAYER_MP_BAR_X, GameConstants.PLAYER_MP_BAR_Y, playerManaBarLength, GameConstants.PLAYER_MP_BAR_HEIGHT);

        g2dplayerHud.setColor(Color.YELLOW); //setting color for text
        String currDrawString;
        currDrawString = "HP: " + playerCharacter.getMyPlayerStats().getPlayerHP();
        g2dplayerHud.drawString(currDrawString, 250, 850);

        currDrawString = "MP: " + playerCharacter.getMyPlayerStats().getPlayerMP();
        g2dplayerHud.drawString(currDrawString, 250, 900);

        gameImage.drawImage(playerHud, 0, 0, null);
    }

    private void drawPlayerPotsNumbers(Graphics gameImage){
        BufferedImage potNumberHud = new BufferedImage(100, 200,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dPotNumberHud = potNumberHud.createGraphics();
        g2dPotNumberHud.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));
        g2dPotNumberHud.setColor(Color.YELLOW); //setting color for text
        String currDrawString;

        currDrawString = "" + playerCharacter.getMyPlayerStats().getPotHP();
        g2dPotNumberHud.drawString(currDrawString, 50, 80);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getPotMP();
        g2dPotNumberHud.drawString(currDrawString, 50, 180);

        gameImage.drawImage(potNumberHud, GameConstants.PLAYER_POTS_NUMBER_HUD_X, GameConstants.PLAYER_POTS_NUMBER_HUD_Y, null);
    }

    @Override
    public void drawImage(Graphics gameImage) {
        drawMonsterHealthBar(gameImage);

        //fix this please
        //drawPlayerHealthBar(gameImage);

        drawPlayerPotsNumbers(gameImage);
    }
}
