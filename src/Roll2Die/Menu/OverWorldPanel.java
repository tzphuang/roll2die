package Roll2Die.Menu;

import Roll2Die.Game.OverWorldTile;
import Roll2Die.Game.PlayerCharacter;
import Roll2Die.Game.PlayerTile;
import Roll2Die.GameConstants;
import Roll2Die.Huds.OverWorldPlayerHud;
import Roll2Die.Launcher;
import Roll2Die.Resource;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class OverWorldPanel extends JPanel {

    private Launcher lf;
    private BufferedImage overWorldBackground;

    //remove later
    private JButton monsterFightButton;

    private JButton movePlayer1Step;
    private JButton D20;
    private JButton D4;
    private JButton twoD6;

    private PlayerTile playerTile;
    private PlayerCharacter playerCharacter;
    private OverWorldPlayerHud overWorldHud;

    private ArrayList<OverWorldTile> overWorldTileMap; //arraylist of all the overWorldTiles

    //this most definitely needs to have another parameter passed in
    //the player object so it can display the player's information
    //public OverWorldPanel(Launcher lf, PlayerCharacter p1)
    public OverWorldPanel(Launcher lf) //default constructor for initialization
    {
        this.lf = lf;

        //overWorldBackground = Resource.getResourceImg("titleScreen");
        overWorldBackground = new BufferedImage(GameConstants.OVERWORLD_SCREEN_WIDTH,GameConstants.OVERWORLD_SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.setBackground(Color.RED);
        this.setLayout(null);

        addButtons();

        initializeOverWorld();

    }

    private void initializeOverWorld(){
        overWorldTileMap = new ArrayList<>();

        try{
            InputStreamReader isr1 = new InputStreamReader(OverWorldPanel.class.getClassLoader().getResourceAsStream("tile background map.txt"));
            BufferedReader tileMapReader = new BufferedReader(isr1);
            String currStringTileMap = tileMapReader.readLine();
            if(currStringTileMap == null){
                throw new IOException("no data in 'tile background map.txt'");
            }

            InputStreamReader isr2 = new InputStreamReader(OverWorldPanel.class.getClassLoader().getResourceAsStream("movement map.txt"));
            BufferedReader movementMapReader = new BufferedReader(isr2);
            String currStringMovementMap  = movementMapReader.readLine();
            if(currStringMovementMap == null){
                throw new IOException("no data in 'movement map.txt'");
            }

            String[] tileBitMap = currStringTileMap.split("\t");
            String[] movementBitMap = currStringMovementMap.split("\t");

            int numCols = Integer.parseInt(tileBitMap[0]);
            int numRows = Integer.parseInt(tileBitMap[1]);
            int offsetY = 200;
            BufferedImage currentTileImage = new BufferedImage(5,5,BufferedImage.TYPE_INT_RGB);

            for(int currRow = 0; currRow < numRows; currRow++){

                currStringTileMap = tileMapReader.readLine();
                tileBitMap = currStringTileMap.split("\t");

                currStringMovementMap = movementMapReader.readLine();
                movementBitMap = currStringMovementMap.split("\t");

                for(int currCol = 0; currCol < numCols; currCol++){

                    switch(tileBitMap[currCol]){

                        case "0":
                            currentTileImage = Resource.getResourceImg("tile0");
                            break;

                        case "1":
                            currentTileImage = Resource.getResourceImg("tile1");
                            break;

                        case "2":
                            currentTileImage = Resource.getResourceImg("tile2");
                            break;

                        case "3":
                            currentTileImage = Resource.getResourceImg("tile3");
                            break;

                        case "4":
                            currentTileImage = Resource.getResourceImg("tile4");
                            break;

                        case "5":
                            currentTileImage = Resource.getResourceImg("tile5");
                            break;

                        case "6":
                            currentTileImage = Resource.getResourceImg("tile6");
                            break;

                        case "7":
                            currentTileImage = Resource.getResourceImg("tile7");
                            break;

                        case "8":
                            currentTileImage = Resource.getResourceImg("tile8");
                            break;

                        default:
                            System.out.println("OverWorldPanel > initializeOverWorld > switch default called");
                            break;
                    }
                    OverWorldTile currentTile = new OverWorldTile(currCol*100, (currRow*100) + offsetY, 0, currentTileImage, Integer.parseInt(movementBitMap[currCol]));
                    overWorldTileMap.add(currentTile);
                }
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        playerTile = new PlayerTile(0, 900, 0, Resource.getResourceImg("overworld player img"), 1, 0);
        playerCharacter = new PlayerCharacter(0, 0,0, 0, 0, Resource.getResourceImg("overworld player img"));
        overWorldHud = new OverWorldPlayerHud(playerTile, playerCharacter);
    }

    private void addButtons(){

        //this is just to check if everything works
        //~~~ Start of check ~~~
        monsterFightButton = new JButton("Fight Boss");
        monsterFightButton.setFont(new Font("Courier New", Font.BOLD ,24));
        monsterFightButton.setBounds(1150,150,250,50);
        monsterFightButton.addActionListener((actionEvent -> {
            this.lf.setFrame("game");
        }));

        //this.add(monsterFightButton);
        //~~~ End of check ~~~

        //creating button for moving the Player 1 step
        movePlayer1Step = new JButton("Move 1 Step");
        movePlayer1Step.setFont(new Font("Courier New", Font.BOLD ,24));
        movePlayer1Step.setBounds(1200, 200, 200, 100);
        movePlayer1Step.addActionListener((actionEvent -> {
            //System.out.println("movePlayer1Step button pressed");
            if(0 < playerTile.getMoveCounter()){
                this.movePlayerNextStep();
                this.playerTile.setMoveCounter(playerTile.getMoveCounter() - 1); //decrements moveCounter by 1
                repaint();
            }

            //once the player is at the boss the button to fight the boss will be spawned in
            if(61 == playerTile.getStepNum()){
                this.add(monsterFightButton);
            }

        }));

        //creating button for 20 sided dice rolling mechanic
        //D20 = new JButton("D20");
        D20 = new JButton("");
        D20.setFont(new Font("Courier New", Font.BOLD ,24));
        D20.setIcon(new ImageIcon(Resource.getResourceImg("d20")));
        D20.setBounds(1300, 400, 100, 100);
        D20.addActionListener((actionEvent -> {
            //System.out.println("D20 button pressed");
            this.buttonPressedD20();
            repaint();
        }));

        //creating button for 4 sided dice rolling mechanic
        D4 = new JButton("");
        D4.setFont(new Font("Courier New", Font.BOLD ,24));
        D4.setIcon(new ImageIcon(Resource.getResourceImg("d4")));
        D4.setBounds(1300, 500, 100, 100);
        D4.addActionListener((actionEvent -> {
            //System.out.println("d4 button pressed");
            this.buttonPressedD4();
            repaint();
        }));

        //creating button for 2x(six sided dice) rolling mechanic
        twoD6 = new JButton("");
        twoD6.setFont(new Font("Courier New", Font.BOLD ,24));
        twoD6.setIcon(new ImageIcon(Resource.getResourceImg("2d6")));
        twoD6.setBounds(1300, 600, 100, 100);
        twoD6.addActionListener((actionEvent -> {
            //System.out.println("twoD6 button pressed");
            this.buttonPressed2D6();
            repaint();
        }));

        this.add(movePlayer1Step);

        this.add(D20);
        this.add(D4);
        this.add(twoD6);
    }

    private void movePlayerNextStep(){//moves player 1 step
        playerTile.setStepNum(playerTile.getStepNum() + 1);
        setPlayerTileToStep(playerTile.getStepNum());
    }

    /* if the currentStep is not found in the array the player will not move
     * so if the player is at number 61, the next step is 62 (which there is no tile that holds number 62)
     * itll look at the Arraylist overWorldTileMap and search through it
     * but will never assign a new position for the player
     * thus the player never moves forward
     */
    private void setPlayerTileToStep(int currStep){
        for(int index = 0; index < this.overWorldTileMap.size(); index++){
            if(currStep == overWorldTileMap.get(index).getStepNum()){
                //System.out.println("tile map found. X: " + overWorldTileMap.get(index).getX() + ", Y: "+overWorldTileMap.get(index).getY());
                playerTile.setX(overWorldTileMap.get(index).getX());
                playerTile.setY(overWorldTileMap.get(index).getY());
                return;
            }
        }
    }

    private void buttonPressedD20(){
        if(1 > playerTile.getMoveCounter()){ //when player has no more steps the dice will be rollable
            int results = (int)(Math.random() * 20) + 1; // roll d20, roll range [1-20]
            //System.out.println("D20 pressed results is: " + results);
            playerTile.setMoveCounter(results);
        }
    }

    private void buttonPressedD4(){
        if(1 > playerTile.getMoveCounter()){ //when player has no more steps the dice will be rollable
            int results = (int)(Math.random() * 4) + 1; // roll d4, roll range [1-4]
            //System.out.println("D4 pressed results is: " + results);
            playerTile.setMoveCounter(results);
        }
    }

    private void buttonPressed2D6(){
        if(1 > playerTile.getMoveCounter()){ //when player has no more steps the dice will be rollable
            int results = (int)(Math.random() * 6) + 1; // for first dice, roll range [1-6]
            results += (int)(Math.random() * 6) + 1; // for second dice, roll range [1-6]
            //System.out.println("2D6 pressed results is: " + results);
            playerTile.setMoveCounter(results);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.overWorldBackground,0,0,null);
        this.overWorldTileMap.forEach(OverWorldTile -> OverWorldTile.drawImage(g2));
        this.playerTile.drawImage(g2);
        this.overWorldHud.drawImage(g2);
    }
}

