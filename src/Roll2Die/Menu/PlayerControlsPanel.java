package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerControlsPanel extends JPanel{

    private BufferedImage menuBackground;
    private JButton mainMenu;
    private Launcher lf;

    public PlayerControlsPanel(Launcher lf) {

        this.lf = lf;

        menuBackground = Resource.getResourceImg("titleScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        mainMenu = new JButton("Back");
        mainMenu.setFont(new Font("Courier New", Font.BOLD ,24));
        mainMenu.setBounds(0,0,150,50);
        mainMenu.addActionListener((actionEvent -> {
            this.lf.setFrame("start");
        }));


        this.add(mainMenu);

}

    @Override
    public void paintComponent(Graphics g){
        //use a graphics2d object (g2)
        //and draw the image passed in (graphic g) which is a buffered image
        //onto the current menu's background image
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}
