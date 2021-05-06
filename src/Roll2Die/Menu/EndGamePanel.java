package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EndGamePanel extends JPanel {

    private BufferedImage menuBackground;
    private JButton start;
    private JButton exit;
    private Launcher lf;

    public EndGamePanel(Launcher lf) {
        this.lf = lf;

        menuBackground = Resource.getResourceImg("endScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        start = new JButton("Main Menu");
        start.setFont(new Font("Courier New", Font.BOLD ,24));
        start.setBounds(175,300,150,50);
        start.addActionListener((actionEvent -> {
            this.lf.setFrame("start");
        }));


        exit = new JButton("Exit");
        exit.setFont(new Font("Courier New", Font.BOLD ,24));
        exit.setBounds(175,350,150,50);
        exit.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));


        this.add(start);
        this.add(exit);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}
