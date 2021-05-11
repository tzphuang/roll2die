package Roll2Die.Huds;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.PlayerTile;
import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OverWorldPlayerHud extends GameHuds{

    private PlayerTile playerTile;
    private PlayerCharacter playerCharacter;
    private final int x1 = 15;
    private final int y1 = 28;
    private final int fontSize = 28;

    public OverWorldPlayerHud(PlayerTile currPlayerTile, PlayerCharacter currPlayerCharacter){
        this.playerTile = currPlayerTile;
        this.playerCharacter = currPlayerCharacter;
    }

    private void drawPlayerMainStats(Graphics gameImage){
        BufferedImage mainStats = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dTopHud = mainStats.createGraphics();
        g2dTopHud.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dTopHud.setColor(Color.BLACK);
        g2dTopHud.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dTopHud.setColor(Color.YELLOW); //setting color for text

        String currDrawString;
        currDrawString = "Name: " + playerCharacter.getMyPlayerStats().getName();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*1);

        currDrawString = "HP: " + playerCharacter.getMyPlayerStats().getPlayerHP();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*2);

        currDrawString = "MP: " + playerCharacter.getMyPlayerStats().getPlayerMP();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*3);

        currDrawString = "Gold: " + playerCharacter.getMyPlayerStats().getGold();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*4);

        currDrawString = "HP Pots: " + playerCharacter.getMyPlayerStats().getPotHP();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*5);

        currDrawString = "MP Pots: " + playerCharacter.getMyPlayerStats().getPotMP();
        g2dTopHud.drawString(currDrawString, this.x1, this.y1*6);

        gameImage.drawImage(mainStats, 0, 0, null);
    }

    private void drawPlayerSubStats(Graphics gameImage){

        BufferedImage currentSubStats = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dcurrSubStats = currentSubStats.createGraphics();
        g2dcurrSubStats.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dcurrSubStats.setColor(Color.BLACK);
        g2dcurrSubStats.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_SKILL_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dcurrSubStats.setColor(Color.YELLOW); //setting color for text

        String currDrawString;

        // Draws total of Skill Stats after buffs and debuffs in yellow
        currDrawString = "STR: " + playerCharacter.getCurrentSTR();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*1);

        currDrawString = "INT: " + playerCharacter.getCurrentINT();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*2);

        currDrawString = "DEX: " + playerCharacter.getCurrentDEX();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*3);

        currDrawString = "VIT: " + playerCharacter.getCurrentVIT();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*4);

        currDrawString = "WIS: " + playerCharacter.getCurrentWIS();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*5);

        currDrawString = "LUK: " + playerCharacter.getCurrentLUK();
        g2dcurrSubStats.drawString(currDrawString, this.x1, this.y1*6);

        gameImage.drawImage(currentSubStats, GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, 0, null);
    }

    private void drawPlayerSubBaseStats(Graphics gameImage){

        BufferedImage subBaseStats = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBaseStats = subBaseStats.createGraphics();
        g2dBaseStats.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dBaseStats.setColor(Color.BLACK);
        g2dBaseStats.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_SKILL_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dBaseStats.setColor(Color.GRAY); //setting color for text

        String currDrawString;

        // Draws total of Base Skill Stats
        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseSTR();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*1);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseINT();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*2);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseDEX();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*3);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseVIT();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*4);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseWIS();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*5);

        currDrawString = "" + playerCharacter.getMyPlayerStats().getBaseLUK();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*6);

        gameImage.drawImage(subBaseStats, GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH + 150, 0, null);
    }

    private void drawPlayerSubBuffStats(Graphics gameImage){

        BufferedImage subStatsBuff = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dStatsBuff = subStatsBuff.createGraphics();
        g2dStatsBuff.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dStatsBuff.setColor(Color.BLACK);
        g2dStatsBuff.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_SKILL_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dStatsBuff.setColor(Color.GREEN); //setting color for text

        String currDrawString;

        // Draws total of Base Skill Stats
        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getStrBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*1);

        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getIntBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*2);

        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getDexBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*3);

        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getVitBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*4);

        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getWisBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*5);

        currDrawString = "+" + playerCharacter.getMyPlayerBuffs().getLukBuff();
        g2dStatsBuff.drawString(currDrawString, this.x1, this.y1*6);

        gameImage.drawImage(subStatsBuff, GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH + 225, 0, null);
    }

    private void drawPlayerSubDebuffStats(Graphics gameImage){

        BufferedImage subBaseStats = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBaseStats = subBaseStats.createGraphics();
        g2dBaseStats.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dBaseStats.setColor(Color.BLACK);
        g2dBaseStats.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_SKILL_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dBaseStats.setColor(Color.RED); //setting color for text

        String currDrawString;

        // Draws total of Base Skill Stats
        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getStrBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*1);

        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getIntBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*2);

        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getDexBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*3);

        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getVitBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*4);

        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getWisBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*5);

        currDrawString = "-" + playerCharacter.getMyPlayerDebuffs().getLukBuff();
        g2dBaseStats.drawString(currDrawString, this.x1, this.y1*6);

        gameImage.drawImage(subBaseStats, GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH + 300, 0, null);
    }

    private void drawPlayerTileStats(Graphics gameImage){
        BufferedImage mainStats = new BufferedImage(GameConstants.OVERWORLD_HUD_PLAYER_TILE_INFO_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dTopHud = mainStats.createGraphics();
        g2dTopHud.setFont(new Font("Helvetica", Font.BOLD, this.fontSize));

        g2dTopHud.setColor(Color.BLACK);
        g2dTopHud.fillRect(0,0,GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT);

        g2dTopHud.setColor(Color.YELLOW); //setting color for text

        String currDrawString;

        currDrawString = "Player on panel: " + playerTile.getStepNum();
        g2dTopHud.drawString(currDrawString, x1, y1*1);

        currDrawString = "Movement Counter: " + playerTile.getMoveCounter();
        g2dTopHud.drawString(currDrawString, x1, y1*2);

        gameImage.drawImage(mainStats, GameConstants.OVERWORLD_HUD_PLAYER_MAIN_STATS_WIDTH + GameConstants.OVERWORLD_HUD_PLAYER_SKILL_STATS_WIDTH, 0, null);
    }

    @Override
    public void drawImage(Graphics gameImage) {
        drawPlayerMainStats(gameImage);
        drawPlayerSubStats(gameImage);
        drawPlayerSubBaseStats(gameImage);
        drawPlayerSubBuffStats(gameImage);
        drawPlayerSubDebuffStats(gameImage);
        drawPlayerTileStats(gameImage);
    }
}
