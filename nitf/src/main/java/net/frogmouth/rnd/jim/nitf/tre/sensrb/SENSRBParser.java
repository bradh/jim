package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.TRE_TAG;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;
import net.frogmouth.rnd.jim.nitf.utils.ReaderUtils;

/** SENSRB TRE Parser. */
public class SENSRBParser extends AbstractTaggedRecordExtensionParser {

    private static final int FLAG_LEN = 1;
    private static final int SENSOR_LEN = 25;
    private static final int SENSOR_URI_LEN = 32;
    private static final int PLATFORM_LEN = 25;
    private static final int PLATFORM_URI_LEN = 32;
    private static final int OPERATIONAL_DOMAIN_LEN = 10;
    private static final int CONTENT_LEVEL_LEN = 1;
    private static final int GEODETIC_SYSTEM_LEN = 5;
    private static final int GEODETIC_TYPE_LEN = 1;
    private static final int ELEVATION_DATUM_LEN = 3;
    private static final int LENGTH_UNIT_LEN = 2;
    private static final int ANGULAR_UNIT_LEN = 3;
    private static final int START_DATE_LEN = 8;
    private static final int START_TIME_LEN = 14;
    private static final int END_DATE_LEN = 8;
    private static final int END_TIME_LEN = 14;
    private static final int GENERATION_COUNT_LEN = 2;
    private static final int GENERATION_DATE_LEN = 8;
    private static final int GENERATION_TIME_LEN = 10;
    private static final int DETECTION_LEN = 20;
    private static final int FOCAL_LENGTH_LEN = 8;
    private static final int ROW_FOV_LEN = 8;
    private static final int COLUMN_FOV_LEN = 8;
    private static final int CALIBRATED_LEN = 1;
    // Module 3
    private static final int CALIBRATION_UNIT_LEN = 2;
    private static final int PRINCIPAL_POINT_OFFSET_LEN = 9;
    private static final int RADIAL_DISTORT_LEN = 12;
    private static final int RADIAL_DISTORT_LIMIT_LEN = 9;
    private static final int DECENT_DISTORT_LEN = 12;
    private static final int AFFINITY_DISTORT_LEN = 12;
    private static final int DATE_LEN = 8;
    // Module 4
    private static final int METHOD_LEN = 15;
    private static final int MODE_LEN = 3;
    private static final int ROW_RATE_LEN = 10;
    private static final int COLUMN_RATE_LEN = 10;
    private static final int REFERENCE_TIME_LEN = 12;
    private static final int ROW_LEN = 8;
    private static final int COLUMN_LEN = 8;
    private static final int LATITUDE_OR_X_LEN = 11;
    private static final int LONGITUDE_OR_Y_LEN = 12;
    private static final int ALTITUDE_OR_Z_LEN = 11;
    private static final int SENSOR_X_OFFSET_LEN = 8;
    private static final int SENSOR_Y_OFFSET_LEN = 8;
    private static final int SENSOR_Z_OFFSET_LEN = 8;
    private static final int SENSOR_ANGLE_MODEL_LEN = 1;
    private static final int SENSOR_ANGLE_1_LEN = 10;
    private static final int SENSOR_ANGLE_2_LEN = 9;
    private static final int SENSOR_ANGLE_3_LEN = 10;
    private static final int PLATFORM_RELATIVE_FLAG_LEN = 1;
    private static final int PLATFORM_HEADING_LEN = 9;
    private static final int PLATFORM_PITCH_LEN = 9;
    private static final int PLATFORM_ROLL_LEN = 10;
    // Module 8
    private static final int ATTITUDE_UNIT_VECTOR_COMPONENT_LEN = 10;
    // Module 9
    private static final int QUATERNION_LEN = 10;
    // Module 10
    private static final int VELOCITY_LEN = 9;
    // Module 11
    private static final int POINT_SET_COUNT_LEN = 2;
    private static final int POINT_SET_TYPE_LEN = 25;
    private static final int POINT_COUNT_LEN = 3;
    private static final int LATITUDE_LEN = 10;
    private static final int LONGITUDE_LEN = 11;
    private static final int ELEVATION_LEN = 6;
    private static final int RANGE_LEN = 8;
    // Module 12
    private static final int TIME_STAMPED_DATA_SET_COUNT_LEN = 2;
    private static final int TIME_STAMP_TYPE_LEN = 3;
    private static final int TIME_STAMP_COUNT_LEN = 4;
    private static final int TIME_STAMP_TIME_LEN = 12;
    // Module 13
    private static final int PIXEL_REFERENCED_DATA_SET_COUNT_LEN = 2;
    private static final int PIXEL_REFERENCE_TYPE_LEN = 3;
    private static final int PIXEL_REFERENCE_COUNT_LEN = 4;
    // Module 14
    private static final int UNCERTAINTY_DATA_COUNT_LEN = 3;
    private static final int UNCERTAINTY_FIRST_TYPE_LEN = 11;
    private static final int UNCERTAINTY_SECOND_TYPE_LEN = 11;
    private static final int UNCERTAINTY_VALUE_LEN = 10;
    // Module 15
    private static final int ADDITIONAL_DATA_COUNT_LEN = 3;
    private static final int PARAMETER_NAME_LEN = 25;
    private static final int PARAMETER_SIZE_LEN = 3;
    private static final int PARAMETER_COUNT_LEN = 4;

