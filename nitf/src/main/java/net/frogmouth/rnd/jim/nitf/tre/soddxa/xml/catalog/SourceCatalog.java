package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class SourceCatalog {

    @JacksonXmlProperty(isAttribute = true)
    // TODO: DateWithOptionalUTCTime instead
    private String catalogDate;

    @JacksonXmlProperty(isAttribute = true)
    private String catalogVersion;

    @JacksonXmlText private SourceCatalogName catalogName;

    public SourceCatalog() {}

    public SourceCatalog(SourceCatalog other) {
        this.catalogDate = other.catalogDate;
        this.catalogVersion = other.catalogVersion;
        this.catalogName = other.catalogName;
    }

    public String getCatalogDate() {
        return catalogDate;
    }

    public void setCatalogDate(String catalogDate) {
        this.catalogDate = catalogDate;
    }

    public String getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(String catalogVersion) {
        this.catalogVersion = catalogVersion;
    }

    public SourceCatalogName getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(SourceCatalogName catalogName) {
        this.catalogName = catalogName;
    }
}
