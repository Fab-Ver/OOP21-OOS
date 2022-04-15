package model.entity.powerup;

import java.awt.geom.Point2D.Double;
import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.scene.image.Image;
import model.Model;
import model.entity.DynamicEntity;
import model.entity.AbstractDynamicEntity;
import model.entity.SpawnLevel;
import model.entity.EntityType;

public class Spraybomb extends AbstractDynamicEntity {

    public Spraybomb(final Double coordinates, final Image image, final SpawnLevel level, final EntityType type) {
        super(coordinates, image, level, type);
    }

    @Override
    public void activateEffect(final Model model) {
        final List<DynamicEntity> temp = model.getGameState().getEntities(); 
        final List<DynamicEntity> remove = temp.stream()
                .limit(temp.size() - 1).collect(Collectors.toList()); 
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                temp.removeAll(remove); 
            }
        });
    }

}
