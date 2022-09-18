package net.frogmouth.rnd.jim.s4676.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Covariance matrix.
 *
 * <p>The covariance values, provided as a list of doubles. The number of covariance values to be
 * expected depends upon the coordinate system type (specified in the parent class) and the
 * covariance matrix type. Only the diagonal and upper-right triangle elements of the covariance
 * matrix are reported, and should be reported Left-to-Right, Top-to-Bottom.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CovarianceMatrix {
    @JacksonXmlProperty(isAttribute = true)
    private CovarianceType covarianceType;

    @JacksonXmlProperty(namespace = "urn:nato:niia:stanag:4676:isrtrackingstandard:b:1")
    @JsonValue
    private Double[] doubleArray;

    /**
     * Constructor.
     *
     * <p>This is only for the parser. Use the version that includes the required instance values.
     */
    private CovarianceMatrix() {}

    /**
     * Constructor.
     *
     * @param covarianceType The covariance matrix type [POS/VEL/ACC][3D/2D].
     * @param doubleArray the values in the covariance matrix (diagonal and upper right triangle).
     */
    public CovarianceMatrix(CovarianceType covarianceType, Double[] doubleArray) {
        this.covarianceType = covarianceType;
        this.doubleArray = doubleArray;
    }

    /**
     * Covariance matrix type.
     *
     * <p>The covariance matrix type [POS/VEL/ACC][3D/2D].
     *
     * @return covariance matrix as an enumerated value.
     */
    public CovarianceType getCovarianceType() {
        return covarianceType;
    }

    /**
     * Covariance matrix values.
     *
     * <p>The values in the covariance matrix - diagonal and upper right triangle - reported in left
     * to right, top to bottom order.
     *
     * @return the values as an array
     */
    public Double[] getDoubleArray() {
        return doubleArray;
    }
}
