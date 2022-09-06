package net.frogmouth.rnd.jim.s4676.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modality Type.
 *
 * <p>Category of the sensor according to the type of signal it can detect.
 */
public enum ModalityType implements IModalityType {
    /**
     * Doppler signature.
     *
     * <p>Indicates sensitivity to radar Doppler signals.
     */
    DOPPLER_SIGNATURE,
    /**
     * HRR signature. Indicates sensitivity to High-Range Resolution signals. This is a radar
     * modality for GMTI.
     */
    HRR_SIGNATURE,
    /**
     * Image signature.
     *
     * <p>Indicates sensitivity to imagery signals; includes both motion and still imagery.
     */
    IMAGE_SIGNATURE,
    /**
     * Human intelligence (HUMINT).
     *
     * <p>Indicates derivation from, or sensitivity to, Human Intelligence sources.
     */
    HUMINT,
    /**
     * Measurement and Signature intelligence (MASINT).
     *
     * <p>Indicates derivation from, or sensitivity to, Measurement and Signature Intelligence
     * sources.
     */
    MASINT,
    /**
     * Electronic intelligence (ELINT).
     *
     * <p>Indicates derivation from, or sensitivity to, Electronics Intelligence sources.
     */
    ELINT,
    /**
     * Communications intelligence (COMINT) externals.
     *
     * <p>Indicates derivation from, or sensitivity to, Communications Intelligence Externals
     * sources.
     */
    COMINT_EXTERNALS,
    /**
     * Communications intelligence (COMINT) internals.
     *
     * <p>Indicates derivation from, or sensitivity to, Communications Intelligence Internals
     * sources.
     */
    COMINT_INTERNALS,
    /**
     * Open Source Intelligence (OSINT).
     *
     * <p>Indicates derivation from, or sensitivity to, Open Source Intelligence sources.
     */
    OSINT,
    /**
     * Biometrics.
     *
     * <p>Indicates derivation from, or sensitivity to, Biometrics sources.
     */
    BIOMETRICS,
    /**
     * AIS.
     *
     * <p>Indicates derivation from, or sensitivity to, Automated Identification sources.
     */
    AIS,
    /**
     * Blue force tracking (BFT).
     *
     * <p>Indicates derivation from, or sensitivity to, Blue Force Tracking sources.
     */
    BFT,
    /**
     * Seismic.
     *
     * <p>Indicates derivation from, or sensitivity to, seismic sources.
     */
    SEISMIC,
    /**
     * Acoustic.
     *
     * <p>Indicates derivation from, or sensitivity to, Acoustic Intelligence (ACINT) and related
     * sources
     */
    ACOUSTIC,
    /**
     * ADS-B.
     *
     * <p>Indicates derivation from, or sensitivity to, Automatic Dependent Surveillance-Broadcast
     * sources.
     */
    @JsonProperty("ADS-B")
    ADS_B,
    /**
     * Mixed.
     *
     * <p>Indicates derivation from, or sensitivity to, two or more sources.
     */
    MIXED,
    /**
     * Other.
     *
     * <p>Indicates derivation from, or sensitivity to, other types of sources, such as Link 16.
     */
    OTHER,
    /**
     * Classified,
     *
     * <p>Indicates derivation from, or sensitivity to, a classified provider.
     */
    XXXX
}
