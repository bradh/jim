package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.ANGULAR_UNIT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.CONTENT_LEVEL_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.ELEVATION_DATUM_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.END_DATE_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.END_TIME_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.GENERATION_COUNT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.GENERATION_DATE_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.GENERATION_TIME_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.GEODETIC_SYSTEM_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.GEODETIC_TYPE_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.LENGTH_UNIT_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.OPERATIONAL_DOMAIN_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.PLATFORM_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.PLATFORM_URI_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.SENSOR_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.SENSOR_URI_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.START_DATE_LEN;
import static net.frogmouth.rnd.jim.nitf.tre.sensrb.Constants.START_TIME_LEN;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;

public class Module1 {
    private String sensor;
    private String sensorUri;
    private String platform;
    private String platformUri;
    private String operationalDomain;
    private int contentLevel;
    private String geodeticSystem;
    private String geodeticType;
    private String elevationDatum;
    private String lengthUnit;
    private String angularUnit;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private int generationCount;
    private String generationDate;
    private String generationTime;

    public Module1() {}

    public Module1(Module1 other) {
        this.sensor = other.sensor;
        this.sensorUri = other.sensorUri;
        this.platform = other.platform;
        this.platformUri = other.platformUri;
        this.operationalDomain = other.operationalDomain;
        this.contentLevel = other.contentLevel;
        this.geodeticSystem = other.geodeticSystem;
        this.geodeticType = other.geodeticType;
        this.elevationDatum = other.elevationDatum;
        this.lengthUnit = other.lengthUnit;
        this.angularUnit = other.angularUnit;
        this.startDate = other.startDate;
        this.startTime = other.startTime;
        this.endDate = other.endDate;
        this.endTime = other.endTime;
        this.generationCount = other.generationCount;
        this.generationDate = other.generationDate;
        this.generationTime = other.generationTime;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getSensorUri() {
        return sensorUri;
    }

    public void setSensorUri(String sensorUri) {
        this.sensorUri = sensorUri;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformUri() {
        return platformUri;
    }

    public void setPlatformUri(String platformUri) {
        this.platformUri = platformUri;
    }

    public String getOperationalDomain() {
        return operationalDomain;
    }

    public void setOperationalDomain(String operationalDomain) {
        this.operationalDomain = operationalDomain;
    }

    public int getContentLevel() {
        return contentLevel;
    }

    public void setContentLevel(int contentLevel) {
        this.contentLevel = contentLevel;
    }

    public String getGeodeticSystem() {
        return geodeticSystem;
    }

    public void setGeodeticSystem(String geodeticSystem) {
        this.geodeticSystem = geodeticSystem;
    }

    public String getGeodeticType() {
        return geodeticType;
    }

    public void setGeodeticType(String geodeticType) {
        this.geodeticType = geodeticType;
    }

    public String getElevationDatum() {
        return elevationDatum;
    }

    public void setElevationDatum(String elevationDatum) {
        this.elevationDatum = elevationDatum;
    }

    public String getLengthUnit() {
        return lengthUnit;
    }

    public void setLengthUnit(String lengthUnit) {
        this.lengthUnit = lengthUnit;
    }

    public String getAngularUnit() {
        return angularUnit;
    }

    public void setAngularUnit(String angularUnit) {
        this.angularUnit = angularUnit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getGenerationCount() {
        return generationCount;
    }

    public void setGenerationCount(int generationCount) {
        this.generationCount = generationCount;
    }

    public String getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(String generationDate) {
        this.generationDate = generationDate;
    }

    public String getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(String generationTime) {
        this.generationTime = generationTime;
    }

    void appendBytes(ByteArrayOutputStream baos) {
        baos.writeBytes(WriterUtils.toBCS_A(sensor, SENSOR_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(sensorUri, SENSOR_URI_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(platform, PLATFORM_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(platformUri, PLATFORM_URI_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(operationalDomain, OPERATIONAL_DOMAIN_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(contentLevel, CONTENT_LEVEL_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(geodeticSystem, GEODETIC_SYSTEM_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(geodeticType, GEODETIC_TYPE_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(elevationDatum, ELEVATION_DATUM_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(lengthUnit, LENGTH_UNIT_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(angularUnit, ANGULAR_UNIT_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(startDate, START_DATE_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(startTime, START_TIME_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(endDate, END_DATE_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(endTime, END_TIME_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(generationCount, GENERATION_COUNT_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(generationDate, GENERATION_DATE_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(generationTime, GENERATION_TIME_LEN));
    }
}
