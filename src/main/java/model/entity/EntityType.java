package model.entity;

/**
 * 
 * Enumeration defining different types of entities.
 *
 */
public enum EntityType {

    /**
     * {@link Obstacle}'s type.
     */
    OBSTACLE(4.7), 

    /**
     * {@link Platform}'s type.
     */
    PLATFORM(0.0), 

    /**
     * {@link Coin}'s type.
     */
    COIN(5.3), 

    /**
     * Powerup's type. 
     */
    POWERUP(5.0); 

    private final double distanceFactor;

    /**
     * 
     * @param distanceFactor the distance of an entity from the last in the {@link DynamicEntity} list. 
     */
    EntityType(final double distanceFactor) {
        this.distanceFactor = distanceFactor;
    }

    /**
     * Return the distance property of an entity.
     * @return the distance factor of an entity.
     */
    public double getDistanceFactor() {
        return this.distanceFactor;
    }

}
