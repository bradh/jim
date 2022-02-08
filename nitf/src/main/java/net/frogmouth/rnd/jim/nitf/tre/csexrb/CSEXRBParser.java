package net.frogmouth.rnd.jim.nitf.tre.csexrb;

import java.util.UUID;
import net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;

/** CSEXRB TRE Parser. */
public class CSEXRBParser extends AbstractTREParser {

    private static final int IMAGE_UUID_LEN = UUID_LEN;
    private static final int NUM_ASSOC_DES_LEN = 3;
    private static final int ASSOC_DES_UUID_LEN = UUID_LEN;
    private static final int PLATFORM_ID_LEN = 6;
    private static final int PAYLOAD_ID_LEN = 6;
    private static final int SENSOR_ID_LEN = 6;
    private static final int SENSOR_TYPE_LEN = 1;
    private static final int GROUND_REF_POINT_LEN = 12;
    private static final int DAY_FIRST_LINE_IMAGE_LEN = 8;
    private static final int TIME_FIRST_LINE_IMAGE_LEN = 15;
    private static final int TIME_IMAGE_DURATION_LEN = 16;
    private static final int TIME_STAMP_LOC_LEN = 1;
    private static final int REFERENCE_FRAME_NUM_LEN = 9;
    private static final int BASE_TIMESTAMP_LEN = 24;
    private static final int DT_MULTIPLIER_LEN = 8;
    private static final int DT_SIZE_LEN = 1;
    private static final int NUMBER_FRAMES_LEN = 4;
    private static final int MAX_GSD_LEN = 12;
    private static final int ALONG_SCAN_GSD_LEN = 12;
    private static final int CROSS_SCAN_GSD_LEN = 12;
    private static final int GEO_MEAN_GSD_LEN = 12;
    private static final int A_S_VERT_GSD_LEN = 12;
    private static final int C_S_VERT_GSD_LEN = 12;
    private static final int GEO_MEAN_VERT_GSD_LEN = 12;
    private static final int GSD_BETA_ANGLE_LEN = 5;
    private static final int DYNAMIC_RANGE_LEN = 5;
    private static final int NUM_LINES_LEN = 7;
    private static final int NUM_SAMPLES_LEN = 5;
    private static final int ANGLE_TO_NORTH_LEN = 7;
    private static final int OBLIQUITY_ANGLE_LEN = 6;
    private static final int AZ_OF_OBLIQUITY_LEN = 7;
    private static final int ATM_REFR_FLAG_LEN = 1;
    private static final int VEL_ABER_FLAG_LEN = 1;
    private static final int GRD_COVER_LEN = 1;
    private static final int SNOW_DEPTH_CATEGORY_LEN = 1;
    private static final int SUN_AZIMUTH_LEN = 7;
    private static final int SUN_ELEVATION_LEN = 7;
    private static final int PREDICTED_NIIRS_LEN = 3;
    private static final int CIRCL_ERR_LEN = 5;
    private static final int LINEAR_ERR_LEN = 5;
    private static final int CLOUD_COVER_LEN = 3;
    private static final int ROLLING_SHUTTER_FLAG_LEN = 1;
    private static final int UE_TIME_FLAG_LEN = 1;
    private static final int RESERVED_LEN_LEN = 5;

    @Override
    public String getTag() {
        return "CSEXRB";
    }

