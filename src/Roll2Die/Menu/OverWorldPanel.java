package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OverWorldPanel extends JPanel {
    private Launcher lf;
    private BufferedImage overWorldBackground;
    private BufferedImage tileMap;
    private JButton monsterFightButton;

    //this most definitely needs to have another parameter passed in
    //the player object so it can display the player's information
    //public OverWorldPanel(Launcher lf, PlayerCharacter p1)
    public OverWorldPanel(Launcher lf)
    {
        this.lf = lf;

        //this is just to check if everything works
        //~~~ Start of check ~~~
        overWorldBackground = Resource.getResourceImg("titleScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        monsterFightButton = new JButton(">>>Boss Fight");
        monsterFightButton.setFont(new Font("Courier New", Font.BOLD ,24));
        monsterFightButton.setBounds(575,375,250,50);
        monsterFightButton.addActionListener((actionEvent -> {
            this.lf.setFrame("game");
        }));
        this.add(monsterFightButton);
        //~~~ End of check ~~~

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

