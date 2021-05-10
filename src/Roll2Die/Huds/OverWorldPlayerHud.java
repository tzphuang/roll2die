package Roll2Die.Huds;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.PlayerTile;
import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OverWorldPlayerHud extends GameHuds{

    private PlayerTile playerTile;
    private PlayerCharacter playerCharacter;

    public OverWorldPlayerHud(PlayerTile currPlayerTile, PlayerCharacter currPlayerCharacter){
        this.playerTile = currPlayerTile;
        this.playerCharacter = currPlayerCharacter;
    }

    @Override
    public void drawImage(Graphics gameImage) {
        BufferedImage topHud = new BufferedImage(GameConstants.OVERWORLD_HUD_WIDTH, GameConstants.OVERWORLD_HUD_HEIGHT,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dTopHud = topHud.createGraphics();

        g2dTopHud.setFont(new Font("Helvetica", Font.BOLD, 36));

        g2dTopHud.setColor(Color.GRAY); //setting color for background of over world HUD
        g2dTopHud.fillRect(0,0,1400,200);

        g2dTopHud.setColor(Color.YELLOW); //setting color for text

        int x1 = 20;
        int y1 = 40;
        String currDrawString;
        currDrawString = "Name: " + playerCharacter.getMyPlayerStats().getName();
        g2dTopHud.drawString(currDrawString, x1, y1*1);

        currDrawString = "HP: " + playerCharacter.getMyPlayerStats().getPlayerHP();
        g2dTopHud.drawString(currDrawString, x1, y1*2);

        currDrawString = "MP: " + playerCharacter.getMyPlayerStats().getPlayerMP();
        g2dTopHud.drawString(currDrawString, x1, y1*3);

        currDrawString = "Gold: " + playerCharacter.getMyPlayerStats().getGold();
        g2dTopHud.drawString(currDrawString, x1, y1*4);

        int x2 = 400;

        currDrawString = "STR: " + playerCharacter.getCurrentSTR();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*1);

        currDrawString = "INT: " + playerCharacter.getCurrentINT();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*2);

        currDrawString = "DEX: " + playerCharacter.getCurrentDEX();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*3);

        x2 = 600;

        currDrawString = "VIT: " + playerCharacter.getCurrentSTR();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*1);

        currDrawString = "WIS: " + playerCharacter.getCurrentINT();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*2);

        currDrawString = "LUK: " + playerCharacter.getCurrentDEX();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*3);

        x2 = 800;

        currDrawString = "Player on panel: " + playerTile.getStepNum();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*1);

        currDrawString = "Movement Counter: " + playerTile.getMoveCounter();
        g2dTopHud.drawString(currDrawString, x1+x2, y1*2);


        gameImage.drawImage(topHud, 0, 0, null);
    }
}
