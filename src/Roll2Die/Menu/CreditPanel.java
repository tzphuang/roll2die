package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CreditPanel extends JPanel {

    private BufferedImage menuBackground;
    private JButton closeGame;
    private Launcher lf;

    public CreditPanel(Launcher lf) {
        this.lf = lf;

        menuBackground = Resource.getResourceImg("endScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        closeGame = new JButton("Exit");
        closeGame.setFont(new Font("Courier New", Font.BOLD ,24));
        closeGame.setBounds(0,0,150,50);
        closeGame.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));

        this.add(closeGame);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}

