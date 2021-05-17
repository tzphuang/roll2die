package Roll2Die;
import Roll2Die.Menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Launcher {

    /*
     * Main panel in JFrame, the layout of this panel
     * will be card layout, this will allow us to switch
     * to sub-panels depending on game state.
     */
    private JPanel mainPanel;

    /*
     * start panel will be used to view the start menu. It will contain
     * two buttons start and exit.
     */
    private JPanel startPanel;


    private JPanel controlPanel;

    private JPanel worldPanel;

    private JPanel winPanel;

    private JPanel creditPanel;

    /*
     * end panel is used to show the end game panel.  it will contain
     * two buttons restart and exit.
     */
    private JPanel endPanel;



    /*
     * game panel is used to show our game to the screen. inside this panel
     * also contains the game loop. This is where out objects are updated and
     * redrawn. This panel will execute its game loop on a separate thread.
     * This is to ensure responsiveness of the GUI. It is also a bad practice to
     * run long running loops(or tasks) on Java Swing's main thread. This thread is
     * called the event dispatch thread.
     */
    private MonsterFightEnvironment gamePanel;

    /*
     * JFrame used to store our main panel. We will also attach all event
     * listeners to this JFrame.
     */
    private JFrame jf;
    /*
     * CardLayout is used to manage our sub-panels. This is a layout manager
     * used for our game. It will be attached to the main panel.
     */
    private CardLayout cl;

    public Launcher(){
        this.jf = new JFrame();             // creating a new JFrame object
        this.jf.setTitle("Roll2Die"); // setting the title of the JFrame window.
        this.jf.setLocationRelativeTo(null); // this will open the window in the center of the screen.
        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when the GUI is closed, this will also shutdown the VM
    }

    private void initUIComponents(){
        this.mainPanel = new JPanel(); // create a new main panel

        this.startPanel = new StartMenuPanel(this); // create a new start panel
        this.controlPanel = new PlayerControlsPanel(this);
        this.gamePanel = new MonsterFightEnvironment(this); // create a new game panel

        // overWorld panel creation must come after gamePanel creation
        // because OverWorldPanel creates the playerCharacter and passes it into gamePanel
        // and if you switch the order you get a null pointer exception
        // because the gamepanel is not yet created so you cant set any of its components yet
        this.worldPanel = new OverWorldPanel(this);

        this.endPanel = new EndGamePanel(this); // create a new end game pane;
        this.winPanel = new WinnerPanel(this);
        this.creditPanel = new CreditPanel(this);

        cl = new CardLayout(); // creating a new CardLayout Panel
        this.mainPanel.setLayout(cl); // set the layout of the main panel to our card layout

        this.mainPanel.add(startPanel, "start"); //add the start panel to the main panel
        this.mainPanel.add(controlPanel, "controls");
        this.mainPanel.add(worldPanel, "world");
        this.mainPanel.add(gamePanel, "game");   //add the game panel to the main panel
        this.mainPanel.add(endPanel, "end");    // add the end game panel to the main panel
        this.mainPanel.add(winPanel, "win");
        this.mainPanel.add(creditPanel, "credit");

        this.jf.add(mainPanel); // add the main panel to the JFrame
        this.jf.setResizable(false); //make the JFrame not resizable
        this.setFrame("start"); // set the current panel to start panel
    }

    public void setFrame(String type){
        this.jf.setVisible(false); // hide the JFrame
        switch(type){
            case "start":
                // set the size of the jFrame to the expected size for the start panel
                this.jf.setSize(GameConstants.START_MENU_SCREEN_WIDTH,GameConstants.START_MENU_SCREEN_HEIGHT);
                break;

            case "controls":
                this.jf.setSize(GameConstants.CONTROLS_MENU_SCREEN_WIDTH,GameConstants.CONTROLS_MENU_SCREEN_HEIGHT);
                break;

            case "world":
                this.jf.setSize(GameConstants.OVERWORLD_SCREEN_WIDTH, GameConstants.OVERWORLD_SCREEN_HEIGHT);
                break;

            case "game":
                // set the size of the jFrame to the expected size for the game panel
                this.jf.setSize(GameConstants.GAME_SCREEN_WIDTH,GameConstants.GAME_SCREEN_HEIGHT);
                //start a new thread for the game to run. This will ensure our JFrame is responsive and
                // not stuck executing the game loop.
                (new Thread(this.gamePanel)).start();
                break;

            case "end":
                // set the size of the jFrame to the expected size for the end panel
                this.jf.setSize(GameConstants.END_MENU_SCREEN_WIDTH,GameConstants.END_MENU_SCREEN_HEIGHT);
                break;

            case "win":
                this.jf.setSize(GameConstants.WINNER_SCREEN_WIDTH,GameConstants.WINNER_SCREEN_HEIGHT);
                break;

            case "credit":
                this.jf.setSize(GameConstants.CREDIT_SCREEN_WIDTH,GameConstants.CREDIT_SCREEN_HEIGHT);
                break;
        }
        this.cl.show(mainPanel, type); // change current panel shown on main panel tp the panel denoted by type.
        this.jf.setVisible(true); // show the JFrame
    }

    public MonsterFightEnvironment getGamePanel() {
        return gamePanel;
    }

    public JFrame getJf() {
        return jf;
    }

    public void closeGame(){
        this.jf.dispatchEvent(new WindowEvent(this.jf, WindowEvent.WINDOW_CLOSING));
    }


    public static void main(String[] args) {
        Launcher launch = new Launcher();
        launch.initUIComponents();
    }


}
