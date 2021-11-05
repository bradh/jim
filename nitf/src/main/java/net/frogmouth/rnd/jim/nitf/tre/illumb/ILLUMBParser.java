package net.frogmouth.rnd.jim.nitf.tre.illumb;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;
import net.frogmouth.rnd.jim.nitf.utils.ReaderUtils;

/** ILLUMB TRE Parser. */
public class ILLUMBParser extends AbstractTREParser {

    private static final int NUM_BANDS_LEN = 4;
    private static final int BAND_UNIT_LEN = 40;
    private static final int BOUND_LEN = 16;
    private static final int NUM_OTHERS_LEN = 2;
    private static final int OTHER_NAME_LEN = 40;
    private static final int NUM_COMS_LEN = 1;
    private static final int COMMENT_LEN = 80;
    private static final int GEO_DATUM_LEN = 80;
    private static final int GEO_DATUM_CODE_LEN = 4;
    private static final int ELLIPSOID_NAME_LEN = 80;
    private static final int ELLIPSOID_CODE_LEN = 3;
    private static final int VERTICAL_DATUM_REF_LEN = 80;
    private static final int VERTICAL_REF_CODE_LEN = 4;
    private static final int EXISTENCE_MASK_LEN = 3;
    private static final int RAD_QUANTITY_FLAG = 1 << 23;
    private static final int SUN_AZIMUTH_FLAG = 1 << 22;
    private static final int MOON_AZIMUTH_FLAG = 1 << 21;
    private static final int MOON_PHASE_ANGLE_FLAG = 1 << 20;
    private static final int MOON_ILLUM_PERCENT_FLAG = 1 << 19;
    private static final int OTHER_AZIMUTH_FLAG = 1 << 18;
    private static final int SENSOR_AZIMUTH_FLAG = 1 << 17;
    private static final int CATS_ANGLE_FLAG = 1 << 16;
    private static final int SUN_GLINT_FLAG = 1 << 15;
    private static final int CATM_ANGLE_FLAG = 1 << 14;
    private static final int MOON_GLINT_FLAG = 1 << 13;
    private static final int SUN_ILLUM_METHOD_FLAG = 1 << 12;
    private static final int MOON_ILLUM_METHOD_FLAG = 1 << 11;
    private static final int SOL_LUN_DIST_ADJUST_FLAG = 1 << 10;
    private static final int OTHER_ILLUM_METHOD_FLAG = 1 << 9;
    private static final int ART_ILLUM_METHOD_FLAG = 1 << 8;
    private static final int RAD_QUANTITY_LEN = 40;
    private static final int RADQ_UNIT_LEN = 40;
    private static final int NUM_ILLUM_SETS_LEN = 3;
    private static final int DATETIME_LEN = 14;
    private static final int TARGET_LAT_LEN = 10;
    private static final int TARGET_LON_LEN = 11;
    private static final int TARGET_HGT_LEN = 14;
    private static final int SUN_AZIMUTH_LEN = 5;
    private static final int SUN_ELEV_LEN = 5;
    private static final int MOON_AZIMUTH_LEN = 5;
    private static final int MOON_ELEV_LEN = 5;
    private static final int MOON_PHASE_ANGLE_LEN = 6;
    private static final int MOON_ILLUM_PERCENT_LEN = 3;
    private static final int OTHER_AZIMUTH_LEN = 5;
    private static final int OTHER_ELEV_LEN = 5;
    private static final int SENSOR_AZIMUTH_LEN = 5;
    private static final int SENSOR_ELEV_LEN = 5;
    private static final int CATS_ANGLE_LEN = 5;
    private static final int SUN_GLINT_LAT_LEN = 10;
    private static final int SUN_GLINT_LON_LEN = 11;
    private static final int CATM_ANGLE_LEN = 5;
    private static final int MOON_GLINT_LAT_LEN = 10;
    private static final int MOON_GLINT_LON_LEN = 11;
    private static final int SOL_LUN_DIST_ADJUST_LEN = 7;
    private static final int SUN_ILLUM_METHOD_LEN = 1;
    private static final int SUN_ILLUM_LEN = 16;
    private static final int MOON_ILLUM_METHOD_LEN = 1;
    private static final int MOON_ILLUM_LEN = 16;
    private static final int TOT_SUNMOON_ILLUM_LEN = 16;
    private static final int OTHER_ILLUM_METHOD_LEN = 1;
    private static final int OTHER_ILLUM_LEN = 16;
    private static final int ART_ILLUM_METHOD_LEN = 1;
    private static final int ART_ILLUM_MIN_LEN = 16;
    private static final int ART_ILLUM_MAX_LEN = 16;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "ILLUMB";
    }

    @Override
    public ILLUMB parse(String tag, byte[] bytes) {
        ILLUMB tre = new ILLUMB();
        int offset = 0;
        int num_bands = readBCSNPI(bytes, offset, NUM_BANDS_LEN);
        offset += NUM_BANDS_LEN;
        tre.setBand_unit(readECSA(bytes, offset, BAND_UNIT_LEN));
        offset += BAND_UNIT_LEN;
        for (int b = 0; b < num_bands; b++) {
            Band band = new Band();
            band.setLowerBound(readBCSA(bytes, offset, BOUND_LEN));
            offset += BOUND_LEN;
            band.setUpperBound(readBCSA(bytes, offset, BOUND_LEN));
            offset += BOUND_LEN;
            tre.addBand(band);
        }
        int num_others = readBCSNPI(bytes, offset, NUM_OTHERS_LEN);
        offset += NUM_OTHERS_LEN;
        for (int j = 0; j < num_others; j++) {
            OtherIllumSource other = new OtherIllumSource();
            other.setName(readECSA(bytes, offset, OTHER_NAME_LEN));
            offset += OTHER_NAME_LEN;
            tre.addOther(other);
        }
        int num_coms = readBCSNPI(bytes, offset, NUM_COMS_LEN);
        offset += NUM_COMS_LEN;
        for (int k = 0; k < num_coms; k++) {
            Comment comment = new Comment();
            comment.setComment(readECSA(bytes, offset, COMMENT_LEN));
            offset += COMMENT_LEN;
            tre.addComment(comment);
        }
        tre.setGeo_datum(readBCSA(bytes, offset, GEO_DATUM_LEN));
        offset += GEO_DATUM_LEN;
        tre.setGeo_datum_code(readBCSA(bytes, offset, GEO_DATUM_CODE_LEN));
        offset += GEO_DATUM_CODE_LEN;
        tre.setEllipsoid_name(readBCSA(bytes, offset, ELLIPSOID_NAME_LEN));
        offset += ELLIPSOID_NAME_LEN;
        tre.setEllipsoid_code(readBCSA(bytes, offset, ELLIPSOID_CODE_LEN));
        offset += ELLIPSOID_CODE_LEN;
        tre.setVertical_datum_ref(readBCSA(bytes, offset, VERTICAL_DATUM_REF_LEN));
        offset += VERTICAL_DATUM_REF_LEN;
        tre.setVertical_ref_code(readBCSA(bytes, offset, VERTICAL_REF_CODE_LEN));
        offset += VERTICAL_REF_CODE_LEN;
        int existence_mask = readBits24(bytes, offset);
        offset += EXISTENCE_MASK_LEN;
        if ((existence_mask & RAD_QUANTITY_FLAG) == RAD_QUANTITY_FLAG) {
            tre.setRad_quantity(readECSA(bytes, offset, RAD_QUANTITY_LEN));
            offset += RAD_QUANTITY_LEN;
            tre.setRadq_unit(readECSA(bytes, offset, RADQ_UNIT_LEN));
            offset += RADQ_UNIT_LEN;
        }
        int num_illum_sets = readBCSNPI(bytes, offset, NUM_ILLUM_SETS_LEN);
        offset += NUM_ILLUM_SETS_LEN;
        for (int n = 0; n < num_illum_sets; n++) {
            IllumCondition illumCondition = new IllumCondition();
            illumCondition.setDatetime(readBCSA(bytes, offset, DATETIME_LEN));
            offset += DATETIME_LEN;
            illumCondition.setTarget_lat(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, TARGET_LAT_LEN));
            offset += TARGET_LAT_LEN;
            illumCondition.setTarget_lon(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, TARGET_LON_LEN));
            offset += TARGET_LON_LEN;
            illumCondition.setTarget_hgt(readBCSA(bytes, offset, TARGET_HGT_LEN));
            offset += TARGET_HGT_LEN;
            if ((existence_mask & SUN_AZIMUTH_FLAG) == SUN_AZIMUTH_FLAG) {
                illumCondition.setSun_azimuth(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SUN_AZIMUTH_LEN));
                offset += SUN_AZIMUTH_LEN;
                illumCondition.setSun_elev(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SUN_ELEV_LEN));
                offset += SUN_ELEV_LEN;
            }
            if ((existence_mask & MOON_AZIMUTH_FLAG) == MOON_AZIMUTH_FLAG) {
                illumCondition.setMoon_azimuth(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, MOON_AZIMUTH_LEN));
                offset += MOON_AZIMUTH_LEN;
                illumCondition.setMoon_elev(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, MOON_ELEV_LEN));
                offset += MOON_ELEV_LEN;
            }
            if ((existence_mask & MOON_PHASE_ANGLE_FLAG) == MOON_PHASE_ANGLE_FLAG) {
                illumCondition.setMoon_phase_angle(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, MOON_PHASE_ANGLE_LEN));
                offset += MOON_PHASE_ANGLE_LEN;
            }
            if ((existence_mask & MOON_ILLUM_PERCENT_FLAG) == MOON_ILLUM_PERCENT_FLAG) {
                illumCondition.setMoon_illum_percent(
                        readBCSNPI(bytes, offset, MOON_ILLUM_PERCENT_LEN));
                offset += MOON_ILLUM_PERCENT_LEN;
            }
            if ((existence_mask & OTHER_AZIMUTH_FLAG) == OTHER_AZIMUTH_FLAG) {
                OtherNaturalIllumSourceAzEl other = new OtherNaturalIllumSourceAzEl();
                other.setOther_azimuth(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, OTHER_AZIMUTH_LEN));
                offset += OTHER_AZIMUTH_LEN;
                other.setOther_elev(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, OTHER_ELEV_LEN));
                offset += OTHER_ELEV_LEN;
                illumCondition.addOtherSource(other);
            }
            if ((existence_mask & SENSOR_AZIMUTH_FLAG) == SENSOR_AZIMUTH_FLAG) {
                illumCondition.setSensor_azimuth(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SENSOR_AZIMUTH_LEN));
                offset += SENSOR_AZIMUTH_LEN;
                illumCondition.setSensor_elev(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SENSOR_ELEV_LEN));
                offset += SENSOR_ELEV_LEN;
            }
            if ((existence_mask & CATS_ANGLE_FLAG) == CATS_ANGLE_FLAG) {
                illumCondition.setCats_angle(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, CATS_ANGLE_LEN));
                offset += CATS_ANGLE_LEN;
            }
            if ((existence_mask & SUN_GLINT_FLAG) == SUN_GLINT_FLAG) {
                illumCondition.setSun_glint_lat(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SUN_GLINT_LAT_LEN));
                offset += SUN_GLINT_LAT_LEN;
                illumCondition.setSun_glint_lon(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SUN_GLINT_LON_LEN));
                offset += SUN_GLINT_LON_LEN;
            }
            if ((existence_mask & CATM_ANGLE_FLAG) == CATM_ANGLE_FLAG) {
                illumCondition.setCatm_angle(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, CATM_ANGLE_LEN));
                offset += CATM_ANGLE_LEN;
            }
            if ((existence_mask & MOON_GLINT_FLAG) == MOON_GLINT_FLAG) {
                illumCondition.setMoon_glint_lat(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, MOON_GLINT_LAT_LEN));
                offset += MOON_GLINT_LAT_LEN;
                illumCondition.setMoon_glint_lon(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, MOON_GLINT_LON_LEN));
                offset += MOON_GLINT_LON_LEN;
            }
            if ((existence_mask & SOL_LUN_DIST_ADJUST_FLAG) == SOL_LUN_DIST_ADJUST_FLAG) {
                illumCondition.setSol_lun_dist_adjust(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SOL_LUN_DIST_ADJUST_LEN));
                offset += SOL_LUN_DIST_ADJUST_LEN;
            }
            for (int b = 0; b < num_bands; b++) {
                BandIllum bandIllum = new BandIllum();
                boolean bandHasValue = false;
                if ((existence_mask & SUN_ILLUM_METHOD_FLAG) == SUN_ILLUM_METHOD_FLAG) {
                    bandIllum.setSun_illum_method(readBCSA(bytes, offset, SUN_ILLUM_METHOD_LEN));
                    offset += SUN_ILLUM_METHOD_LEN;
                    bandIllum.setSun_illum(readBCSA(bytes, offset, SUN_ILLUM_LEN));
                    offset += SUN_ILLUM_LEN;
                    bandHasValue = true;
                }
                if ((existence_mask & MOON_ILLUM_METHOD_FLAG) == MOON_ILLUM_METHOD_FLAG) {
                    bandIllum.setMoon_illum_method(readBCSA(bytes, offset, MOON_ILLUM_METHOD_LEN));
                    offset += MOON_ILLUM_METHOD_LEN;
                    bandIllum.setMoon_illum(readBCSA(bytes, offset, MOON_ILLUM_LEN));
                    offset += MOON_ILLUM_LEN;
                    bandHasValue = true;
                }
                if ((existence_mask & SOL_LUN_DIST_ADJUST_FLAG) == SOL_LUN_DIST_ADJUST_FLAG) {
                    bandIllum.setTotal_sun_moon_illum(
                            readBCSA(bytes, offset, TOT_SUNMOON_ILLUM_LEN));
                    offset += TOT_SUNMOON_ILLUM_LEN;
                    bandHasValue = true;
                }
                if ((existence_mask & OTHER_ILLUM_METHOD_FLAG) == OTHER_ILLUM_METHOD_FLAG) {
                    for (int j = 0; j < num_others; j++) {
                        OtherSourceBandIllum other = new OtherSourceBandIllum();

                        offset += OTHER_ILLUM_METHOD_LEN;
                        offset += OTHER_ILLUM_LEN;
                        bandIllum.addOtherSource(other);
                    }
                    bandHasValue = true;
                }
                if ((existence_mask & ART_ILLUM_METHOD_FLAG) == ART_ILLUM_METHOD_FLAG) {
                    bandIllum.setArt_illum_method(readBCSA(bytes, offset, ART_ILLUM_METHOD_LEN));
                    offset += ART_ILLUM_METHOD_LEN;
                    bandIllum.setArt_illum_min(readBCSA(bytes, offset, ART_ILLUM_MIN_LEN));
                    offset += ART_ILLUM_MIN_LEN;
                    bandIllum.setArt_illum_max(readBCSA(bytes, offset, ART_ILLUM_MAX_LEN));
                    offset += ART_ILLUM_MAX_LEN;
                    bandHasValue = true;
                }
                if (bandHasValue) {
                    illumCondition.addBand(bandIllum);
                }
            }
            tre.addIllumCondition(illumCondition);
        }

        assert offset == bytes.length;
        return tre;
    }
}
