package Roll2Die.Game;

import Roll2Die.GameConstants;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Moving extends GameObject{

    //x velocity of object
    private int vx;
    //y velocity of object
    private int vy;

    private final int R = 2;

    //how fast object can move
    private final int OBJECTSPEED = 2;
    //how fast the object's rotation can be
    private final float ROTATIONSPEED = 3.0f;

    Moving(int currX, int currY, int currVX, int currVY, float currAngle, BufferedImage currImg){
        super(currX, currY, currAngle, currImg);
        this.vx = currVX;
        this.vy = currVY;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public int getOBJECTSPEED() {
        return OBJECTSPEED;
    }

    public float getROTATIONSPEED() {
        return ROTATIONSPEED;
    }

    protected void rotateLeft() {
        setAngle(getAngle() - ROTATIONSPEED);
    }

    protected void rotateRight() {
        setAngle(getAngle() + ROTATIONSPEED);
    }

    protected void moveBackwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(getAngle())));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(getAngle())));

        setX(getX() - vx);
        setY(getY() - vy);

        checkBorder();
        this.setHitBox(getX(),getY());
    }

    protected void moveForwards() {
        vx = (int) Math.round(R * Math.cos(Math.toRadians(getAngle())));
        vy = (int) Math.round(R * Math.sin(Math.toRadians(getAngle())));

        setX(getX() + vx);
        setY(getY() + vy);

        checkBorder();
        this.setHitBox(getX(),getY());
    }

    protected void checkBorder() {
        if (getX() < 30) {
            setX(30);
        }
        if (getX() >= GameConstants.WORLD_WIDTH - 88) {
            setX(GameConstants.WORLD_WIDTH - 88);
        }
        if (getY() < 40) {
            setY(40);
        }
        if (getY() >= GameConstants.WORLD_HEIGHT - 80) {
            setY(GameConstants.WORLD_HEIGHT - 80);
        }
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }

    //this is here and not in gameObject because only moving objects will collide with other gameObjects
    public abstract void collisionDetected(GameObject currentObjectCollided);
}
