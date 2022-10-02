package net.frogmouth.rnd.jim.map;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 * Base map rendering for XYZ tiled maps.
 *
 * <p>
 * This is not yet very generalised.
 */
public class BaseMap extends Region {

    private final TileCache tileCache = new TileCache();
    private Zoom zoomLevel = new Zoom(5);
    private Location centreLocation = new Location(-35.3, 143.2);
    private static final int MAX_ZOOM = 20;
    private double dragOriginX;
    private double dragOriginY;
    private Group group;
    
    public BaseMap() {
        group = new Group();
        this.getChildren().add(group);
        updateTiles();
        registerListeners();
    }
    
    private void updateTiles() {
        TilePosition tilePosition = TileCalcUtils.locationToTilePosition(centreLocation, zoomLevel);
        TileNumber centreTileNumber = new TileNumber(tilePosition);
        
        double sceneWidth = getWidth();
        int numTilesX = (int) Math.ceil(2 + (sceneWidth / 256.0));
        double sceneHeight = getHeight();
        int numTilesY = (int) Math.ceil(2 + sceneHeight / 256.0);
        for (int x = centreTileNumber.x() - numTilesX / 2; x <= centreTileNumber.x() + numTilesX / 2; x++) {
            if (x < 0) {
                continue;
            }
            if (x >= centreTileNumber.zoom().getExtent()) {
                // TODO: handle wrap around.
                continue;
            }
            for (int y = centreTileNumber.y() - numTilesY / 2; y <= centreTileNumber.y() + numTilesY / 2; y++) {
                if (y < 0) {
                    continue;
                }
                if (y > centreTileNumber.zoom().getExtent()) {
                    continue;
                }
                TileNumber tileNumber = new TileNumber(centreTileNumber.zoom(), x, y);
                CompletableFuture<Image> completableFuture = tileCache.getImage(tileNumber);
                Consumer<Image> responseHandler = (Image image) -> {
                    double mapGroupCentreX = sceneWidth / 2;
                    double mapGroupCentreY = sceneHeight / 2;
                    double xOffsetToTileCentre = (tilePosition.x() % 1.0) * image.getWidth();
                    double yOffsetToTileCentre = (tilePosition.y() % 1.0) * image.getHeight();
                    int tilePositionXOffset = centreTileNumber.x() - tileNumber.x();
                    int tilePositionYOffset = centreTileNumber.y() - tileNumber.y();
                    double centreTileLeft = mapGroupCentreX - xOffsetToTileCentre;
                    double centreTileTop = mapGroupCentreY - yOffsetToTileCentre;
                    ImageView imageView = new ImageView(image);
                    imageView.setX(centreTileLeft - tilePositionXOffset * image.getWidth());
                    imageView.setY(centreTileTop - tilePositionYOffset * image.getHeight());
                    Platform.runLater(() -> {
                        group.getChildren().add(imageView);
                    });
                    
                };
                completableFuture.thenAcceptAsync(responseHandler);
            }
        }
    }
    
    private void registerListeners() {
        layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            final Rectangle outputClip = new Rectangle();
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
            this.setClip(outputClip);
        });
        // TODO: pinch zoom?
        setOnScroll((ScrollEvent event) -> {
            if (event.getDeltaY() > 0) {
                if (zoomLevel.level() < MAX_ZOOM) {
                    zoomLevel = new Zoom(zoomLevel.level() + 1);
                }
                updateTiles();
            } else if (event.getDeltaY() < 0) {
                zoomLevel = new Zoom(zoomLevel.level() - 1);
                updateTiles();
            }
        });
        setOnMousePressed((MouseEvent event) -> {
            dragOriginX = event.getX();
            dragOriginY = event.getY();
        });
        setOnMouseDragged((MouseEvent event) -> {
            // TODO: this is not very responsive - should be smoother / less laggy.
            int n = zoomLevel.getExtent();
            double xdrag = event.getX() - dragOriginX;
            dragOriginX = event.getX();
            double ydrag = event.getY() - dragOriginY;
            dragOriginY = event.getY();
            double xTilesDrag = xdrag / 256.0;
            double yTilesDrag = ydrag / 256.0;
            double lonDegDrag = xTilesDrag / n * 360.0;
            double m = (2.0 * Math.PI * yTilesDrag) / n;
            double latDegDrag = Math.toDegrees(Math.atan(Math.sinh(m)));
            Location newCentreLocation = new Location(centreLocation.latitude() + latDegDrag, centreLocation.longitude() - lonDegDrag);
            centreLocation = newCentreLocation;
            updateTiles();
        });        
    }
    
    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        updateTiles();
    }
    
}
