
package net.frogmouth.rnd.jim.map;

public class TileCalcUtils {
    private TileCalcUtils() {}
    
    public static TileNumber locationToTileNumber(Location location, Zoom zoom) {
        return new TileNumber(locationToTilePosition(location, zoom));
    }
    
    public static TilePosition locationToTilePosition(Location location, Zoom zoom) {
        int n = zoom.getExtent();
        double x = n * (location.longitude() + 180.0) / 360.0;
        double latRadians = Math.toRadians(location.latitude());
        double y = n * (1 - (Math.log(Math.tan(latRadians) + secant(latRadians)) / Math.PI)) / 2;
        return new TilePosition(zoom, x, y);
    }

    private static double secant(double angleInRadians) {
        return 1.0 / Math.cos(angleInRadians);
    }   
}