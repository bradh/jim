package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog.SourceCatalog;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection.CollectionData;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.nonsatellite.NonSatelliteInformation;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit.OrbitData;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.SatelliteInformation;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security.SecurityData;
import net.frogmouth.rnd.jim.nitf.validation.ValidationResult;
import net.frogmouth.rnd.jim.nitf.validation.ValidationResults;
import net.frogmouth.rnd.jim.nitf.validation.Validity;

/**
 * Space object description data.
 *
 * <p>Valid XML container root element holding all the subsequent elements within the SODDXA TRE.
 */
@JacksonXmlRootElement(
        namespace = "urn:us:mil:nga:ntb:soddxa",
        localName = "spaceObjectDescriptionData")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "securityData",
    "sourceCatalog",
    "absVisualMagnitude",
    "radarCrossSection",
    "length",
    "width",
    "height",
    "diameter",
    "mass",
    "soUid",
    "soType",
    "nonSatelliteInformation",
    "satelliteInformation",
    "collectionData",
    "orbitData"
})
public class SpaceObjectDescriptionData {

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SecurityData securityData = new SecurityData();

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SourceCatalog sourceCatalog;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa", localName = "absVisualMagnitude")
    private Double absoluteVisualMagnitude;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double radarCrossSection;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double length;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double width;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double height;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double diameter;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private Double mass;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private UUID soUid;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SpaceObjectType soType;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private NonSatelliteInformation nonSatelliteInformation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private SatelliteInformation satelliteInformation;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private CollectionData collectionData;

    @JacksonXmlProperty(namespace = "urn:us:mil:nga:ntb:soddxa")
    private OrbitData orbitData;

    /**
     * Constructor.
     *
     * <p>This is only for the deserialisation support. Use a version that takes the space object
     * type.
     */
    private SpaceObjectDescriptionData() {}

    /**
     * Constructor.
     *
     * <p>In addition to the arguments in this constructor, exactly one of {@link
     * SatelliteInformation} or {@link NonSatelliteInformation} is required.
     *
     * @param soUid the unique identifier.
     * @param soType the space object type
     * @param catalog the source catalogue
     * @param collectionData definition of the collection associated with this TRE.
     */
    public SpaceObjectDescriptionData(
            UUID soUid,
            SpaceObjectType soType,
            SourceCatalog catalog,
            CollectionData collectionData) {
        this.sourceCatalog = catalog;
        this.soUid = soUid;
        this.soType = soType;
        this.collectionData = new CollectionData(collectionData);
    }

    /**
     * Constructor.
     *
     * <p>This will initialise the object with a random UUID for the {@code soUid}.
     *
     * <p>In addition to the arguments in this constructor, exactly one of {@link
     * SatelliteInformation} or {@link NonSatelliteInformation} is required.
     *
     * @param soType the space object type
     * @param catalog the source catalogue
     * @param collectionData definition of the collection associated with this TRE.
     */
    public SpaceObjectDescriptionData(
            SpaceObjectType soType, SourceCatalog catalog, CollectionData collectionData) {
        this(UUID.randomUUID(), soType, catalog, collectionData);
    }

    /**
     * Constructor.
     *
     * <p>This version is suitable for satellite information.
     *
     * <p>This will initialise the object with a random UUID for the {@code soUid}.
     *
     * @param satelliteInformation the satellite information, not null
     * @param catalog the source catalog, not null
     * @param collectionData definition of the collection associated with this TRE, not null.
     */
    public SpaceObjectDescriptionData(
            SatelliteInformation satelliteInformation,
            SourceCatalog catalog,
            CollectionData collectionData) {
        this(UUID.randomUUID(), SpaceObjectType.SATELLITE, catalog, collectionData);
        this.satelliteInformation = new SatelliteInformation(satelliteInformation);
    }

    /**
     * Security data.
     *
     * <p>An element containing all security marking metadata necessary to describe the contents of
     * the SODDXA TRE itself, when that data contained directly within SODDXA is restricted or
     * classified higher than UNCLASSIFIED. Information about the space object not directly included
     * within SODDXA is not considered when specifying the security marking metadata.
     *
     * <p>This field is required, but can be empty for unclassified TRE content.
     *
     * @return the security data.
     */
    public SecurityData getSecurityData() {
        if (securityData == null) {
            return new SecurityData();
        } else {
            return new SecurityData(securityData);
        }
    }

    /**
     * Set the security data.
     *
     * <p>An element containing all security marking metadata necessary to describe the contents of
     * the SODDXA TRE itself, when that data contained directly within SODDXA is restricted or
     * classified higher than UNCLASSIFIED. Information about the space object not directly included
     * within SODDXA is not considered when specifying the security marking metadata.
     *
     * <p>This field is required, but can be empty for unclassified TRE content.
     *
     * @param security the security data.
     */
    public void setSecurityData(SecurityData security) {
        if (security == null) {
            this.securityData = new SecurityData();
        } else {
            this.securityData = new SecurityData(security);
        }
    }

