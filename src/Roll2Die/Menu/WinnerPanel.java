package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WinnerPanel extends JPanel {

    private BufferedImage menuBackground;
    private JButton goToCredits;
    private Launcher lf;

    public WinnerPanel(Launcher lf) {
        this.lf = lf;

        menuBackground = Resource.getResourceImg("winnerScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        goToCredits = new JButton("Credits");
        goToCredits.setFont(new Font("Courier New", Font.BOLD ,24));
        goToCredits.setBounds(175,300,150,50);
        goToCredits.addActionListener((actionEvent -> {
            this.lf.setFrame("credit");
        }));

        this.add(goToCredits);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}

