package net.frogmouth.rnd.jim.nitf.tre.sensrb;

class Constants {

    static final String TRE_TAG = "SENSRB";
    static final int FLAG_LEN = 1;
    static final int SENSOR_LEN = 25;
    static final int SENSOR_URI_LEN = 32;
    static final int PLATFORM_LEN = 25;
    static final int PLATFORM_URI_LEN = 32;
    static final int OPERATIONAL_DOMAIN_LEN = 10;
    static final int CONTENT_LEVEL_LEN = 1;
    static final int GEODETIC_SYSTEM_LEN = 5;
    static final int GEODETIC_TYPE_LEN = 1;
    static final int ELEVATION_DATUM_LEN = 3;
    static final int LENGTH_UNIT_LEN = 2;
    static final int ANGULAR_UNIT_LEN = 3;
    static final int START_DATE_LEN = 8;
    static final int START_TIME_LEN = 14;
    static final int END_DATE_LEN = 8;
    static final int END_TIME_LEN = 14;
    static final int GENERATION_COUNT_LEN = 2;
    static final int GENERATION_DATE_LEN = 8;
    static final int GENERATION_TIME_LEN = 10;
    static final int DETECTION_LEN = 20;
    static final int FOCAL_LENGTH_LEN = 8;
    static final int ROW_FOV_LEN = 8;
    static final int COLUMN_FOV_LEN = 8;
    static final int CALIBRATED_LEN = 1;
    // Module 3
    static final int CALIBRATION_UNIT_LEN = 2;
    static final int PRINCIPAL_POINT_OFFSET_LEN = 9;
    static final int RADIAL_DISTORT_LEN = 12;
    static final int RADIAL_DISTORT_LIMIT_LEN = 9;
    static final int DECENT_DISTORT_LEN = 12;
    static final int AFFINITY_DISTORT_LEN = 12;
    static final int DATE_LEN = 8;
    // Module 4
    static final int METHOD_LEN = 15;
    static final int MODE_LEN = 3;
    static final int ROW_RATE_LEN = 10;
    static final int COLUMN_RATE_LEN = 10;
    static final int REFERENCE_TIME_LEN = 12;
    static final int ROW_LEN = 8;
    static final int COLUMN_LEN = 8;
    static final int LATITUDE_OR_X_LEN = 11;
    static final int LONGITUDE_OR_Y_LEN = 12;
    static final int ALTITUDE_OR_Z_LEN = 11;
    static final int SENSOR_X_OFFSET_LEN = 8;
    static final int SENSOR_Y_OFFSET_LEN = 8;
    static final int SENSOR_Z_OFFSET_LEN = 8;
    static final int SENSOR_ANGLE_MODEL_LEN = 1;
    static final int SENSOR_ANGLE_1_LEN = 10;
    static final int SENSOR_ANGLE_2_LEN = 9;
    static final int SENSOR_ANGLE_3_LEN = 10;
    static final int PLATFORM_RELATIVE_FLAG_LEN = 1;
    static final int PLATFORM_HEADING_LEN = 9;
    static final int PLATFORM_PITCH_LEN = 9;
    static final int PLATFORM_ROLL_LEN = 10;
    // Module 8
    static final int ATTITUDE_UNIT_VECTOR_COMPONENT_LEN = 10;
    // Module 9
    static final int QUATERNION_LEN = 10;
    // Module 10
    static final int VELOCITY_LEN = 9;
    // Module 11
    static final int POINT_SET_COUNT_LEN = 2;
    static final int POINT_SET_TYPE_LEN = 25;
    static final int POINT_COUNT_LEN = 3;
    static final int LATITUDE_LEN = 10;
    static final int LONGITUDE_LEN = 11;
    static final int ELEVATION_LEN = 6;
    static final int RANGE_LEN = 8;
    // Module 12
    static final int TIME_STAMPED_DATA_SET_COUNT_LEN = 2;
    static final int TIME_STAMP_TYPE_LEN = 3;
    static final int TIME_STAMP_COUNT_LEN = 4;
    static final int TIME_STAMP_TIME_LEN = 12;
    // Module 13
    static final int PIXEL_REFERENCED_DATA_SET_COUNT_LEN = 2;
    static final int PIXEL_REFERENCE_TYPE_LEN = 3;
    static final int PIXEL_REFERENCE_COUNT_LEN = 4;
    // Module 14
    static final int UNCERTAINTY_DATA_COUNT_LEN = 3;
    static final int UNCERTAINTY_FIRST_TYPE_LEN = 11;
    static final int UNCERTAINTY_SECOND_TYPE_LEN = 11;
    static final int UNCERTAINTY_VALUE_LEN = 10;
    // Module 15
    static final int ADDITIONAL_DATA_COUNT_LEN = 3;
    static final int PARAMETER_NAME_LEN = 25;
    static final int PARAMETER_SIZE_LEN = 3;
    static final int PARAMETER_COUNT_LEN = 4;
}
