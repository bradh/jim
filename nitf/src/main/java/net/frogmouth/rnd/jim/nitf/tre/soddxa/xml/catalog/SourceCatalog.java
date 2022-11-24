package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.DateWithOptionalUTCTime;

/**
 * Source catalogue.
 *
 * <p>The name of the space object catalogue used to populate many elements within the SODDXA TRE.
 *
 * <p>This class is immutable.
 */
public class SourceCatalog {

    @JacksonXmlProperty(isAttribute = true)
    private DateWithOptionalUTCTime catalogDate;

    @JacksonXmlProperty(isAttribute = true)
    private String catalogVersion;

    @JacksonXmlText private SourceCatalogName catalogName;

    /**
     * Constructor.
     *
     * <p>This is only for the deserialiser. Use a version that takes date and name values, with
     * optional version.
     */
    private SourceCatalog() {}

    /**
     * Constructor.
     *
     * @param catalogName the catalogue as an enumerated value.
     * @param catalogDate the catalogue publish / update date.
     * @param catalogVersion the catalogue version
     */
    public SourceCatalog(
            SourceCatalogName catalogName,
            DateWithOptionalUTCTime catalogDate,
            String catalogVersion) {
        this.catalogDate = catalogDate;
        this.catalogVersion = catalogVersion;
        this.catalogName = catalogName;
    }

    /**
     * Constructor.
     *
     * <p>This will set the catalogue version to null, indicating the publisher does not assign
     * version numbers.
     *
     * @param catalogName the catalogue as an enumerated value.
     * @param catalogDate the catalogue publish / update date.
     */
    public SourceCatalog(SourceCatalogName catalogName, DateWithOptionalUTCTime catalogDate) {
        this.catalogDate = catalogDate;
        this.catalogVersion = null;
        this.catalogName = catalogName;
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
    public DateWithOptionalUTCTime getCatalogDate() {
        return catalogDate;
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

    /**
     * The catalogue name.
     *
     * @return the catalogue name as an enumerated value
     */
    public SourceCatalogName getCatalogName() {
        return catalogName;
    }
}
