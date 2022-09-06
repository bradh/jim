package net.frogmouth.rnd.jim.s4676.tracker;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Supplementary data type.
 *
 * <p>The type of supplementary data source.
 */
public enum SupplementaryDataType implements ISupplementaryDataType {
    /**
     * GIS Road Network.
     *
     * <p>Technique/product combining geographic information system (GIS) data and known existing
     * road networks. May be used to improve predictive tracking models based on future positions
     * anticipated with known movement patterns based on available routes.
     */
    GIS_ROAD_NETWORK,
    /**
     * Digital Elevation Model (DEM).
     *
     * <p>Dataset representing the topography of an area, usually in the form of an electronic map.
     * A DEM includes ground cover, man- made structures, and vegetation.
     */
    DIGITAL_ELEVATION_MODEL,
    /**
     * Shipping Lane.
     *
     * <p>Regularly-used route for vessels on oceans and large lakes. May be used in predictive
     * analysis of movement behavior of tracked objects.
     */
    SHIPPING_LANE,
    /**
     * Air Corridor.
     *
     * <p>Designated region of airspace that an aircraft must remain in during its transit through a
     * given region. Air corridors are typically imposed by military or diplomatic requirements.
     */
    AIR_CORRIDOR,
    /**
     * Digital Terrain Model (DTM).
     *
     * <p>Three-dimensional model of digital elevation model (DEM) for cartographic representation.
     * Terrain models are often displayed as grids, superimposed over topography maps to illustrate
     * peaks and valleys.
     */
    DIGITAL_TERRAIN_MODEL,
    /**
     * Digital Surface Model (DSM).
     *
     * <p>MSL elevations of the reflective surfaces of trees, buildings, and other features elevated
     * above the earth’s bare surface. May be used to check how a proposed building would affect the
     * viewshed of residents and businesses, and by extension, tracked objects in the area.
     */
    DIGITAL_SURFACE_MODEL,
    /**
     * Edge Detection Scene.
     *
     * <p>Image manipulation product which may be used by the tracker to employ varying tracker
     * models based on a region-based classification of scene (e.g. rural vs. suburban
     * environments). May also be used to improve tracker performance by ignoring specific regions
     * where the tracker is known to underperform.
     */
    EDGE_DETECTION_SCENE,
    /**
     * Illumination / Shadow Map.
     *
     * <p>Map illustrating variations in illumination that may affect the status of a track based on
     * sensor coverage. For instance, a dropped track on open space may be terminated, whereas a
     * dropped track entering a shadowed region may be continued under the assumption that it will
     * appear when it leaves the shadowed region.
     */
    @JsonProperty("ILLUMINATION/SHADOW_MAP")
    ILLUMINATION_SHADOW_MAP,
    /**
     * Foundational Feature Data.
     *
     * <p>Vector-based digital product that provides a selected minimum set of geographic
     * information features.
     */
    FOUNDATION_FEATURE_DATA,
    /**
     * Automatic Scene Segmentation.
     *
     * <p>Image manipulation which may be used by the tracker to employ varying tracker models based
     * on a region-based classification of scene (e.g. rural vs. suburban environments). May also be
     * used to improve tracker performance by ignoring specific regions where the tracker is known
     * to underperform.
     */
    AUTOMATIC_SCENE_SEGMENTATION
}
