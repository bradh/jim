package net.frogmouth.rnd.jim.nitf.image;

/**
 * Image category (ICAT).
 *
 * <p>Contains a valid indicator of the specific category of image, raster, or grid data. The
 * specific category of an IS reveals its intended use or the nature of its collector.
 *
 * <p>Where the ICAT field designates a MI implementation, the string “.M” is added to a STI ICAT
 * value. Where adding “.M” causes an ICAT value to exceed the allowed length of 8 characters, the
 * last letter(s) of the STI ICAT value are omitted so that the MI ICAT value is exactly 8
 * characters in length.
 */
public enum ImageCategory {

    /**
     * Unknown image category type.
     *
     * <p>This denotes an unknown image category type, and typically indicates a broken file or an
     * error during parsing. This is not a valid value in a NITF or NSIF image segment.
     */
    UNKNOWN(""),

    /** Barometric Pressure (BARO). */
    BARO("BARO"),

    /**
     * Black/White Frame Photography (BP).
     *
     * <p>The film or imagery produced by a black/white camera to produce planimetric and
     * topographic maps of the earth's surface; includes surveying cameras, hand-held cameras, and
     * most reconnaissance cameras.
     */
    BP("BP"),

    /**
     * Computerized Axial Tomography Scan (CAT).
     *
     * <p>CAT Scans represent specialized x-rays of cross-sectional images from within the body;
     * used for medical diagnosis.
     */
    CAT("CAT"),

    /**
     * Cloud, Aerosol, Water Vapor, Ice, Snow (CAVIS).
     *
     * <p>Data from a system capable of monitoring the atmosphere and provide correction data
     * through Cloud, Aerosol, Water Vapor, Ice, Snow (CAVIS) or other obscurants. The CAVIS
     * spectrum is approximately 30 meters resolution.
     */
    CAVIS("CAVIS"),

    /**
     * Coherent Change Detection (CCD).
     *
     * <p>A technique reveals changes (tire tracks, tank tracks, mine or barrier emplacement, etc.)
     * in coherent synthetic aperture radar (SAR) images that are taken from approximately the same
     * geometry collected at two different times.
     */
    CCD("CCD"),

    /**
     * Cloud (CLOUD).
     *
     * <p>Meteorological data (coverage, type, density, etc.) of clouds.
     */
    CLOUD("CLOUD"),

    /**
     * Color Frame Photography (CP).
     *
     * <p>The film or imagery produced by a color camera to produce planimetric and topographic maps
     * of the earth's surface; includes surveying cameras, hand-held cameras, and most
     * reconnaissance cameras.
     */
    CP("CP"),

    /** Water current (CURRENT). */
    CURRENT("CURRENT"),

    /**
     * Digital Elevation Data (DED).
     *
     * <p>Digital elevation Model/data consists of a raster grid of regularly spaced elevation
     * values that have been primarily derived from the USGS topographic map series.
     */
    DED("DED"),

    /** Water depth (DEPTH). */
    DEPTH("DEPTH"),

    /**
     * Elevation Model (DTEM).
     *
     * <p>Digital elevation model/data consists of a raster grid of regularly spaced elevation
     * values that have been primarily derived from the USGS topographic map series.
     */
    DTEM("DTEM"),

    /**
     * Daylight Television (DTV.
     *
     * <p>The term 'Daylight Television' is operationally used to denote data from an optical source
     * providing real-time monitoring via motion imagery. DTV refers to a daytime-only optical
     * source as opposed to Low-Light Level TV (LLLTV) or Infrared Full Motion Video. When used as
     * an ICAT value within NITF/NSIF, the code categorizes still imagery frames captured from a
     * real-time feed or archived video.
     */
    DTV("DTV"),

    /** Electro-optical (EO). */
    EO("EO"),

    /** Electro-optical visual (EOVIS). */
    EOVIS("EOVIS"),