    /**
     * Source catalogue.
     *
     * <p>Information about the the space object catalogue used to populate many elements within the
     * SODDXA TRE.
     *
     * <p>This field is required.
     *
     * @return the source catalogue.
     */
    public SourceCatalog getSourceCatalog() {
        return sourceCatalog;
    }

    /**
     * Set the source catalogue.
     *
     * <p>Information about the the space object catalogue used to populate many elements within the
     * SODDXA TRE.
     *
     * <p>This field is required.
     *
     * @param sourceCatalog the source catalogue.
     */
    public void setSourceCatalog(SourceCatalog sourceCatalog) {
        this.sourceCatalog = sourceCatalog;
    }

    /**
     * Absolute visual magnitude (Mv).
     *
     * <p>Absolute visual magnitude is a unitless measure based on an unbounded logarithmic scale
     * factored by distance (10 parsecs, or 32.6 light years) and luminosity, of the measured space
     * object's radiance to a calibrated reference's (e.g., Vega) radiance. Negative values on the
     * graduated scale represent more intense brightness than less intense positive values, where
     * the visual magnitude of Vega = 0.
     *
     * <p>This field is optional.
     *
     * @return the absolute visual magnitude, or null if not specified.
     */
    public Double getAbsoluteVisualMagnitude() {
        return absoluteVisualMagnitude;
    }

    /**
     * Set the absolute visual magnitude.
     *
     * <p>Absolute visual magnitude is a unitless measure based on an unbounded logarithmic scale
     * factored by distance (10 parsecs, or 32.6 light years) and luminosity, of the measured space
     * object's radiance to a calibrated reference's (e.g., Vega) radiance. Negative values on the
     * graduated scale represent more intense brightness than less intense positive values, where
     * the visual magnitude of Vega = 0.
     *
     * <p>This field is optional.
     *
     * @param absoluteVisualMagnitude the absolute visual magnitude.
     */
    public void setAbsoluteVisualMagnitude(Double absoluteVisualMagnitude) {
        this.absoluteVisualMagnitude = absoluteVisualMagnitude;
    }

    /**
     * Radar cross section (RCS).
     *
     * <p>A measure (m<sup>2</sup>) of the radar reflectivity of a space object, defined as the
     * hypothetical area normal to the radar beam which intercepts an amount of power which, if
     * scattered isotropically, would result in the same power density at the radar receiver.
     *
     * <p>This field is optional
     *
     * @return the radar cross section, or null if not specified.
     */
    public Double getRadarCrossSection() {
        return radarCrossSection;
    }

    /**
     * Set the radar cross section (RCS).
     *
     * <p>A measure (m<sup>2</sup>) of the radar reflectivity of a space object, defined as the
     * hypothetical area normal to the radar beam which intercepts an amount of power which, if
     * scattered isotropically, would result in the same power density at the radar receiver.
     *
     * <p>This field is optional
     *
     * @param radarCrossSection the radar cross section.
     */
    public void setRadarCrossSection(Double radarCrossSection) {
        this.radarCrossSection = radarCrossSection;
    }

    /**
     * Space object length.
     *
     * <p>The measure of the maximum extent in metres of a space object from end to end; the greater
     * of two or the greatest of three-dimensions of a body.
     *
     * <p>This field is optional.
     *
     * @return the length in metres, or null if not specified.
     */
    public Double getLength() {
        return length;
    }

    /**
     * Set the space object length.
     *
     * <p>The measure of the maximum extent in metres of a space object from end to end; the greater
     * of two or the greatest of three-dimensions of a body.
     *
     * <p>This field is optional.
     *
     * @param length the length in metres.
     */
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * Space object width.
     *
     * <p>The measure of the maximum extent in metres of a space object from side to side.
     *
     * <p>This field is optional.
     *
     * @return the width in metres, or null if not specified.
     */
    public Double getWidth() {
        return width;
    }

    /**
     * Set the space object width.
     *
     * <p>The measure of the maximum extent in metres of a space object from side to side.
     *
     * <p>This field is optional.
     *
     * @param width the width in metres.
     */
    public void setWidth(Double width) {
        this.width = width;
    }

    /**
     * Space object height.
     *
     * <p>The measure of the maximum extent in metres of a space object from top to bottom.
     *
     * <p>This field is optional.
     *
     * @return the height in metres, or null if not specified.
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Set the space object height.
     *
     * <p>The measure of the maximum extent in metres of a space object from top to bottom.
     *
     * <p>This field is optional.
     *
     * @param height the height in metres, or null if not specified.
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * Space object diameter.
     *
     * <p>A measure (meters) of the maximum extent of a straight line passing from side to side
     * through the centre of a space object's hard body.
     *
     * <p>This field is optional.
     *
     * @return the diameter in metres, or null if not specified.
     */
    public Double getDiameter() {
        return diameter;
    }