    @Override
    public CSEXRB parse(String tag, byte[] bytes) {
        CSEXRB tre = new CSEXRB();
        int offset = 0;
        tre.setImageUUID(this.readUUIDAsString(bytes, offset));
        offset += IMAGE_UUID_LEN;
        int numAssociatedDES = this.readBCSN(bytes, offset, NUM_ASSOC_DES_LEN);
        offset += NUM_ASSOC_DES_LEN;
        for (int i = 0; i < numAssociatedDES; i++) {
            UUID uuid = this.readUUIDAsString(bytes, offset);
            offset += ASSOC_DES_UUID_LEN;
            tre.addAssociatedDESUUID(uuid);
        }
        tre.setPlatformId(this.readBCSA(bytes, offset, PLATFORM_ID_LEN));
        offset += PLATFORM_ID_LEN;
        tre.setPayloadId(this.readBCSA(bytes, offset, PAYLOAD_ID_LEN));
        offset += PAYLOAD_ID_LEN;
        tre.setSensorId(this.readBCSA(bytes, offset, SENSOR_ID_LEN));
        offset += SENSOR_ID_LEN;
        tre.setSensorType(this.readBCSA(bytes, offset, SENSOR_TYPE_LEN));
        offset += SENSOR_TYPE_LEN;
        tre.setGroundRefPointX(this.readECEF(bytes, offset, GROUND_REF_POINT_LEN));
        offset += GROUND_REF_POINT_LEN;
        tre.setGroundRefPointY(this.readECEF(bytes, offset, GROUND_REF_POINT_LEN));
        offset += GROUND_REF_POINT_LEN;
        tre.setGroundRefPointZ(this.readECEF(bytes, offset, GROUND_REF_POINT_LEN));
        offset += GROUND_REF_POINT_LEN;
        if (tre.getSensorType().equals("S")) {
            tre.setDayfirstLineImage(this.readBCSA(bytes, offset, DAY_FIRST_LINE_IMAGE_LEN));
            offset += DAY_FIRST_LINE_IMAGE_LEN;
            tre.setTimeFirstLineImage(
                    this.readDoubleFromBCSN(bytes, offset, TIME_FIRST_LINE_IMAGE_LEN));
            offset += TIME_FIRST_LINE_IMAGE_LEN;
            tre.setTimeImageDuration(
                    this.readDoubleFromBCSN(bytes, offset, TIME_IMAGE_DURATION_LEN));
            offset += TIME_IMAGE_DURATION_LEN;
        }
        if (tre.getSensorType().equals("F")) {
            tre.setTimeStampLoc(this.readBCSA(bytes, offset, TIME_STAMP_LOC_LEN));
            offset += TIME_STAMP_LOC_LEN;
            if (tre.getTimeStampLoc().equals("0")) {
                // TODO
            }
        }
        tre.setMaxGSD(this.readDoubleOrNullFromBCSN(bytes, offset, MAX_GSD_LEN));
        offset += MAX_GSD_LEN;
        tre.setAlongScanGSD(this.readDoubleOrNullFromBCSN(bytes, offset, ALONG_SCAN_GSD_LEN));
        offset += ALONG_SCAN_GSD_LEN;
        tre.setCrossScanGSD(this.readDoubleOrNullFromBCSN(bytes, offset, CROSS_SCAN_GSD_LEN));
        offset += CROSS_SCAN_GSD_LEN;
        tre.setGeoMeanGSD(this.readDoubleOrNullFromBCSN(bytes, offset, GEO_MEAN_GSD_LEN));
        offset += GEO_MEAN_GSD_LEN;
        tre.setAlongScanVerticalGSD(this.readDoubleOrNullFromBCSN(bytes, offset, A_S_VERT_GSD_LEN));
        offset += A_S_VERT_GSD_LEN;
        tre.setCrossScanVerticalGSD(this.readDoubleOrNullFromBCSN(bytes, offset, C_S_VERT_GSD_LEN));
        offset += C_S_VERT_GSD_LEN;
        tre.setGeoMeanVerticalGSD(
                this.readDoubleOrNullFromBCSN(bytes, offset, GEO_MEAN_VERT_GSD_LEN));
        offset += GEO_MEAN_VERT_GSD_LEN;
        tre.setGsdBetaAngle(this.readDoubleOrNullFromBCSN(bytes, offset, GSD_BETA_ANGLE_LEN));
        offset += GSD_BETA_ANGLE_LEN;
        tre.setDynamicRange(this.readIntegerOrNullFromBCSN(bytes, offset, DYNAMIC_RANGE_LEN));
        offset += DYNAMIC_RANGE_LEN;
        tre.setNumLines(this.readBCSNPI(bytes, offset, NUM_LINES_LEN));
        offset += NUM_LINES_LEN;
        tre.setNumSamples(this.readBCSNPI(bytes, offset, NUM_SAMPLES_LEN));
        offset += NUM_SAMPLES_LEN;
        tre.setAngleToTrueNorth(this.readDoubleOrNullFromBCSN(bytes, offset, ANGLE_TO_NORTH_LEN));
        offset += ANGLE_TO_NORTH_LEN;
        tre.setObliquityAngle(this.readDoubleOrNullFromBCSN(bytes, offset, OBLIQUITY_ANGLE_LEN));
        offset += OBLIQUITY_ANGLE_LEN;
        tre.setAzimuthOfObliquity(
                this.readDoubleOrNullFromBCSN(bytes, offset, AZ_OF_OBLIQUITY_LEN));
        offset += AZ_OF_OBLIQUITY_LEN;
        tre.setAtmosphericRefractionFlag(this.readBCSA(bytes, offset, ATM_REFR_FLAG_LEN));
        offset += ATM_REFR_FLAG_LEN;
        tre.setVelocityAberrationFlag(this.readBCSA(bytes, offset, VEL_ABER_FLAG_LEN));
        offset += VEL_ABER_FLAG_LEN;

        tre.setGroundCoverFlag(this.readBCSA(bytes, offset, GRD_COVER_LEN));
        offset += GRD_COVER_LEN;
        tre.setSnowDepthCategory(this.readBCSA(bytes, offset, SNOW_DEPTH_CATEGORY_LEN));
        offset += SNOW_DEPTH_CATEGORY_LEN;
        tre.setSunAzimuthAngle(this.readDoubleOrNullFromBCSN(bytes, offset, SUN_AZIMUTH_LEN));
        offset += SUN_AZIMUTH_LEN;
        tre.setSunElevationAngle(this.readDoubleOrNullFromBCSN(bytes, offset, SUN_ELEVATION_LEN));
        offset += SUN_ELEVATION_LEN;
        tre.setPredictedNIIRS(this.readDoubleOrNullFromBCSN(bytes, offset, PREDICTED_NIIRS_LEN));
        offset += PREDICTED_NIIRS_LEN;
        tre.setCircularError(this.readDoubleOrNullFromBCSN(bytes, offset, CIRCL_ERR_LEN));
        offset += CIRCL_ERR_LEN;
        tre.setLinearError(this.readDoubleOrNullFromBCSN(bytes, offset, LINEAR_ERR_LEN));
        offset += LINEAR_ERR_LEN;
        tre.setCloudCover(this.readIntegerOrNullFromBCSN(bytes, offset, CLOUD_COVER_LEN));
        offset += CLOUD_COVER_LEN;
        if (tre.getSensorType().equals("F")) {
            tre.setRollingShutterFlag(this.readBCSA(bytes, offset, ROLLING_SHUTTER_FLAG_LEN));
            offset += ROLLING_SHUTTER_FLAG_LEN;
        }
        tre.setTimeUnmodeledErrorFlag(this.readBCSA(bytes, offset, UE_TIME_FLAG_LEN));
        offset += UE_TIME_FLAG_LEN;
        int reservedLen = this.readBCSN(bytes, offset, RESERVED_LEN_LEN);
        offset += RESERVED_LEN_LEN;
        offset += reservedLen;
        assert offset == bytes.length;
        return tre;
    }
}
