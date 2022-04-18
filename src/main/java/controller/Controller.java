package controller;

import model.Model;

/**
 * 
 * The controller of the application.
 *
 */
public interface Controller {

    /**
     * Prepares the game to start.
     * 
     */
    void setup();

    /**
     * Process the input.
     * 
     */
    void processInput();

    /**
     * Updates the {@link Model}.
     * 
     */
    void update();

    /**
     * Renders the {@link View}.
     * 
     */
    void render();

    /**
     * Start the game loop.
     * 
     */
    void start();

    /**
     * Stops the game loop.
     * 
     */
    void stop();

    /**
     * Gets the {@link Model}.
     * @return the {@link Model}.
     */
    Model getModel();
}
