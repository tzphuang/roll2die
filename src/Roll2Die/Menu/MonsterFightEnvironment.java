package Roll2Die.Menu;

import Roll2Die.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

//This will be my Tank Runtime Environment essentially
//So itll be
public class MonsterFightEnvironment extends JPanel implements Runnable {

    private BufferedImage gameBackground;
    private JButton pauseButton;
    private Launcher lf;

    public MonsterFightEnvironment(Launcher lf){
        this.lf = lf;
        try {
            gameBackground = ImageIO.read(this.getClass().getClassLoader().getResource("title.png"));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        pauseButton = new JButton("Pause");
        pauseButton.setFont(new Font("Courier New", Font.BOLD ,24));
        pauseButton.setBounds(10,10,125,50);
        pauseButton.addActionListener((actionEvent -> {
            //this.lf.setFrame("game");
            //this should throw a pop up on the screen and pause the fight with monster
        }));
        this.add(pauseButton);

    }

    public void run(){

    }

    public void fightInit(){

    }


    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.gameBackground,0,0,null);
    }

    public void checkCollisions(){

    }
}
