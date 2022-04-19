package view;

import input.InputObserver;
import input.Space;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.GameState;
import model.Model;
import model.Statistics;
import view.entity.EntityView;
import view.entity.EntityViewImpl;
import view.marker.MarkerView;
import view.marker.MarkerViewImpl;
import view.mission.MissionView;
import view.mission.MissionViewImpl;

/**
 * 
 * Implementation of {@link GameView}.
 *
 */
public class GameViewImpl implements GameView {
    private static final double GAME_SCREEN_WIDTH = 854.0;
    private static final double GAME_SCREEN_HEIGHT = 445.0;
    private final View view;
    private final Stage stage;
    private final Pane pane;
    private final PlayerView playerView;
    private final EntityView entityView;
    private final StatisticsView statView;
    private final GameState gameState;
    private final Statistics statistics;
    private final MarkerView markerView;
    private final MissionView missionView;
    private final InputObserver obs;

    /**
     * Creates a new GameViewImpl.
     * @param view the {@link View}.
     * @param stage the {@link Stage}.
     * @param pane the {@link Pane}.
     * @param obs the {@link InputObserver}.
     * @param model the {@link Model}.
     */
    public GameViewImpl(final View view, final Stage stage, final Pane pane, final InputObserver obs, final Model model) {
        super();
        this.view = view;
        this.stage = stage;
        this.pane = pane;
        final Image backImage = new Image("GameScreen.png", GAME_SCREEN_WIDTH, GAME_SCREEN_HEIGHT, true, true);
        final BackgroundImage background = new BackgroundImage(backImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.pane.setBackground(new Background(background));
        this.obs = obs;
        this.gameState = model.getGameState();
        this.statistics = model.getStatistics();
        this.playerView = new PlayerViewImpl(pane, this.gameState.getPlayer());
        this.entityView = new EntityViewImpl(pane, this.gameState.getEntities());
        this.statView = new StatisticsViewImpl(pane, this.statistics, this.gameState.getPlayer());
        this.markerView = new MarkerViewImpl(pane, model.getMarkerManager());
        this.missionView = new MissionViewImpl(pane, model.getMissionManager());

        this.pane.getScene().setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.SPACE)) {
                this.obs.notify(new Space(this.gameState));
            }
        });
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void render() {
        this.pane.getChildren().clear();
        this.markerView.render();
        this.playerView.render();
        this.entityView.render();
        this.missionView.render();
        this.statView.render();
    }

}