    /**
     * Forward Looking Infrared (FL).
     *
     * <p>Forward Looking Infrared is an airborne, electro-optical thermal imaging device that
     * detects far-infrared energy, converts the energy into an electronica signal, and provides a
     * visible imager for day or night viewing.
     */
    FL("FL"),

    /**
     * Fingerprints (FP).
     *
     * <p>Fingerprints used for identification which represent the markings on the inner surface of
     * the fingertip, particularly when made with ink.
     */
    FP("FP"),

    /**
     * High Resolution Radar (HR).
     *
     * <p>High Resolution Radar which has been attenuated to take advantage of maximum pulse length
     * and antenna beamwidth.
     */
    HR("HR"),

    /**
     * Hyperspectral (HS).
     *
     * <p>Hyperspectral imagery or imagery with narrow bandwidth and hundreds of bands;
     * compare/contrast with monochromatic, multispectral, and ultraspectral.
     */
    HS("HS"),

    /**
     * Infrared (IR).
     *
     * <p>That imagery produced as a result of sensing electromagnetical radiation emitted or
     * reflected from a given target surface in the infrared position of the electromagnetic
     * spectrum (approximately 0.72 to 1,000 microns).
     */
    IR("IR"),

    /**
     * Inverse Synthetic Aperture Radar (ISAR).
     *
     * <p>A category of radar-derived imagery where the movement of the target rather than the
     * emitter is used to create the synthetic aperture.
     */
    ISAR("ISAR"),

    /**
     * Legends (LEG).
     *
     * <p>Textual data that provides reference amplification for images.
     */
    LEG("LEG"),

    /**
     * Location Grid (LOCG).
     *
     * <p>Geolocation of an image within a frame.
     */
    LOCG("LOCG"),

    /**
     * Longwave Infrared (LWIR).
     *
     * <p>Data from a system capable of detecting light in the longwave infrared (LWIR) portion of
     * the electro-optical (EO) spectrum. The LWIR spectrum ranges from approximately 5.0 to 14.0
     * microns.
     */
    LWIR("LWIR"),

    /**
     * Raster Map (MAP).
     *
     * <p>Raster Maps result from the numerical process that scans contiguous pixel values to
     * produce an image representation.
     */
    MAP("MAP"),

    /**
     * Matrix Data (MATR).
     *
     * <p>Geometric data other than terrain and elevation.
     */
    MATR("MATR"),

    /**
     * Magnetic Resonance Imagery (MRI).
     *
     * <p>Magnetic Resonance Imagery is imagery formed from the response of electrons, atoms,
     * molecules, or nuclei to discrete radiation frequencies.
     */
    MRI("MRI"),

    /**
     * Multispectral (MS).
     *
     * <p>Multispectral imagery or imagery from an object obtained simultaneously in a number of
     * discrete spectral bands.
     */
    MS("MS"),

    /**
     * Midwave Infrared (MWIR).
     *
     * <p>Data from a system capable of detecting light in the midwave infrared (MWIR) portion of
     * the electro-optical (EO) spectrum. The MWIR spectrum ranges from approximately 3.0 to 5.0
     * microns.
     */
    MWIR("MWIR"),

    /**
     * Near-Infrared (NIR).
     *
     * <p>Data from a system capable of detecting light in the near-infrared (NIR) portion of the
     * electro-optical (EO) spectrum. The NIR spectrum ranges from approximately 0.7 to 1.1 microns.
     */
    NIR("NIR"),

    /**
     * Optical (OP).
     *
     * <p>Optical imagery is captured using the principle of a focal plane intersecting an optical
     * axis in a film camera.
     */
    OP("OP"),

    /**
     * Panchromatic (PAN).
     *
     * <p>A panchromatic image is acquired with a sensor that is sensitive to all or most of the
     * visible spectrum. It is normally shown in black and white.
     */
    PAN("PAN"),