    @Override
    public String getTag() {
        return TRE_TAG;
    }

    @Override
    public SENSRB parse(String tag, byte[] bytes) {
        SENSRB tre = new SENSRB();
        int offset = 0;
        {
            String generalDataFlag = ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (generalDataFlag.equals("Y")) {
                Module1 module1 = new Module1();
                module1.setSensor(ReaderUtils.convertByteArrayToBCSA(bytes, offset, SENSOR_LEN));
                offset += SENSOR_LEN;
                module1.setSensorUri(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, SENSOR_URI_LEN));
                offset += SENSOR_URI_LEN;
                module1.setPlatform(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PLATFORM_LEN));
                offset += PLATFORM_LEN;
                module1.setPlatformUri(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PLATFORM_URI_LEN));
                offset += PLATFORM_URI_LEN;
                module1.setOperationalDomain(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, OPERATIONAL_DOMAIN_LEN));
                offset += OPERATIONAL_DOMAIN_LEN;
                module1.setContentLevel(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, CONTENT_LEVEL_LEN));
                offset += CONTENT_LEVEL_LEN;
                module1.setGeodeticSystem(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, GEODETIC_SYSTEM_LEN));
                offset += GEODETIC_SYSTEM_LEN;
                module1.setGeodeticType(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, GEODETIC_TYPE_LEN));
                offset += GEODETIC_TYPE_LEN;
                module1.setElevationDatum(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, ELEVATION_DATUM_LEN));
                offset += ELEVATION_DATUM_LEN;
                module1.setLengthUnit(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, LENGTH_UNIT_LEN));
                offset += LENGTH_UNIT_LEN;
                module1.setAngularUnit(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, ANGULAR_UNIT_LEN));
                offset += ANGULAR_UNIT_LEN;
                module1.setStartDate(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, START_DATE_LEN));
                offset += START_DATE_LEN;
                module1.setStartTime(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, START_TIME_LEN));
                offset += START_TIME_LEN;
                module1.setEndDate(ReaderUtils.convertByteArrayToBCSA(bytes, offset, END_DATE_LEN));
                offset += END_DATE_LEN;
                module1.setEndTime(ReaderUtils.convertByteArrayToBCSA(bytes, offset, END_TIME_LEN));
                offset += END_TIME_LEN;
                module1.setGenerationCount(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, GENERATION_COUNT_LEN));
                offset += GENERATION_COUNT_LEN;
                module1.setGenerationDate(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, GENERATION_DATE_LEN));
                offset += GENERATION_DATE_LEN;
                module1.setGenerationTime(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, GENERATION_TIME_LEN));
                offset += GENERATION_TIME_LEN;
                tre.setModule1(module1);
            }
        }
        {
            String sensorArrayDataFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (sensorArrayDataFlag.equals("Y")) {
                Module2 module2 = new Module2();
                module2.setDetection(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, DETECTION_LEN));
                offset += DETECTION_LEN;
                module2.setRowDetectors(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                offset += ROW_LEN;
                module2.setColumnDetectors(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                offset += COLUMN_LEN;
                module2.setRowMetric(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, ROW_LEN));
                offset += ROW_LEN;
                module2.setColumnMetric(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, COLUMN_LEN));
                offset += COLUMN_LEN;
                module2.setFocalLength(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, FOCAL_LENGTH_LEN));
                offset += FOCAL_LENGTH_LEN;
                module2.setRowFieldOfView(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, ROW_FOV_LEN));
                offset += ROW_FOV_LEN;
                module2.setColumnFieldOfView(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, COLUMN_FOV_LEN));
                offset += COLUMN_FOV_LEN;
                module2.setCalibrated(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, CALIBRATED_LEN));
                offset += CALIBRATED_LEN;
                tre.setModule2(module2);
            }
        }
        {
            String sensorCalibrationDataFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (sensorCalibrationDataFlag.equals("Y")) {
                Module3 module3 = new Module3();
                module3.setCalibrationUnit(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, CALIBRATION_UNIT_LEN));
                offset += CALIBRATION_UNIT_LEN;
                module3.setPrincipalPointOffsetX(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, PRINCIPAL_POINT_OFFSET_LEN));
                offset += PRINCIPAL_POINT_OFFSET_LEN;
                module3.setPrincipalPointOffsetY(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, PRINCIPAL_POINT_OFFSET_LEN));
                offset += PRINCIPAL_POINT_OFFSET_LEN;
                module3.setRadialDistortion1(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, RADIAL_DISTORT_LEN));
                offset += RADIAL_DISTORT_LEN;
                module3.setRadialDistortion2(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, RADIAL_DISTORT_LEN));
                offset += RADIAL_DISTORT_LEN;
                module3.setRadialDistortion3(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, RADIAL_DISTORT_LEN));
                offset += RADIAL_DISTORT_LEN;
                module3.setRadialDistortLimit(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, RADIAL_DISTORT_LIMIT_LEN));
                offset += RADIAL_DISTORT_LIMIT_LEN;
                module3.setDecentDistort1(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, DECENT_DISTORT_LEN));
                offset += DECENT_DISTORT_LEN;
                module3.setDecentDistort2(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, DECENT_DISTORT_LEN));
                offset += DECENT_DISTORT_LEN;
                module3.setAffinityDistort1(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, AFFINITY_DISTORT_LEN));
                offset += AFFINITY_DISTORT_LEN;
                module3.setAffinityDistort2(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, AFFINITY_DISTORT_LEN));
                offset += AFFINITY_DISTORT_LEN;
                module3.setCalibrationDate(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, DATE_LEN));
                offset += DATE_LEN;
                tre.setModule3(module3);
            }
        }
        {
            String imageFormationDataFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (imageFormationDataFlag.equals("Y")) {
                Module4 module4 = new Module4();
                module4.setMethod(ReaderUtils.convertByteArrayToBCSA(bytes, offset, METHOD_LEN));
                offset += METHOD_LEN;
                module4.setMode(ReaderUtils.convertByteArrayToBCSA(bytes, offset, MODE_LEN));
                offset += MODE_LEN;
                module4.setRowCount(ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                offset += ROW_LEN;
                module4.setColumnCount(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                offset += COLUMN_LEN;
                module4.setRowSet(ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                offset += ROW_LEN;
                module4.setColumnSet(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                offset += COLUMN_LEN;
                module4.setRowRate(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, ROW_RATE_LEN));
                offset += ROW_RATE_LEN;
                module4.setColumnRate(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, COLUMN_RATE_LEN));
                offset += COLUMN_RATE_LEN;
                module4.setFirstPixelRow(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                offset += ROW_LEN;
                module4.setFirstPixelColumn(
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                offset += COLUMN_LEN;
                int transformParamCount = ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, 1);
                offset += 1;
                double[] transformParams = new double[transformParamCount];
                for (int i = 0; i < transformParamCount; i++) {
                    transformParams[i] =
                            ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, 12);
                    offset += 12;
                }
                module4.setTransformParams(transformParams);
                tre.setModule4(module4);
            }
        }
        {
            Module5 module5 = new Module5();
            module5.setReferenceTime(
                    ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, REFERENCE_TIME_LEN));
            offset += REFERENCE_TIME_LEN;
            module5.setReferenceRow(ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
            offset += ROW_LEN;
            module5.setReferenceColumn(
                    ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
            offset += COLUMN_LEN;
            tre.setModule5(module5);
        }
        {
            Module6 module6 = new Module6();
            module6.setLatitude_or_x(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, LATITUDE_OR_X_LEN));
            offset += LATITUDE_OR_X_LEN;
            module6.setLongitude_or_y(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, LONGITUDE_OR_Y_LEN));
            offset += LONGITUDE_OR_Y_LEN;
            module6.setAltitude_or_z(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, ALTITUDE_OR_Z_LEN));
            offset += ALTITUDE_OR_Z_LEN;
            module6.setSensorOffsetX(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SENSOR_X_OFFSET_LEN));
            offset += SENSOR_X_OFFSET_LEN;
            module6.setSensorOffsetY(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SENSOR_Y_OFFSET_LEN));
            offset += SENSOR_Y_OFFSET_LEN;
            module6.setSensorOffsetZ(
                    ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, SENSOR_Z_OFFSET_LEN));
            offset += SENSOR_Z_OFFSET_LEN;
            tre.setModule6(module6);
        }
        {
            String attitudeEulerAnglesFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (attitudeEulerAnglesFlag.equals("Y")) {
                Module7 module7 = new Module7();
                module7.setSensorAngleModel(
                        ReaderUtils.convertByteArrayToBCS_NPI(
                                bytes, offset, SENSOR_ANGLE_MODEL_LEN));
                offset += SENSOR_ANGLE_MODEL_LEN;
                module7.setSensorAngle1(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SENSOR_ANGLE_1_LEN));
                offset += SENSOR_ANGLE_1_LEN;
                module7.setSensorAngle2(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SENSOR_ANGLE_2_LEN));
                offset += SENSOR_ANGLE_2_LEN;
                module7.setSensorAngle3(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, SENSOR_ANGLE_3_LEN));
                offset += SENSOR_ANGLE_3_LEN;
                module7.setPlatformRelative(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, PLATFORM_RELATIVE_FLAG_LEN));
                offset += PLATFORM_RELATIVE_FLAG_LEN;
                module7.setPlatformHeading(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PLATFORM_HEADING_LEN));
                offset += PLATFORM_HEADING_LEN;
                module7.setPlatformPitch(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PLATFORM_PITCH_LEN));
                offset += PLATFORM_PITCH_LEN;
                module7.setPlatformRoll(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PLATFORM_ROLL_LEN));
                offset += PLATFORM_ROLL_LEN;
                tre.setModule7(module7);
            }
        }
        {
            String attitudeUnitVectorsFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (attitudeUnitVectorsFlag.equals("Y")) {
                Module8 module8 = new Module8();
                module8.setIcxNorthOrX(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIcxEastOrY(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIcxDownOrZ(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIcyNorthOrX(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIcyEastOrY(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIcyDownOrZ(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIczNorthOrX(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIczEastOrY(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                module8.setIczDownOrZ(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, ATTITUDE_UNIT_VECTOR_COMPONENT_LEN));
                offset += ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
                tre.setModule8(module8);
            }
        }
        {
            String attitudeQuaternionFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (attitudeQuaternionFlag.equals("Y")) {
                Module9 module9 = new Module9();
                module9.setAttitudeQ1(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, QUATERNION_LEN));
                offset += QUATERNION_LEN;
                module9.setAttitudeQ2(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, QUATERNION_LEN));
                offset += QUATERNION_LEN;
                module9.setAttitudeQ3(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, QUATERNION_LEN));
                offset += QUATERNION_LEN;
                module9.setAttitudeQ4(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, QUATERNION_LEN));
                offset += QUATERNION_LEN;
                tre.setModule9(module9);
            }
        }
        {
            String sensorVelocityDataFlag =
                    ReaderUtils.convertByteArrayToBCSA(bytes, offset, FLAG_LEN);
            offset += FLAG_LEN;
            if (sensorVelocityDataFlag.equals("Y")) {
                Module10 module10 = new Module10();
                module10.setVelocityNorthOrX(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, VELOCITY_LEN));
                offset += VELOCITY_LEN;
                module10.setVelocityEastOrY(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, VELOCITY_LEN));
                offset += VELOCITY_LEN;
                module10.setVelocityDownOrZ(
                        ReaderUtils.convertByteArrayToBCS_N_Double(bytes, offset, VELOCITY_LEN));
                offset += VELOCITY_LEN;
                tre.setModule10(module10);
            }
        }
        {
            int pointSetCount =
                    ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, POINT_SET_COUNT_LEN);
            offset += POINT_SET_COUNT_LEN;
            for (int i = 0; i < pointSetCount; i++) {
                PointSet pointSet = new PointSet();
                pointSet.setPointSetType(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, POINT_SET_TYPE_LEN));
                offset += POINT_SET_TYPE_LEN;
                int numPoints =
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, POINT_COUNT_LEN);
                offset += POINT_COUNT_LEN;
                for (int j = 0; j < numPoints; j++) {
                    Point point = new Point();
                    point.setRow(ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                    offset += ROW_LEN;
                    point.setColumn(
                            ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                    offset += COLUMN_LEN;
                    point.setLatitude(
                            ReaderUtils.convertByteArrayToBCSA(bytes, offset, LATITUDE_LEN));
                    offset += LATITUDE_LEN;
                    point.setLongitude(
                            ReaderUtils.convertByteArrayToBCSA(bytes, offset, LONGITUDE_LEN));
                    offset += LONGITUDE_LEN;
                    point.setElevation(
                            ReaderUtils.convertByteArrayToBCSA(bytes, offset, ELEVATION_LEN));
                    offset += ELEVATION_LEN;
                    point.setRange(ReaderUtils.convertByteArrayToBCSA(bytes, offset, RANGE_LEN));
                    offset += RANGE_LEN;
                    pointSet.addPoint(point);
                }
                tre.addPointSet(pointSet);
            }
        }
        {
            int timeStampedDataSetsCount =
                    ReaderUtils.convertByteArrayToBCS_NPI(
                            bytes, offset, TIME_STAMPED_DATA_SET_COUNT_LEN);
            offset += TIME_STAMPED_DATA_SET_COUNT_LEN;
            for (int i = 0; i < timeStampedDataSetsCount; i++) {
                TimeStampedSet timeStampedSet = new TimeStampedSet();
                timeStampedSet.setType(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, TIME_STAMP_TYPE_LEN));
                offset += TIME_STAMP_TYPE_LEN;
                int length = lookupLengthForType(timeStampedSet.getType());
                int count =
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, TIME_STAMP_COUNT_LEN);
                offset += TIME_STAMP_COUNT_LEN;
                for (int j = 0; j < count; j++) {
                    TimeStampedValuePair tsvp = new TimeStampedValuePair();
                    tsvp.setTimeStamp(
                            ReaderUtils.convertByteArrayToBCS_N_Double(
                                    bytes, offset, TIME_STAMP_TIME_LEN));
                    offset += TIME_STAMP_TIME_LEN;
                    tsvp.setValue(ReaderUtils.convertByteArrayToBCSA(bytes, offset, length));
                    offset += length;
                    timeStampedSet.addTimeStampedValue(tsvp);
                }
                tre.addTimeStampedSet(timeStampedSet);
            }
        }
        {
            int pixelReferencedDataSetsCount =
                    ReaderUtils.convertByteArrayToBCS_NPI(
                            bytes, offset, PIXEL_REFERENCED_DATA_SET_COUNT_LEN);
            offset += PIXEL_REFERENCED_DATA_SET_COUNT_LEN;
            for (int i = 0; i < pixelReferencedDataSetsCount; i++) {
                PixelReferencedDataSet prds = new PixelReferencedDataSet();
                // TODO: proper parsing
                // TODO: constants
                prds.setType(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, PIXEL_REFERENCE_TYPE_LEN));
                offset += PIXEL_REFERENCE_TYPE_LEN;
                int length = lookupLengthForType(prds.getType());
                int count =
                        ReaderUtils.convertByteArrayToBCS_NPI(
                                bytes, offset, PIXEL_REFERENCE_COUNT_LEN);
                offset += PIXEL_REFERENCE_COUNT_LEN;
                for (int j = 0; j < count; j++) {
                    PixelReferencedValue value = new PixelReferencedValue();
                    value.setRow(ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ROW_LEN));
                    offset += ROW_LEN;
                    value.setColumn(
                            ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, COLUMN_LEN));
                    offset += COLUMN_LEN;
                    value.setValue(ReaderUtils.convertByteArrayToBCSA(bytes, offset, length));
                    offset += length;
                    prds.addPixelReferencedValue(value);
                }
                tre.addPixelReferencedDataSet(prds);
            }
        }
        {
            int uncertaintyDataCount =
                    ReaderUtils.convertByteArrayToBCS_NPI(
                            bytes, offset, UNCERTAINTY_DATA_COUNT_LEN);
            offset += UNCERTAINTY_DATA_COUNT_LEN;
            for (int i = 0; i < uncertaintyDataCount; i++) {
                Uncertainty uncertainty = new Uncertainty();
                uncertainty.setFirstType(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, UNCERTAINTY_FIRST_TYPE_LEN));
                offset += UNCERTAINTY_FIRST_TYPE_LEN;
                uncertainty.setSecondType(
                        ReaderUtils.convertByteArrayToBCSA(
                                bytes, offset, UNCERTAINTY_SECOND_TYPE_LEN));
                offset += UNCERTAINTY_SECOND_TYPE_LEN;
                uncertainty.setValue(
                        ReaderUtils.convertByteArrayToBCS_N_Double(
                                bytes, offset, UNCERTAINTY_VALUE_LEN));
                offset += UNCERTAINTY_VALUE_LEN;
                tre.addUncertainty(uncertainty);
            }
        }
        {
            int additionalDataCount =
                    ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, ADDITIONAL_DATA_COUNT_LEN);
            offset += ADDITIONAL_DATA_COUNT_LEN;
            for (int i = 0; i < additionalDataCount; i++) {
                AdditionalParameter additionalParameter = new AdditionalParameter();
                additionalParameter.setName(
                        ReaderUtils.convertByteArrayToBCSA(bytes, offset, PARAMETER_NAME_LEN));
                offset += PARAMETER_NAME_LEN;
                int fieldSize =
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, PARAMETER_SIZE_LEN);
                offset += PARAMETER_SIZE_LEN;
                int parameterCount =
                        ReaderUtils.convertByteArrayToBCS_NPI(bytes, offset, PARAMETER_COUNT_LEN);
                offset += PARAMETER_COUNT_LEN;
                for (int j = 0; j < parameterCount; j++) {
                    additionalParameter.addValue(
                            ReaderUtils.convertByteArrayToBCSA(bytes, offset, fieldSize));
                    offset += fieldSize;
                }
                tre.addAdditionalParameter(additionalParameter);
            }
        }
        assert offset == bytes.length;
        return tre;
    }

    private int lookupLengthForType(String type) {
        // TODO: this needs a lot more type entries
        switch (type) {
            case "05a":
                return REFERENCE_TIME_LEN;
            case "05b":
                return ROW_LEN;
            case "05c":
                return COLUMN_LEN;
            case "06a":
                return LATITUDE_OR_X_LEN;
            case "06b":
                return LONGITUDE_OR_Y_LEN;
            case "06c":
                return ALTITUDE_OR_Z_LEN;
            case "06d":
                return SENSOR_X_OFFSET_LEN;
            case "06e":
                return SENSOR_Y_OFFSET_LEN;
            case "06f":
                return SENSOR_Z_OFFSET_LEN;
            case "07a":
                return SENSOR_ANGLE_MODEL_LEN;
            case "07b":
                return SENSOR_ANGLE_1_LEN;
            case "07c":
                return SENSOR_ANGLE_2_LEN;
            case "07d":
                return SENSOR_ANGLE_3_LEN;
            case "07e":
                return PLATFORM_RELATIVE_FLAG_LEN;
            case "07f":
                return PLATFORM_HEADING_LEN;
            case "07g":
                return PLATFORM_PITCH_LEN;
            case "07h":
                return PLATFORM_ROLL_LEN;
            case "08a":
            case "08b":
            case "08c":
            case "08d":
            case "08e":
            case "08f":
            case "08g":
            case "08h":
            case "08i":
                return ATTITUDE_UNIT_VECTOR_COMPONENT_LEN;
            case "09a":
                return QUATERNION_LEN;
            case "09b":
                return QUATERNION_LEN;
            case "09c":
                return QUATERNION_LEN;
            case "09d":
                return QUATERNION_LEN;
            case "10a":
                return VELOCITY_LEN;
            case "10b":
                return VELOCITY_LEN;
            case "10c":
                return VELOCITY_LEN;
            default:
                throw new UnsupportedOperationException(
                        "No time varying support for type: " + type);
        }
    }
}
