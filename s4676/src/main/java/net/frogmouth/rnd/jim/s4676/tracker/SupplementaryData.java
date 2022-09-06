package net.frogmouth.rnd.jim.s4676.tracker;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Supplementary Data.
 *
 * <p>Supplementary tracker information data. For example, if the tracker utilized a digital
 * elevation model (DEM), this item specifies which version of the DEM was used. The version is
 * recorded in case a future update to the supplementary data set requires reassessing the tracks.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"name", "version", "description"})
public class SupplementaryData {
    @JacksonXmlProperty(isAttribute = true)
    private ISupplementaryDataType type;

    /** The name of the sensor. */
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String name;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String version;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String description;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes a name and version.
     */
    private SupplementaryData() {}

    /**
     * Constructor.
     *
     * <p>There are three mandatory elements to the Supplementary information - the type, a name,
     * and a version.
     *
     * <p>The type is the type of supplementary data source (e.g. GIS Road Network).
     *
     * <p>The name is the name (or other identifying information) about the supplementary data.
     *
     * <p>The version number of the supplementary data source.
     *
     * @param type the type
     * @param name the name
     * @param version the version
     */
    public SupplementaryData(ISupplementaryDataType type, String name, String version) {
        this.type = type;
        this.name = name;
        this.version = version;
    }

    /**
     * The supplementary data type.
     *
     * <p>The type is the type of supplementary data source (e.g. GIS Road Network).
     *
     * @return the type
     */
    public ISupplementaryDataType getType() {
        return type;
    }

    /**
     * Set the supplementary data type.
     *
     * <p>The type is the type of supplementary data source (e.g. GIS Road Network).
     *
     * @param type the type
     */
    public void setType(ISupplementaryDataType type) {
        this.type = type;
    }

    /**
     * Name.
     *
     * <p>The name is the name (or other identifying information) about the supplementary data.
     *
     * @return the name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * <p>The name is the name (or other identifying information) about the supplementary data.
     *
     * @param name the name as a string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Version.
     *
     * <p>The version number of the supplementary data source.
     *
     * @return version as a string.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the version.
     *
     * <p>The version number of the supplementary data source.
     *
     * @param version the version as a string.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Description.
     *
     * <p>An optional description of the supplementary data.
     *
     * @return the description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * <p>An optional description of the supplementary data.
     *
     * @param description the description as a string.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
