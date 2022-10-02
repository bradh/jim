
package net.frogmouth.rnd.jim.map;

public record Zoom(int level) {

    /**
     * Get the extent of tiles at this zoom level.
     * 
     * The number of tiles is square for EPSG-3857. This is the value in each direction. 
     * @return the extent of this zoom level.
     */
    public int getExtent() {
        return 1 << level;
    }

}