package Roll2Die.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Moving{

    private final int projectileSpeed = 7;
    private int damage;

    Projectile(int currX, int currY, int currVX, int currVY, float currAngle, BufferedImage currImg, int currDamage){
        super(currX, currY, currVX, currVY, currAngle, currImg);
        this.damage = currDamage;
    }

    public void setBulletDamage(int currBulletDamage){
        this.damage = currBulletDamage;
    }

    public int getBulletDamage(){
        return damage;
    }

    @Override
    protected void moveForwards() {
        setVx( (int) Math.round( projectileSpeed * Math.cos( Math.toRadians( getAngle() ) ) ) );
        setVy( (int) Math.round( projectileSpeed * Math.sin( Math.toRadians( getAngle() ) ) ) );

        setX(getX() + getVx());
        setY(getY() + getVy());

        checkBorder();
        this.setHitBox(getX(),getY());
    }

    public void update(){
        moveForwards();
    }

    @Override
    public void drawImage(Graphics gameImage) {
        super.drawImage(gameImage);
    }

    //this is not needed as of now cause Im going to apply the damage to the boss in the in th MonsterFightEnvironment
    //and then delete the instance of the object that collided with the boss
    public void collisionDetected(GameObject currentObjectCollided){
        /*if(currentObjectCollided instanceof Unbreakable){

        }*/
    }

}