    /**
     * Set the space object diameter.
     *
     * <p>A measure (meters) of the maximum extent of a straight line passing from side to side
     * through the centre of a space object's hard body.
     *
     * <p>This field is optional.
     *
     * @param diameter the diameter in metres.
     */
    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    /**
     * Space object mass.
     *
     * <p>A measure (kilograms) of the space object's mass .
     *
     * <p>This field is optional.
     *
     * @return the mass in kilograms, or null if not specified.
     */
    public Double getMass() {
        return mass;
    }

    /**
     * Set the space object mass.
     *
     * <p>A measure (kilograms) of the space object's mass .
     *
     * <p>This field is optional.
     *
     * @param mass the mass in kilograms, or null if not specified.
     */
    public void setMass(Double mass) {
        this.mass = mass;
    }

    /**
     * Unique identifier.
     *
     * <p>A UUID (specified in canonical format) identifying this instance of the SODDXA TRE (and
     * thus the space object described within) solely for the purpose of associating data in other
     * SDE with this space object. The value of this field is meaningless outside of the NITF
     * dataset in which this instance of the TRE is provided. If the dataset contains multiple
     * instances of the SODDXA TRE, then each of those instances shall have a different value for
     * this field.
     *
     * <p>This field is required.
     *
     * @return the UUID.
     */
    public UUID getSoUid() {
        return soUid;
    }

    /**
     * Set the unique identifier.
     *
     * <p>A UUID (specified in canonical format) identifying this instance of the SODDXA TRE (and
     * thus the space object described within) solely for the purpose of associating data in other
     * SDE with this space object. The value of this field is meaningless outside of the NITF
     * dataset in which this instance of the TRE is provided. If the dataset contains multiple
     * instances of the SODDXA TRE, then each of those instances shall have a different value for
     * this field.
     *
     * <p>This field is required.
     *
     * @param soUid the UUID.
     */
    public void setSoUid(UUID soUid) {
        this.soUid = soUid;
    }

    /**
     * Space object type.
     *
     * <p>The term identifying the type of space object.
     *
     * <p>This field is required.
     *
     * @return space object type as an enumerated value.
     */
    public SpaceObjectType getSoType() {
        return soType;
    }

    /**
     * Set the space object type.
     *
     * <p>The term identifying the type of space object.
     *
     * <p>This field is required.
     *
     * @param soType space object type as an enumerated value.
     */
    public void setSoType(SpaceObjectType soType) {
        this.soType = soType;
    }

    /**
     * Non-satellite information.
     *
     * <p>An element containing information about space objects that are not satellites. This
     * element is included whenever the {@code soType} element value is not "satellite".
     *
     * @return the non-satellite information, or null
     */
    public NonSatelliteInformation getNonSatelliteInformation() {
        if (nonSatelliteInformation == null) {
            return null;
        } else {
            return new NonSatelliteInformation(nonSatelliteInformation);
        }
    }

    /**
     * Set the non-satellite information.
     *
     * <p>An element containing information about space objects that are not satellites. This
     * element is included whenever the {@code soType} element value is not "satellite".
     *
     * @param information the non-satellite information, or null
     */
    public void setNonSatelliteInformation(NonSatelliteInformation information) {
        if (information == null) {
            this.nonSatelliteInformation = null;
        } else {
            this.nonSatelliteInformation = new NonSatelliteInformation(information);
        }
    }

    /**
     * Satellite information.
     *
     * <p>An element containing information about space objects that are satellites.This element is
     * included whenever the {@code soType} element value is "satellite" ({@link
     * SpaceObjectType#SATELLITE}).
     *
     * @return the satellite information, or null
     */
    public SatelliteInformation getSatelliteInformation() {
        if (satelliteInformation == null) {
            return null;
        } else {
            return new SatelliteInformation(satelliteInformation);
        }
    }

    /**
     * Set the satellite information.
     *
     * <p>An element containing information about space objects that are satellites.This element is
     * included whenever the {@code soType} element value is "satellite" ({@link
     * SpaceObjectType#SATELLITE}).
     *
     * @param information the satellite information
     */
    public void setSatelliteInformation(SatelliteInformation information) {
        if (information == null) {
            this.satelliteInformation = null;
        } else {
            this.satelliteInformation = new SatelliteInformation(information);
        }
    }

    /**
     * Collection data.
     *
     * <p>An element containing information about the collection of the image showing this space
     * object.
     *
     * <p>This field is required.
     *
     * @return the collection data
     */
    public CollectionData getCollectionData() {
        return new CollectionData(collectionData);
    }

