package Roll2Die.Huds;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.fightable;
import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MonsterFightEnvironmentHud extends GameHuds{
    public static int drawImageCounter = 0;
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

        BufferedImage playerHud = new BufferedImage(GameConstants.PLAYER_HUD_HP_BAR_LENGTH, GameConstants.PLAYER_HUD_HP_BAR_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dplayerHud = playerHud.createGraphics();
        g2dplayerHud.setFont(new Font("Helvetica", Font.BOLD, 25));

        g2dplayerHud.setColor(Color.GREEN); //setting color for hp bar color
        double pixelPerHp = GameConstants.PLAYER_HP_BAR_LENGTH / playerCharacter.getMyPlayerStats().getMaxPlayerHp();
        int playerHealthBarLength = (int) (pixelPerHp * playerCharacter.getMyPlayerStats().getPlayerHP());
        g2dplayerHud.fillRect(100, 0, playerHealthBarLength, GameConstants.PLAYER_HP_BAR_HEIGHT);

        g2dplayerHud.setColor(Color.CYAN); //setting color for hp bar color
        pixelPerHp = GameConstants.PLAYER_MP_BAR_LENGTH / playerCharacter.getMyPlayerStats().getMaxPlayerMp();
        int playerManaBarLength = (int) (pixelPerHp * playerCharacter.getMyPlayerStats().getPlayerHP());
        g2dplayerHud.fillRect(100, 50, playerManaBarLength, GameConstants.PLAYER_MP_BAR_HEIGHT);

        g2dplayerHud.setColor(Color.YELLOW); //setting color for text
        String currDrawString;

        currDrawString = "HP: " + playerCharacter.getMyPlayerStats().getPlayerHP();
        g2dplayerHud.drawString(currDrawString,0, 25);

        currDrawString = "MP: " + playerCharacter.getMyPlayerStats().getPlayerMP();
        g2dplayerHud.drawString(currDrawString, 0, 75);

        gameImage.drawImage(playerHud, GameConstants.PLAYER_HUD_HP_BAR_X, GameConstants.PLAYER_HUD_HP_BAR_Y, null);
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
        //System.out.println("Drawimage iteration: " + drawImageCounter++);

        drawMonsterHealthBar(gameImage);
        drawPlayerHealthBar(gameImage);
        drawPlayerPotsNumbers(gameImage);
    }
}
