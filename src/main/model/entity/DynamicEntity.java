package main.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public interface DynamicEntity {

    /**
     * Updates the entity position on the screen.
     * */
    void updatePosition();
    /**
     * 
     * @return a new Rectangle2D that represents the coordinates and the dimension of the entity
     */
    Rectangle2D getBounds();

    /**
     * Set the speed of the entity.
     * @param speedX 
     */
    void setSpeedX(double speedX);

    /**
     * Check if the entity is out of the screen.
     * @return true if the entity is out of the screen, false otherwise 
     */
    boolean isOutofScreen();

    /**
     * Set the entity's image. 
     * @param image the image associated to the entity 
     */
    void setImage(Image image);

    /**
     * Get the image related with the entity.
     * @return the image corresponding to the entity
     */
    Image getImage();

    /**
     * 
     * @return the level in which the entity is placed. 
     */
    EntityLevelType getLevelType();

    /**
     * 
     * @return the distance of the next entity
     */
    double getDistance();

    /**
     * Set the field distance. 
     * @param distance distance of the next entity
     */
    void setDistance(double distance);

}