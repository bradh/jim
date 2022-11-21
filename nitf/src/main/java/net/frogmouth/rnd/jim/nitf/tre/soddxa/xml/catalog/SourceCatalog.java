package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Source catalogue.
 *
 * <p>The name of the space object catalogue used to populate many elements within the SODDXA TRE.
 */
public class SourceCatalog {

    @JacksonXmlProperty(isAttribute = true)
    // TODO: DateWithOptionalUTCTime instead
    private String catalogDate;

    @JacksonXmlProperty(isAttribute = true)
    private String catalogVersion;

    @JacksonXmlText private SourceCatalogName catalogName;

    /** Constructor. */
    public SourceCatalog() {}

    /**
     * Copy constructor.
     *
     * @param other the source object to copy values for.
     */
    public SourceCatalog(SourceCatalog other) {
        this.catalogDate = other.catalogDate;
        this.catalogVersion = other.catalogVersion;
        this.catalogName = other.catalogName;
    }

    /**
     * Catalogue date.
     *
     * <p>The UTC date and time or just UTC date (only when time is not available to the data
     * provider) the most current space object catalogue was published as a whole or significantly
     * updated. This attribute shall not reflect the date at which individual entries were updated.
     *
     * @return the catalogue date.
     */
    public String getCatalogDate() {
        return catalogDate;
    }

    public void setCatalogDate(String catalogDate) {
        this.catalogDate = catalogDate;
    }

    /**
     * Catalogue version.
     *
     * <p>The version of the space object catalogue to which many elements within this
     * spaceObjectDescriptionData element are compliant, as specified by the catalogue's publisher.
     * This attribute is not populated if the catalogue's publisher does not assign version numbers
     * to the catalogue.
     *
     * @return the catalogue version.
     */
    public String getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(String catalogVersion) {
        this.catalogVersion = catalogVersion;
    }

    /**
     * The catalogue name.
     *
     * @return the catalogue name as an enumerated value
     */
    public SourceCatalogName getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(SourceCatalogName catalogName) {
        this.catalogName = catalogName;
    }
}
