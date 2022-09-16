package net.frogmouth.rnd.jim.s4676.message.trackdata;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Object class.
 *
 * <p>ObjectClass specifies the time-invariant information about the type of object (e.g., an
 * Automobile or an Open-bed truck) using the categorization of objects specified by APP-6.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "table",
    "entity",
    "entityType",
    "entitySubtype",
    "sector1Modifier",
    "sector2Modifier",
    "code"
})
public class ObjectClass {
    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private APP6Table table;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String entity;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String entityType;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String entitySubtype;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String sector1Modifier;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String sector2Modifier;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    private String code;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that takes the table and code arguments.
     */
    private ObjectClass() {}

    /**
     * Constructor.
     *
     * <p>The table is an enumeration equivalent to the numerical code referring to one or more of
     * the 14 different tables in APP-6 that list NATO-standardized encodings for a variety of
     * objects, activities, and locations. This attribute specifies a code for the categorization.
     *
     * <p>The code is a 6, 8, or 10-digit code that uniquely describes the entity (first 2 digits),
     * entity type (second 2 digits), and entity subtype (third set of 2 digits), and describes the
     * optional sector 1 modifier (fourth set of 2 digits), and optional sector 2 modifier (fifth
     * set of 2 digits). The code should be specified as a string of six, eight, or ten digits,
     * including leading zeroes.
     *
     * @param table the APP-6 table.
     * @param code the code
     */
    public ObjectClass(APP6Table table, String code) {
        this.table = table;
        this.code = code;
    }

    /**
     * Table.
     *
     * <p>Numerical code referring to one or more of the 14 different tables in APP-6 that list
     * NATO-standardized encodings for a variety of objects, activities, and locations. This
     * attribute specifies a code for the categorization.
     *
     * @return the table as an enumerated value
     */
    public APP6Table getTable() {
        return table;
    }

    /**
     * Set the table.
     *
     * <p>Numerical code referring to one or more of the 14 different tables in APP-6 that list
     * NATO-standardized encodings for a variety of objects, activities, and locations. This
     * attribute specifies a code for the categorization.
     *
     * @param table the table as an enumerated value
     */
    public void setTable(APP6Table table) {
        this.table = table;
    }

    /**
     * Entity.
     *
     * <p>The entity string from APP-6 that describes the tracked object.
     *
     * @return the entity.
     */
    public String getEntity() {
        return entity;
    }

    /**
     * Set the entity.
     *
     * <p>The entity string from APP-6 that describes the tracked object.
     *
     * @param entity the entity.
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     * Entity type.
     *
     * <p>The entity type string from APP-6 that describes the tracked object. Required if the
     * tracked object has a listed entity type.
     *
     * @return the entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the entity type.
     *
     * <p>The entity type string from APP-6 that describes the tracked object. Required if the
     * tracked object has a listed entity type.
     *
     * @param entityType the entity type
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Entity sub-type.
     *
     * <p>The entity subtype string from APP-6 that describes the tracked object. Required if the
     * tracked object has a listed entity subtype.
     *
     * @return the entity subtype.
     */
    public String getEntitySubtype() {
        return entitySubtype;
    }

    /**
     * Set the entity sub-type.
     *
     * <p>The entity subtype string from APP-6 that describes the tracked object. Required if the
     * tracked object has a listed entity subtype.
     *
     * @param entitySubtype the entity subtype.
     */
    public void setEntitySubtype(String entitySubtype) {
        this.entitySubtype = entitySubtype;
    }

    /**
     * Sector 1 modifier.
     *
     * <p>The sector 1 modifier string from APP-6 that provides additional information about the
     * tracked object. Sector 1 modifier is optional.
     *
     * @return the sector 1 modifier.
     */
    public String getSector1Modifier() {
        return sector1Modifier;
    }

    /**
     * Set the sector 1 modifier.
     *
     * <p>The sector 1 modifier string from APP-6 that provides additional information about the
     * tracked object. Sector 1 modifier is optional.
     *
     * @param sector1Modifier the sector 1 modifier.
     */
    public void setSector1Modifier(String sector1Modifier) {
        this.sector1Modifier = sector1Modifier;
    }

    /**
     * Sector 2 modifier.
     *
     * <p>The sector 2 modifier string from APP-6 that provides additional information about the
     * tracked object. Sector 2 modifier is optional.
     *
     * @return the sector 2 modifier.
     */
    public String getSector2Modifier() {
        return sector2Modifier;
    }

    /**
     * Set the sector 2 modifier.
     *
     * <p>The sector 2 modifier string from APP-6 that provides additional information about the
     * tracked object. Sector 2 modifier is optional.
     *
     * @param sector2Modifier the sector 2 modifier.
     */
    public void setSector2Modifier(String sector2Modifier) {
        this.sector2Modifier = sector2Modifier;
    }

    /**
     * Code.
     *
     * <p>The 6, 8, or 10-digit code that uniquely describes the entity (first 2 digits), entity
     * type (second 2 digits), and entity subtype (third set of 2 digits), and describes the
     * optional sector 1 modifier (fourth set of 2 digits), and optional sector 2 modifier (fifth
     * set of 2 digits). The code should be specified as a string of six, eight, or ten digits,
     * including leading zeroes.
     *
     * @return the APP-6 code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the code.
     *
     * <p>The 6, 8, or 10-digit code that uniquely describes the entity (first 2 digits), entity
     * type (second 2 digits), and entity subtype (third set of 2 digits), and describes the
     * optional sector 1 modifier (fourth set of 2 digits), and optional sector 2 modifier (fifth
     * set of 2 digits). The code should be specified as a string of six, eight, or ten digits,
     * including leading zeroes.
     *
     * @param code the APP-6 code.
     */
    public void setCode(String code) {
        this.code = code;
    }
}
