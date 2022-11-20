package net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Modality {
    /**
     * Panchromatic.
     *
     * <p>A single-band image covering a broad range of electro-optical wavelengths, usually used in
     * context of collecting information from much of the visible spectrum and sometimes part of the
     * near infrared spectrum.
     */
    @JsonProperty("pan")
    PAN,

    /**
     * Visual.
     *
     * <p>Visible; Multiple bands from portions of the visible EO spectrum (i.e., RGB), typically
     * ≈400 to ≈700 nm.
     */
    @JsonProperty("vis")
    VIS,

    /**
     * Visible to Near-Infrared (VNIR).
     *
     * <p>Typically ≈400 to ≈1100 nm.
     */
    @JsonProperty("vnir")
    VNIR,

    /**
     * Near-Infrared (NIR).
     *
     * <p>Typically ≈700 to ≈1100 nm.
     */
    @JsonProperty("nir")
    NIR,

    /**
     * Short-wavelength Infrared (SWIR).
     *
     * <p>Typically ≈1100 to ≈3000 nm.
     */
    @JsonProperty("swir")
    SWIR,

    /**
     * Mid-wavelength Infrared (MWIR).
     *
     * <p>Typically ≈3000 to ≈5000 nm.
     */
    @JsonProperty("mwir")
    MWIR,

    /**
     * Long-wavelength Infrared (LWIR).
     *
     * <p>Typically ≈5000 to ≈14000 nm.
     */
    @JsonProperty("lwir")
    LWIR,

    /**
     * Multispectral Imagery (MSI).
     *
     * <p>Imagery collected in at least 2 or more relatively wide bands of the EO spectrum. The
     * spectral bands may or may not be contiguous in wavelength. Multispectral sensors often
     * collect bands from discrete portions of the EO spectrum, which are often selected to take
     * advantage of high atmospheric transmission. Bands are collected simultaneously or nearly so,
     * and the spatial coverage for each band may differ slightly from band to band. Spectral bands
     * may be acquired from one or more portions of the EO spectrum. Multispectral systems tend to
     * collect tens of bands. Most multispectral images have fewer than 70 bands, and many satellite
     * sensors collect fewer than 10 bands.
     */
    @JsonProperty("msi")
    MSI,

    /**
     * Hyperspectral Imagery.
     *
     * <p>Imagery acquired using tens to hundreds of spectral bands with narrow EO spectral
     * bandwidth. Bands are acquired simultaneously or nearly so, and the spatial coverage for each
     * band may differ slightly from band to band. Spectral bands are often but not necessarily
     * contiguous and may be acquired from one or more portions of the EO spectrum, enabling
     * construction of an effectively continuous reflectance (emittance in the case of IR energy)
     * spectrum for every pixel in the scene.
     */
    @JsonProperty("hsi")
    HSI,

    /** Synthetic Aperture RADAR (SAR). */
    @JsonProperty("sar")
    SAR
}
