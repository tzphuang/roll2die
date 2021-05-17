package Roll2Die.Menu;

import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.fightable;
import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//This will be my Tank Runtime Environment essentially
//So itll be
public class MonsterFightEnvironment extends JPanel implements Runnable {

    private BufferedImage gameBackground;
    private JButton pauseButton;
    private JButton winnerButton;
    private Launcher lf;
    private ArrayList<Rectangle> mouseHitBoxes; //used to store all mouse hitboxes
    private ArrayList<Rectangle> bossHitBoxes;
    private fightable monster;
    private PlayerCharacter player;

    public void setCurrMonsterToFight(fightable currentMonster){
        this.monster = currentMonster;
    }

    public void setCurrPlayerCharacter(PlayerCharacter currPlayer){
        this.player = currPlayer;
    }

    public MonsterFightEnvironment(Launcher lf){
        this.lf = lf;

        gameBackground = Resource.getResourceImg("endScreen");
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        pauseButton = new JButton("Pause");
        pauseButton.setFont(new Font("Courier New", Font.BOLD ,24));
        pauseButton.setBounds(10,10,150,50);
        pauseButton.addActionListener((actionEvent -> {
            this.lf.setFrame("end");
            //this should throw a pop up on the screen and pause the fight with monster
        }));

        winnerButton = new JButton("Winner");
        winnerButton.setFont(new Font("Courier New", Font.BOLD ,24));
        winnerButton.setBounds(10,60,150,50);
        winnerButton.addActionListener((actionEvent -> {
            this.lf.setFrame("win");
            //this should throw a pop up on the screen and pause the fight with monster
        }));

        this.add(pauseButton);
        this.add(winnerButton);

    }

    public void run(){

    }

    // fightInit should take in the hitboxes array from the current monster
    // and have it stored? cant i just have the collider methods take in the actual hitboxes
    // i guess i wrote it this way because i didnt know what to call my classes
    // so this was just me coding ahead of time to get my thoughts out
    public void fightInit(){

        //his should be filled by mouse click + mouse drag + mouse release
        //mouseHitBoxes = new ArrayList<>();

        //this should be filled by the boss object
        //bossHitBoxes = new ArrayList<>();
    }


    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.gameBackground,0,0,null);
    }

    public void checkCollisions()
    {
        //Checking each mouse hitbox in the mouseHitBoxes array against all
        //bossHitBoxes and deletes the mouseHitBoxes AFTER (very important)
        //checking all enemy hitboxes
        for(int indexMouseArray = 0; indexMouseArray < mouseHitBoxes.size(); indexMouseArray++){

            //first loop through the intersects checks the hitboxes to apply damage according
            //to how many hitboxes the mouse click intersected multiplied number of boss
            for(int indexBossArray = 0; indexBossArray < bossHitBoxes.size(); indexBossArray++){
                if(mouseHitBoxes.get(indexMouseArray).intersects(bossHitBoxes.get(indexBossArray))){
                    //apply damage to boss for EVERY hitbox collided with on current mouse drag
                }
            }

            //second loop deletes the mouse hitbox and decrements the
            for(int indexBossArray = 0; indexBossArray < bossHitBoxes.size(); indexBossArray++){
                if(mouseHitBoxes.get(indexMouseArray).intersects(bossHitBoxes.get(indexBossArray))){
                    //Remove that hitbox on first found intersection
                    mouseHitBoxes.remove(indexMouseArray);
                    //decrements the index array to account for the now missing mouseHitBox
                    indexMouseArray--;
                    //break out of this for loop so we can check the next mouseHitBox immediately
                    break;
                }
            }
        }

        //loop through boss hitboxes and compare them to the player
        /*
        * example player was hit at timer 1000
        * since player was hit the player should not be hit for 144 game ticks (1 second)
        * so at 1144 timer the player should be able to be hit again
        *
        * basically use a boolean check like (boolean playerIsInvul)
        * to even go into the collision checker loop
        * against the player's hitbox and stop it before it can run
        * but if the player hasnt been hit it will just go into the loop as normal
         */

    }
}