    /**
     * Color Patch (PAT).
     *
     * <p>Color Patch usually accompanied with a Look-up-Table (LUT) to equate colors to an image.
     */
    PAT("PAT"),

    /**
     * Pixel Quality Image Segment (PIXQUAL).
     *
     * <p>The Pixel Quality image Segment (PQS) contains pixel values that indicate the quality of
     * the pixel values in one or more associated Image Segments (IS). The PQS and its associated
     * IS(s) are linked via the IDLVL field in the IS(s).
     */
    PIXQUAL("PIXQUAL"),

    /**
     * Radar (RD).
     *
     * <p>Radar or Radio Detection and Ranging is imagery produced by recording radar waves
     * reflected from a given target surface.
     */
    RD("RD"),

    /**
     * Synthetic Aperture Radar (SAR).
     *
     * <p>Synthetic Aperture Radar is radar which overcomes image resolution deficiencies by using a
     * short physical antenna to synthesize the effect of a very large antenna giving increased
     * beamwidth.
     */
    SAR("SAR"),

    /**
     * Synthetic Aperture Radar Radio Hologram (SARIQ).
     *
     * <p>Radio hologram (initial phase information) from a Synthetic Aperture Radar (SAR) with
     * 13,000 elements/slant range.
     */
    SARIQ("SARIQ"),

    /**
     * Side Looking Radar (SL).
     *
     * <p>Side-Looking Radar represents An airborne radar, viewing at right angles to the axis of
     * the vehicle, which produces a presentation of terrain or moving targets.
     */
    SL("SL"),

    /**
     * Shortwave Infrared (SWIR).
     *
     * <p>Data from a system capable of detecting light in the shortwave infrared (SWIR) portion of
     * the electro-optical (EO) spectrum. The SWIR spectrum ranges from approximately 1.1 to 3.0
     * microns.
     */
    SWIR("SWIR"),

    /**
     * Thermal infrared (TI).
     *
     * <p>Thermal Infrared is imagery produced by sensing and recording the thermal energy emitted
     * or reflected from the objects which are imaged.
     */
    TI("TI"),

    /**
     * Ultraviolet (UV).
     *
     * <p>Data from a system capable of detecting light in the ultraviolet (UV) portion of the
     * electro-optical (EO) spectrum. The UV spectrum ranges from approximately 0.001 to 0.4
     * micrometres.
     */
    UV("UV"),

    /**
     * Video (VD).
     *
     * <p>Video imagery is motion Imagery defined as imaging sensor / systems that generate
     * sequential or continuous streaming images at specified temporal rates (normally expressed as
     * frames per second).
     */
    VD("VD"),

    /**
     * Visible imagery (VIS).
     *
     * <p>Visible Imagery in the electromagnetic spectrum that is visible to the human eye, usually
     * between .4 and .7 micrometers; this type of imagery is usually captured via digital aerial
     * photographs.
     */
    VIS("VIS"),

    /**
     * Visible to near-infrared (VNIR).
     *
     * <p>Data from a system capable of detecting light in the visible-to-near-infrared (VNIR)
     * portion of the electro-optical (EO) spectrum.
     */
    VNIR("VNIR"),

    /**
     * Wind (WIND).
     *
     * <p>Air wind charts.
     */
    WIND("WIND"),

    /**
     * X-ray (XRAY).
     *
     * <p>A form of electromagnetic radiation, similar to light but of shorter wavelength.
     */
    XRAY("XRAY");

    private final String encodedValue;

    /**
     * Constructor.
     *
     * <p>This is required for enumeration initialisation.
     *
     * @param abbreviation the text abbreviation for the enumeration value.
     */
    private ImageCategory(final String abbreviation) {
        this.encodedValue = abbreviation;
    }

    /**
     * Return the encoded value.
     *
     * <p>This is intended for debug output and output writing.
     *
     * @return the encoded value for an image category.
     */
    public String getEncodedValue() {
        return encodedValue;
    }
}
