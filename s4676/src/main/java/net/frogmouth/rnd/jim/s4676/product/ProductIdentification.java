package net.frogmouth.rnd.jim.s4676.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import net.frogmouth.rnd.jim.s4676.IdentifiedElement;

/**
 * Product Identification.
 *
 * <p>The ProductIdentification class specifies the ID and type of a data product in which this
 * NITSRoot object is contained. It allows that product to be uniquely identified using a
 * program-specific ID format, and allows for the data consumer to link this object back to program
 * specific data format and profile documentation related to this object.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"uid", "lid", "id", "name", "shortName", "effectivity"})
public class ProductIdentification extends IdentifiedElement {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String id;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String name;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String shortName;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String effectivity;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes an id and name.
     */
    private ProductIdentification() {}

    /**
     * Constructor.
     *
     * <p>There are two mandatory elements to the Product Identification - an identifier, and a
     * name.
     *
     * <p>The identifier element is a free-form string allowing the data provider to specify the
     * designation (ID) of this STANAG 4676 based product per that system's ID syntax.
     *
     * <p>The name element is the name of the data product as defined in the governing product
     * specification; For example, if System X defines a Tracking Product based on STANAG 4676, but
     * profiling some features down (e.g., the source of tracks is only ever motion imagery, and the
     * types of events identified are limited), and in that document names the product "System X
     * Motion Imagery Track Product", this field would be set to that name.
     *
     * @param id the identifier of the product
     * @param name the name of the product
     */
    public ProductIdentification(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Identifier.
     *
     * <p>A free-form string allowing the data provider to specify the designation (ID) of this
     * STANAG 4676 based product per that system's ID syntax
     *
     * @return the product identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Set the Identifier.
     *
     * <p>A free-form string allowing the data provider to specify the designation (ID) of this
     * STANAG 4676 based product per that system's ID syntax
     *
     * @param id the product identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Product name.
     *
     * <p>The name of the data product as defined in the governing product specification; For
     * example, if System X defines a Tracking Product based on STANAG 4676, but profiling some
     * features down (e.g., the source of tracks is only ever motion imagery, and the types of
     * events identified are limited), and in that document names the product "System X Motion
     * Imagery Track Product", this field would be set to that name.
     *
     * @return the product name as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the product name.
     *
     * <p>The name of the data product as defined in the governing product specification; For
     * example, if System X defines a Tracking Product based on STANAG 4676, but profiling some
     * features down (e.g., the source of tracks is only ever motion imagery, and the types of
     * events identified are limited), and in that document names the product "System X Motion
     * Imagery Track Product", this field would be set to that name.
     *
     * @param name the product name as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Product short name.
     *
     * <p>The short name of the product as defined in the program specification. For example, if
     * System X defines a Tracking Product based on STANAG 4676, but profiling some features down
     * (e.g., the source of tracks is only ever motion imagery, and the types of events identified
     * are limited), and in that document names the product "System X Motion Imagery Track Product",
     * the short name might be set to "XMTP".
     *
     * @return the short name of the product as a String.
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Set the product short name.
     *
     * <p>The short name of the product as defined in the program specification. For example, if
     * System X defines a Tracking Product based on STANAG 4676, but profiling some features down
     * (e.g., the source of tracks is only ever motion imagery, and the types of events identified
     * are limited), and in that document names the product "System X Motion Imagery Track Product",
     * the short name might be set to "XMTP".
     *
     * @param shortName the short name of the product as a String.
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * Product specification version effectivity.
     *
     * <p>The named effectivity of the product or system specification against which this version of
     * the product is compliant.
     *
     * @return the product specification version effectivity
     */
    public String getEffectivity() {
        return effectivity;
    }

    /**
     * Set the product specification version effectivity.
     *
     * <p>The named effectivity of the product or system specification against which this version of
     * the product is compliant.
     *
     * @param effectivity the product specification version effectivity
     */
    public void setEffectivity(String effectivity) {
        this.effectivity = effectivity;
    }
}
