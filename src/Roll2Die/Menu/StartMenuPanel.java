package Roll2Die.Menu;

import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class StartMenuPanel extends JPanel {

    private BufferedImage menuBackground;
    private JButton start;
    private JButton controls;
    private JButton exit;
    private Launcher lf;

    public StartMenuPanel(Launcher lf) {
        this.lf = lf;

        menuBackground = Resource.getResourceImg("titleScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        start = new JButton("Start");
        start.setFont(new Font("Courier New", Font.BOLD ,24));
        start.setBounds(175,300,150,50);
        start.addActionListener((actionEvent -> {
            this.lf.setFrame("world");
        }));

        controls = new JButton("Player Controls");
        controls.setFont(new Font("Courier New", Font.BOLD ,24));
        controls.setBounds(125,350,250,50);
        controls.addActionListener((actionEvent -> {
            this.lf.setFrame("controls");
        }));


        exit = new JButton("Exit");
        exit.setSize(new Dimension(200,100));
        exit.setFont(new Font("Courier New", Font.BOLD ,24));
        exit.setBounds(175,400,150,50);
        exit.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));


        this.add(start);
        this.add(controls);
        this.add(exit);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}
