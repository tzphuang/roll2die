package Roll2Die.Menu;

import Roll2Die.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OverWorldPanel extends JPanel {
    private Launcher lf;
    private BufferedImage overWorldBackground;
    private BufferedImage tileMap;

    //this most definitely needs to have another parameter passed in
    //the player object so it can display the player's information
    //public OverWorldPanel(Launcher lf, PlayerCharacter p1)
    public OverWorldPanel(Launcher lf)
    {
        this.lf = lf;


    }

    public void setTileMap(BufferedImage currTileMap){
        this.tileMap = currTileMap;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.overWorldBackground,0,0,null);
    }
}

