package Roll2Die.Menu;

import Roll2Die.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TankControlsPanel extends JPanel{

    private BufferedImage menuBackground;
    private JButton controls;
    private Launcher lf;

    public TankControlsPanel(Launcher lf) {
        this.lf = lf;
        try {
            menuBackground = ImageIO.read(this.getClass().getClassLoader().getResource("labledcontrols.png"));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        controls = new JButton("Main Menu");
        controls.setFont(new Font("Courier New", Font.BOLD ,24));
        controls.setBounds(575,375,250,50);
        controls.addActionListener((actionEvent -> {
            this.lf.setFrame("start");
        }));


        this.add(controls);

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
