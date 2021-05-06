package Roll2Die.Game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public abstract class GameObject implements Drawable{

    //x position on the map for object
    private int x;
    //y position on the map for object
    private int y;

    public static boolean drawHitBox = true;

    //angle of object
    private float angle = 0;

    //object's image
    private BufferedImage objectImg;

    //object's hitBox
    private Rectangle hitBox;

    GameObject(int currX, int currY, float currAngle, BufferedImage currImage){
        this.x = currX;
        this.y = currY;
        this.angle = currAngle;
        this.objectImg = currImage;
        this.hitBox = new Rectangle(x,y, this.objectImg.getWidth(), this.objectImg.getHeight());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAngle(float newAngle){
        this.angle = newAngle;
    }

    public void setImg(BufferedImage newImage){this.objectImg = newImage;}

    public void setHitBox(int x, int y){
        this.hitBox.setLocation(x,y);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public float getAngle(){
        return angle;
    }

    public BufferedImage getImg(){
        return objectImg;
    }

    public Rectangle getHitBox(){
        return this.hitBox.getBounds();
    }


    public void drawImage(Graphics gameImage){

        //takes current image and keeps its image "line straightness", will be used to rotate image
        AffineTransform currRotation = AffineTransform.getTranslateInstance(x, y);
        currRotation.rotate(Math.toRadians(angle),this.objectImg.getWidth() / 2.0, this.objectImg.getHeight() /2.0);
        Graphics2D currImage = (Graphics2D) gameImage;
        currImage.drawImage(this.objectImg, currRotation, null);

        if(drawHitBox){
            gameImage.setColor(Color.GREEN);
            gameImage.drawRect(x,y,this.objectImg.getWidth(),this.objectImg.getHeight());
        }
    }
}
