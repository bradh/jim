package net.frogmouth.rnd.jim.s4607.hrr;

/**
 * Scatterer Record.
 *
 * <p>A scatterer record can be provided for each target pixel that exceeds the target detection
 * threshold. Alternatively, a complete range-Doppler map, regardless of threshold, may be sent
 * without respective range/Doppler indices for each scatterer.
 *
 * <p>A set of HRR/Range-Doppler Scatterer Records shall be transmitted for the associated MTI
 * target (HRR only) and shall be sent for each dwell processed.
 *
 * <p>Scatterer records within the set shall be ordered in range order (e.g., all Doppler samples at
 * range 1 then all Doppler samples at range 2....) starting at near range. Doppler samples shall be
 * arranged sequentially from negative to positive Doppler. Hence the origin is the scatterer at the
 * nearest range and least Doppler value. In the case of Range-Pulse data the origin would be the
 * first pulse. The Phase of each scatterer is optional.
 */
public class ScattererRecord {
    private int magnitude;
    private Integer phase;
    private Integer rangeIndex;
    private Integer dopplerIndex;

    /**
     * Scatterer Magnitude (H32.1).
     *
     * <p>Scatterer’s power magnitude, quantized to 1 or 2 bytes per field H25, normalized to peak
     * scatterer, and expressed in quarter-decibels (dB/4). The value is calculated by: (a)
     * converting the Scatterer Magnitude to decibels (dB), with the maximum value constrained to
     * 63.75 dB (H25=1) or 16383.75 dB (H25=2); (b) multiplying that value by 4; and (c) rounding to
     * the nearest integer.
     *
     * <p>This field is mandatory.
     *
     * @return the normalised scatterer magnitude in -dB/4.
     */
    public int getMagnitude() {
        return magnitude;
    }

    /**
     * Set the Scatterer Magnitude (H32.1).
     *
     * <p>Scatterer’s power magnitude, quantized to 1 or 2 bytes per field H25, normalized to peak
     * scatterer, and expressed in quarter-decibels (dB/4). The value is calculated by: (a)
     * converting the Scatterer Magnitude to decibels (dB), with the maximum value constrained to
     * 63.75 dB (H25=1) or 16383.75 dB (H25=2); (b) multiplying that value by 4; and (c) rounding to
     * the nearest integer.
     *
     * <p>This field is mandatory.
     *
     * @param magnitude the normalised scatterer magnitude in -dB/4.
     */
    public void setMagnitude(int magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Scatterer Phase (H32.2).
     *
     * <p>Scatterer’s complex phase in degrees, quantized to 1 or 2 bytes per Para. 3.5.26, and
     * expressed as a quantized rotation in units of 2*pi/256 (H26=1) or 2*pi/65536 (H26=2).
     *
     * <p>This field is conditional - it is populated if H26 is {@code 1} or {@code 2}.
     *
     * @return the scatterer phase in quantized parts of a circle.
     */
    public Integer getPhase() {
        return phase;
    }

    /**
     * Set the Scatterer Phase (H32.2).
     *
     * <p>Scatterer’s complex phase in degrees, quantized to 1 or 2 bytes per Para. 3.5.26, and
     * expressed as a quantized rotation in units of 2*pi/256 (H26=1) or 2*pi/65536 (H26=2).
     *
     * <p>This field is conditional - it is populated if H26 is {@code 1} or {@code 2}.
     *
     * @param phase the scatterer phase in quantized parts of a circle.
     */
    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    /**
     * Range Index (H32.3).
     *
     * <p>Scatterer’s Range index relative to Range-Doppler chip, where increasing index equates to
     * increasing range.
     *
     * <p>This field is conditional - it must be used when the Range-Doppler matrix is sparsely
     * populated.
     *
     * @return the range index in units of bins (0 to 65535)
     */
    public Integer getRangeIndex() {
        return rangeIndex;
    }

    /**
     * Set the Range Index (H32.3).
     *
     * <p>Scatterer’s Range index relative to Range-Doppler chip, where increasing index equates to
     * increasing range.
     *
     * <p>This field is conditional - it must be used when the Range-Doppler matrix is sparsely
     * populated.
     *
     * @param index the range index in units of bins (0 to 65535)
     */
    public void setRangeIndex(Integer index) {
        this.rangeIndex = index;
    }

    /**
     * Doppler Index (H32.4).
     *
     * <p>Scatterer’s Doppler index relative to Range-Doppler chip, where increasing index equates
     * to increasing Doppler.
     *
     * <p>This field is conditional - it must be used when the Range-Doppler matrix is sparsely
     * populated.
     *
     * @return the Doppler index in units of bins (0 to 65535)
     */
    public Integer getDopplerIndex() {
        return dopplerIndex;
    }

    /**
     * Set the Doppler Index (H32.4).
     *
     * <p>Scatterer’s Doppler index relative to Range-Doppler chip, where increasing index equates
     * to increasing Doppler.
     *
     * <p>This field is conditional - it must be used when the Range-Doppler matrix is sparsely
     * populated.
     *
     * @param index the Doppler index in units of bins (0 to 65535)
     */
    public void setDopplerIndex(Integer index) {
        this.dopplerIndex = index;
    }
}