    /**
     * Set the collection data.
     *
     * <p>An element containing information about the collection of the image showing this space
     * object.
     *
     * <p>This field is required.
     *
     * @param collectionData the collection data
     */
    public void setCollectionData(CollectionData collectionData) {
        this.collectionData = new CollectionData(collectionData);
    }

    /**
     * Orbit data.
     *
     * <p>An element containing information about the orbit of this space object.
     *
     * <p>This field is optional.
     *
     * @return the orbit data, or null if not specified
     */
    public OrbitData getOrbitData() {
        if (orbitData == null) {
            return null;
        } else {
            return new OrbitData(orbitData);
        }
    }

    /**
     * Set the orbit data.
     *
     * <p>An element containing information about the orbit of this space object.
     *
     * <p>This field is optional.
     *
     * @param orbitData the orbit data.
     */
    public void setOrbitData(OrbitData orbitData) {
        if (orbitData == null) {
            this.orbitData = null;
        } else {
            this.orbitData = new OrbitData(orbitData);
        }
    }

    public ValidationResults checkValidity() {
        ValidationResults result = new ValidationResults();
        result.addResults(validateSecurityDataPresent());
        result.addResults(validateSourceCatalog());
        result.addResults(validateRadarCrossSection());
        result.addResults(validateLength());
        result.addResults(validateWidth());
        result.addResults(validateHeight());
        result.addResults(validateDiameter());
        result.addResults(validateMass());
        result.addResults(validateUid());
        // TODO: validate soType and related data match
        // TODO: if satelliteInformation, check that is valid
        // TODO: collection data is non-null and valid
        result.addResults(validateOrbitData());
        return result;
    }

    private List<ValidationResult> validateSecurityDataPresent() {
        List<ValidationResult> results = new ArrayList<>();
        if (this.securityData == null) {
            ValidationResult result = new ValidationResult(Validity.DoesNotConform);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription("securityData is required element, even if it is empty");
            results.add(result);
        } else {
            // TODO: more checks.
        }
        return results;
    }

    private List<ValidationResult> validateSourceCatalog() {
        List<ValidationResult> results = new ArrayList<>();
        if (this.sourceCatalog == null) {
            ValidationResult result = new ValidationResult(Validity.DoesNotConform);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription("sourceCatalog is a required element");
            results.add(result);
        } else {
            results.addAll(sourceCatalog.checkValidity());
        }
        return results;
    }

    private List<ValidationResult> validateUid() {
        List<ValidationResult> results = new ArrayList<>();
        if (this.soUid == null) {
            ValidationResult result = new ValidationResult(Validity.DoesNotConform);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription("soUid is required element, even if it is empty");
            results.add(result);
        } else {
            ValidationResult result = new ValidationResult(Validity.Conforms);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription("soUid was found non-null");
            results.add(result);
            results.add(validateUidFormat());
        }
        return results;
    }

    private ValidationResult validateUidFormat() {
        if (soUid.equals(new UUID(0, 0))) {
            ValidationResult result = new ValidationResult(Validity.DoesNotConform);
            result.setDescription("soUid should not be a null UUID");
            return result;
        } else {
            ValidationResult result = new ValidationResult(Validity.Conforms);
            result.setDescription("soUid is not a null UUID");
            return result;
        }
    }

    private List<ValidationResult> validateRadarCrossSection() {
        return validateIsPositive(this.radarCrossSection, "radarCrossSection");
    }

    private List<ValidationResult> validateLength() {
        return validateIsPositive(this.length, "length");
    }

    private List<ValidationResult> validateWidth() {
        return validateIsPositive(this.width, "width");
    }

    private List<ValidationResult> validateHeight() {
        return validateIsPositive(this.height, "height");
    }

    private List<ValidationResult> validateDiameter() {
        return validateIsPositive(this.diameter, "diameter");
    }

    private List<ValidationResult> validateMass() {
        return validateIsPositive(this.mass, "mass");
    }

    private List<ValidationResult> validateIsPositive(Double value, String label) {
        if (value == null) {
            return new ArrayList<>();
        }
        List<ValidationResult> results = new ArrayList<>();
        if (value <= 0.0) {
            ValidationResult result = new ValidationResult(Validity.DoesNotConform);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription(label + " must be strictly positive");
            results.add(result);
        } else {
            ValidationResult result = new ValidationResult(Validity.Conforms);
            result.setTraceability("STDI-0002 Appendix AP Table 5");
            result.setDescription(label + " was found as strictly positive");
            results.add(result);
        }
        return results;
    }

    private List<ValidationResult> validateOrbitData() {
        if (this.orbitData == null) {
            return new ArrayList<>();
        }
        return orbitData.checkValidity();
    }
}
