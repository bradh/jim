package net.frogmouth.rnd.jim.map;

public record TileNumber(
    Zoom zoom,
    int x,
    int y) {

    public TileNumber(TilePosition tilePosition) {
        this(tilePosition.zoom(), (int)tilePosition.x(), (int)tilePosition.y());
    }

    int getZoomLevel() {
        return zoom.level();
    }
};