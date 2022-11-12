package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import org.testng.annotations.Test;

public class SENSRBParserTest {

    public SENSRBParserTest() {}

    @Test
    public void checkMinimalStandalone() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader.getResourceAsStream("SENSRB/SENSRB_minimal.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a   Sensor  SYERS2A
        1.01b   Sensor URI
        1.01c   Platform        U-2
        1.01d   Platform URI
        1.01e   Operational Domain      Airborne
        1.01f   Content Level   0
        1.01g   Geodetic System WGS84
        1.01h   Geodetic Type   G
        1.01i   Elevation Datum HAE
        1.01j   Length Unit     SI
        1.01k   Angular Unit    DEG
        1.01l   Start Date      20141012
        1.01m   Start Time      00000000000300
        1.01n   End Date        20141013
        1.01o   End Time        00000000000120
        1.01p   Generation Count        00
        1.01q   Generation Date --------
        1.01r   Generation Time ----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 0);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNull(sensrb.getModule9());
        assertEquals(sensrb.getModule11().size(), 0);
    }

    @Test
    public void checkSituationalAwareness() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader
                        .getResourceAsStream("SENSRB/SENSRB_situational_awareness.txt")
                        .readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a   Sensor  SYERS2A
        1.01b   Sensor URI
        1.01c   Platform        U-2
        1.01d   Platform URI
        1.01e   Operational Domain      Airborne
        1.01f   Content Level   2
        1.01g   Geodetic System WGS84
        1.01h   Geodetic Type   G
        1.01i   Elevation Datum HAE
        1.01j   Length Unit     SI
        1.01k   Angular Unit    DEG
        1.01l   Start Date      20141012
        1.01m   Start Time      00000000000300
        1.01n   End Date        20141013
        1.01o   End Time        00000000000120
        1.01p   Generation Count        00
        1.01q   Generation Date --------
        1.01r   Generation Time ----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 2);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a   Detection       PAN
        1.02b   Row Detectors   00001024
        1.02c   Column Detectors        00000256
        1.02d   Row Metric      000000.3
        1.02e   Column Metric   000000.1
        1.02f   Focal Length    00000876
        1.02g   Row FOV --------
        1.02h   Column FOV      --------
        1.02i   Calibrated      N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNotNull(sensrb.getModule4());
        /*
        1.04b   Mode    015
        1.04c   Row Count       00002048
        1.04d   Column Count    00000256
        1.04e   Row Set 00002048
        1.04f   Column Set      00000256
        1.04g   Row Rate        000000.002
        1.04h   Column Rate     0000000.04
        1.04i   First Pixel Row 00000000
        1.04j   First Pixel Column      00000000
        1.04k   Transform Params        2
        1.04l   Transform Param 1       0000000002.4
        1.04m   Transform Param 2       0000000000.3
        */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Multi-Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 2);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNull(sensrb.getModule9());
        assertEquals(sensrb.getModule11().size(), 0);
    }

    @Test
    public void checkGeo() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes = classLoader.getResourceAsStream("SENSRB/SENSRB_geo.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a   Sensor  SYERS2A
        1.01b   Sensor URI
        1.01c   Platform        U-2
        1.01d   Platform URI
        1.01e   Operational Domain      Airborne
        1.01f   Content Level   4
        1.01g   Geodetic System WGS84
        1.01h   Geodetic Type   G
        1.01i   Elevation Datum HAE
        1.01j   Length Unit     SI
        1.01k   Angular Unit    DEG
        1.01l   Start Date      20141012
        1.01m   Start Time      00000000000300
        1.01n   End Date        20141013
        1.01o   End Time        00000000000120
        1.01p   Generation Count        00
        1.01q   Generation Date --------
        1.01r   Generation Time ----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 4);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a   Detection       PAN
        1.02b   Row Detectors   00001024
        1.02c   Column Detectors        00000256
        1.02d   Row Metric      000000.3
        1.02e   Column Metric   000000.1
        1.02f   Focal Length    00000876
        1.02g   Row FOV --------
        1.02h   Column FOV      --------
        1.02i   Calibrated      N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNotNull(sensrb.getModule4());
        /*
        1.04a   Method  Single Frame
        1.04b   Mode    015
        1.04c   Row Count       00002048
        1.04d   Column Count    00000256
        1.04e   Row Set 00002048
        1.04f   Column Set      00000256
        1.04g   Row Rate        000000.002
        1.04h   Column Rate     0000000.04
        1.04i   First Pixel Row 00000000
        1.04j   First Pixel Column      00000000
        1.04k   Transform Params        6
        1.04l   Transform Param 1       0000000002.4
        1.04m   Transform Param 2       0000000000.3
        1.04n   Transform Param 3       000000000002
        1.04o   Transform Param 4       -000004.3e-2
        1.04p   Transform Param 5       0000000000.4
        1.04q   Transform Param 6       000000000001
        */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Single Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 6);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertEquals(transformParams[2], 2.0);
        assertEquals(transformParams[3], -4.3e-2);
        assertEquals(transformParams[4], 0.4);
        assertEquals(transformParams[5], 1.0);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNotNull(sensrb.getModule7());
        /*
        1.07a   Sensor Angle Model      2
        1.07b   Sensor Angle 1  0000000004
        1.07c   Sensor Angle 2  000000005
        1.07d   Sensor Angle 3  -000000012
        1.07e   Platform Relative       N
        1.07f   Platform Heading        ---------
        1.07g   Platform Pitch  ---------
        1.07h   Platform Roll   ----------
        */
        assertEquals(sensrb.getModule7().getSensorAngleModel(), 2);
        assertEquals(sensrb.getModule7().getSensorAngle1(), 4.0);
        assertEquals(sensrb.getModule7().getSensorAngle2(), 5.0);
        assertEquals(sensrb.getModule7().getSensorAngle3(), -12.0);
        assertEquals(sensrb.getModule7().getPlatformRelative(), "N");
        assertEquals(sensrb.getModule7().getPlatformHeading(), "---------");
        assertEquals(sensrb.getModule7().getPlatformPitch(), "---------");
        assertEquals(sensrb.getModule7().getPlatformRoll(), "----------");
        assertNull(sensrb.getModule9());
        assertEquals(sensrb.getModule11().size(), 0);
    }

    @Test
    public void checkGeoPlus() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader.getResourceAsStream("SENSRB/SENSRB_geo_plus.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a   Sensor  SYERS2A
        1.01b   Sensor URI
        1.01c   Platform        U-2
        1.01d   Platform URI
        1.01e   Operational Domain      Airborne
        1.01f   Content Level   5
        1.01g   Geodetic System WGS84
        1.01h   Geodetic Type   G
        1.01i   Elevation Datum HAE
        1.01j   Length Unit     SI
        1.01k   Angular Unit    DEG
        1.01l   Start Date      20141012
        1.01m   Start Time      00000000000300
        1.01n   End Date        20141013
        1.01o   End Time        00000000000120
        1.01p   Generation Count        00
        1.01q   Generation Date --------
        1.01r   Generation Time ----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 5);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a   Detection       PAN
        1.02b   Row Detectors   00001024
        1.02c   Column Detectors        00000256
        1.02d   Row Metric      000000.3
        1.02e   Column Metric   000000.1
        1.02f   Focal Length    00000876
        1.02g   Row FOV --------
        1.02h   Column FOV      --------
        1.02i   Calibrated      N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNotNull(sensrb.getModule4());
        /*
        1.04a   Method  Multi-Frame
        1.04b   Mode    015
        1.04c   Row Count       00002048
        1.04d   Column Count    00000256
        1.04e   Row Set 00002048
        1.04f   Column Set      00000256
        1.04g   Row Rate        000000.002
        1.04h   Column Rate     0000000.04
        1.04i   First Pixel Row 00000000
        1.04j   First Pixel Column      00000000
        1.04k   Transform Params        2
        1.04l   Transform Param 1       0000000002.4
        1.04m   Transform Param 2       0000000000.3
                */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Multi-Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 2);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNotNull(sensrb.getModule9());
        /*
        1.09a   Attitude Q1     0.99312919
        1.09b   Attitude Q2     -0.1028514
        1.09c   Attitude Q3     -0.0392319
        1.09d   Attitude Q4     0.03970949
        */
        assertEquals(sensrb.getModule9().getAttitudeQ1(), 0.99312919);
        assertEquals(sensrb.getModule9().getAttitudeQ2(), -0.1028514);
        assertEquals(sensrb.getModule9().getAttitudeQ3(), -0.0392319);
        assertEquals(sensrb.getModule9().getAttitudeQ4(), 0.03970949);
        assertEquals(sensrb.getModule11().size(), 2);
        /*
        1.11    Point Sets      02
        1.11a.1 Point Set Type  Point of Interest
        1.11b.1 Point Count     003
        1.11c.1.1       Row     00000004
        1.11d.1.1       Column  00000007
        1.11e.1.1       Latitude        -0000034.3
        1.11f.1.1       Longitude       000000130.3
        1.11g.1.1       Elevation       000231
        1.11h.1.1       Range   --------
        1.11c.1.2       Row     00000987
        1.11d.1.2       Column  00000024
        1.11e.1.2       Latitude        -000034.31
        1.11f.1.2       Longitude       000000130.4
        1.11g.1.2       Elevation       000232
        1.11h.1.2       Range   --------
        1.11c.1.3       Row     00000290
        1.11d.1.3       Column  00000020
        1.11e.1.3       Latitude        -000000035
        1.11f.1.3       Longitude       00000129.09
        1.11g.1.3       Elevation       000023
        1.11h.1.3       Range   --------
        1.11a.2 Point Set Type  Image Center
        1.11b.2 Point Count     001
        1.11c.2.1       Row     00001023
        1.11d.2.1       Column  00000512
        1.11e.2.1       Latitude        -0000034.4
        1.11f.2.1       Longitude       000000130.4
        1.11g.2.1       Elevation       000235
        1.11h.2.1       Range   --------
        */
        PointSet pointSet0 = sensrb.getModule11().get(0);
        assertNotNull(pointSet0);
        assertEquals(pointSet0.getPointSetType().trim(), "Point of Interest");
        assertEquals(pointSet0.getPoints().size(), 3);
        assertEquals(pointSet0.getPoints().get(0).getRow(), 4);
        assertEquals(pointSet0.getPoints().get(0).getColumn(), 7);
        assertEquals(pointSet0.getPoints().get(0).getLatitude(), "-0000034.3");
        assertEquals(pointSet0.getPoints().get(0).getLongitude(), "000000130.3");
        assertEquals(pointSet0.getPoints().get(0).getElevation(), "000231");
        assertEquals(pointSet0.getPoints().get(0).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(1).getRow(), 987);
        assertEquals(pointSet0.getPoints().get(1).getColumn(), 24);
        assertEquals(pointSet0.getPoints().get(1).getLatitude(), "-000034.31");
        assertEquals(pointSet0.getPoints().get(1).getLongitude(), "000000130.4");
        assertEquals(pointSet0.getPoints().get(1).getElevation(), "000232");
        assertEquals(pointSet0.getPoints().get(1).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(2).getRow(), 290);
        assertEquals(pointSet0.getPoints().get(2).getColumn(), 20);
        assertEquals(pointSet0.getPoints().get(2).getLatitude(), "-000000035");
        assertEquals(pointSet0.getPoints().get(2).getLongitude(), "00000129.09");
        assertEquals(pointSet0.getPoints().get(2).getElevation(), "000023");
        assertEquals(pointSet0.getPoints().get(2).getRange(), "--------");
        PointSet pointSet1 = sensrb.getModule11().get(1);
        assertNotNull(pointSet1);
        assertEquals(pointSet1.getPointSetType().trim(), "Image Center");
        assertEquals(pointSet1.getPoints().size(), 1);
        assertEquals(pointSet1.getPoints().get(0).getRow(), 1023);
        assertEquals(pointSet1.getPoints().get(0).getColumn(), 512);
        assertEquals(pointSet1.getPoints().get(0).getLatitude(), "-0000034.4");
        assertEquals(pointSet1.getPoints().get(0).getLongitude(), "000000130.4");
        assertEquals(pointSet1.getPoints().get(0).getElevation(), "000235");
        assertEquals(pointSet1.getPoints().get(0).getRange(), "--------");
    }

    @Test
    public void checkAccurate() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader.getResourceAsStream("SENSRB/SENSRB_accurate.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a   Sensor  BuckEye
        1.01b   Sensor URI
        1.01c   Platform        C-12 King Air
        1.01d   Platform URI
        1.01e   Operational Domain      Airborne
        1.01f   Content Level   8
        1.01g   Geodetic System WGS84
        1.01h   Geodetic Type   G
        1.01i   Elevation Datum HAE
        1.01j   Length Unit     SI
        1.01k   Angular Unit    DEG
        1.01l   Start Date      20141012
        1.01m   Start Time      00000000000300
        1.01n   End Date        20141013
        1.01o   End Time        00000000000120
        1.01p   Generation Count        00
        1.01q   Generation Date --------
        1.01r   Generation Time ----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "BuckEye");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "C-12 King Air");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 8);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a   Detection       PAN
        1.02b   Row Detectors   00001024
        1.02c   Column Detectors        00000256
        1.02d   Row Metric      000000.3
        1.02e   Column Metric   000000.1
        1.02f   Focal Length    00000876
        1.02g   Row FOV --------
        1.02h   Column FOV      --------
        1.02i   Calibrated      N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNotNull(sensrb.getModule3());
        /*
        1.03a   Calibration Unit        mm
        1.03b   Principal Point Offset X        000000298
        1.03c   Principal Point Offset Y        0000032.2
        1.03d   Radial Distort 1        ------------
        1.03e   Radial Distort 2        ------------
        1.03f   Radial Distort 3        ------------
        1.03g   Radial Distort Limit    ---------
        1.03h   Decent Distort 1        ------------
        1.03i   Decent Distort 2        ------------
        1.03j   Affinity Distort 1      000000000005
        1.03k   Affinity Distort 2      000000000321
        1.03l   Calibration Date        20131001
        */
        assertEquals(sensrb.getModule3().getCalibrationUnit(), "mm");
        assertEquals(sensrb.getModule3().getPrincipalPointOffsetX(), "000000298");
        assertEquals(sensrb.getModule3().getPrincipalPointOffsetY(), "0000032.2");
        assertEquals(sensrb.getModule3().getRadialDistortion1(), "------------");
        assertEquals(sensrb.getModule3().getRadialDistortion2(), "------------");
        assertEquals(sensrb.getModule3().getRadialDistortion3(), "------------");
        assertEquals(sensrb.getModule3().getRadialDistortLimit(), "---------");
        assertEquals(sensrb.getModule3().getDecentDistort1(), "------------");
        assertEquals(sensrb.getModule3().getDecentDistort2(), "------------");
        assertEquals(sensrb.getModule3().getAffinityDistort1(), "000000000005");
        assertEquals(sensrb.getModule3().getAffinityDistort2(), "000000000321");
        assertEquals(sensrb.getModule3().getCalibrationDate(), "20131001");
        assertNotNull(sensrb.getModule4());
        /*
        1.04a   Method  Single Frame
        1.04b   Mode    015
        1.04c   Row Count       00002048
        1.04d   Column Count    00000256
        1.04e   Row Set 00002048
        1.04f   Column Set      00000256
        1.04g   Row Rate        000000.002
        1.04h   Column Rate     0000000.04
        1.04i   First Pixel Row 00000000
        1.04j   First Pixel Column      00000000
        1.04k   Transform Params        6
        1.04l   Transform Param 1       0000000002.4
        1.04m   Transform Param 2       0000000000.3
        1.04n   Transform Param 3       000000000002
        1.04o   Transform Param 4       -000004.3e-2
        1.04p   Transform Param 5       0000000000.4
        1.04q   Transform Param 6       000000000001
                        */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Single Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 6);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertEquals(transformParams[2], 2.0);
        assertEquals(transformParams[3], -4.3e-2);
        assertEquals(transformParams[4], 0.4);
        assertEquals(transformParams[5], 1.0);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNotNull(sensrb.getModule8());
        /*
        1.08a   ICX North       0000000001
        1.08b   ICX East        0000000000
        1.08c   ICX Down        0000000000
        1.08d   ICY North       0000000000
        1.08e   ICY East        0000000001
        1.08f   ICY Down        0000000000
        1.08g   ICZ North       0000000000
        1.08h   ICZ East        0000000000
        1.08i   ICZ Down        0000000001
        */
        assertEquals(sensrb.getModule8().getIcxNorthOrX(), 1.0);
        assertEquals(sensrb.getModule8().getIcxEastOrY(), 0.0);
        assertEquals(sensrb.getModule8().getIcxDownOrZ(), 0.0);
        assertEquals(sensrb.getModule8().getIcyNorthOrX(), 0.0);
        assertEquals(sensrb.getModule8().getIcyEastOrY(), 1.0);
        assertEquals(sensrb.getModule8().getIcyDownOrZ(), 0.0);
        assertEquals(sensrb.getModule8().getIczNorthOrX(), 0.0);
        assertEquals(sensrb.getModule8().getIczEastOrY(), 0.0);
        assertEquals(sensrb.getModule8().getIczDownOrZ(), 1.0);
        assertNull(sensrb.getModule9());
        assertNotNull(sensrb.getModule10());
        /*
        1.10a   Velocity North  000000012
        1.10b   Velocity East   0000134.5
        1.10c   Velocity Down   -00000002
        */
        assertEquals(sensrb.getModule10().getVelocityNorthOrX(), 12.0);
        assertEquals(sensrb.getModule10().getVelocityEastOrY(), 134.5);
        assertEquals(sensrb.getModule10().getVelocityDownOrZ(), -2.0);
        assertEquals(sensrb.getModule11().size(), 1);
        /*
        1.11    Point Sets      01
        1.11a.1 Point Set Type  Image Center
        1.11b.1 Point Count     001
        1.11c.1.1       Row     00000232
        1.11d.1.1       Column  00000987
        1.11e.1.1       Latitude        -0000034.3
        1.11f.1.1       Longitude       000000123.4
        1.11g.1.1       Elevation       ------
        1.11h.1.1       Range   00001349
        */
        PointSet pointSet0 = sensrb.getModule11().get(0);
        assertNotNull(pointSet0);
        assertEquals(pointSet0.getPointSetType().trim(), "Image Center");
        assertEquals(pointSet0.getPoints().size(), 1);
        assertEquals(pointSet0.getPoints().get(0).getRow(), 232);
        assertEquals(pointSet0.getPoints().get(0).getColumn(), 987);
        assertEquals(pointSet0.getPoints().get(0).getLatitude(), "-0000034.3");
        assertEquals(pointSet0.getPoints().get(0).getLongitude(), "000000123.4");
        assertEquals(pointSet0.getPoints().get(0).getElevation(), "------");
        assertEquals(pointSet0.getPoints().get(0).getRange(), "00001349");
        assertEquals(sensrb.getModule14().size(), 2);
        /*
        1.14    Uncertainties   002
        1.14a.1 Uncertainty First Type  02d
        1.14b.1 Uncertainty Second Type -----------
        1.14c.1 Uncertainty Value       00000454.3
        1.14a.2 Uncertainty First Type  02e
        1.14b.2 Uncertainty Second Type 02h
        1.14c.2 Uncertainty Value       00000000.2
        */
        Uncertainty uncertainty0 = sensrb.getModule14().get(0);
        assertNotNull(uncertainty0);
        assertEquals(uncertainty0.getFirstType().trim(), "02d");
        assertEquals(uncertainty0.getSecondType().trim(), "-----------");
        assertEquals(uncertainty0.getValue(), 454.3);
        Uncertainty uncertainty1 = sensrb.getModule14().get(1);
        assertNotNull(uncertainty1);
        assertEquals(uncertainty1.getFirstType().trim(), "02e");
        assertEquals(uncertainty1.getSecondType().trim(), "02h");
        assertEquals(uncertainty1.getValue(), 0.2);
    }

    @Test
    public void checkTimestamped9() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader.getResourceAsStream("SENSRB/SENSRB_timestamped9.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a	Sensor	SYERS2A
        1.01b	Sensor URI
        1.01c	Platform	U-2
        1.01d	Platform URI
        1.01e	Operational Domain	Airborne
        1.01f	Content Level	5
        1.01g	Geodetic System	WGS84
        1.01h	Geodetic Type	G
        1.01i	Elevation Datum	HAE
        1.01j	Length Unit	SI
        1.01k	Angular Unit	DEG
        1.01l	Start Date	20141012
        1.01m	Start Time	00000000000300
        1.01n	End Date	20141013
        1.01o	End Time	00000000000120
        1.01p	Generation Count	00
        1.01q	Generation Date	--------
        1.01r	Generation Time	----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 5);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a	Detection	PAN
        1.02b	Row Detectors	00001024
        1.02c	Column Detectors	00000256
        1.02d	Row Metric	000000.3
        1.02e	Column Metric	000000.1
        1.02f	Focal Length	00000876
        1.02g	Row FOV	--------
        1.02h	Column FOV	--------
        1.02i	Calibrated	N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNull(sensrb.getModule3());
        assertNotNull(sensrb.getModule4());
        /*
        1.04a	Method	Multi-Frame
        1.04b	Mode	015
        1.04c	Row Count	00002048
        1.04d	Column Count	00000256
        1.04e	Row Set	00002048
        1.04f	Column Set	00000256
        1.04g	Row Rate	000000.002
        1.04h	Column Rate	0000000.04
        1.04i	First Pixel Row	00000000
        1.04j	First Pixel Column	00000000
        1.04k	Transform Params	2
        1.04l	Transform Param 1	0000000002.4
        1.04m	Transform Param 2	0000000000.3
        */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Multi-Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 2);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNull(sensrb.getModule8());
        assertNotNull(sensrb.getModule9());
        /*
        1.09a	Attitude Q1	0.99312919
        1.09b	Attitude Q2	-0.1028514
        1.09c	Attitude Q3	-0.0392319
        1.09d	Attitude Q4	0.03970949
        */
        assertEquals(sensrb.getModule9().getAttitudeQ1(), 0.99312919);
        assertEquals(sensrb.getModule9().getAttitudeQ2(), -0.1028514);
        assertEquals(sensrb.getModule9().getAttitudeQ3(), -0.0392319);
        assertEquals(sensrb.getModule9().getAttitudeQ4(), 0.03970949);
        assertNull(sensrb.getModule10());
        assertEquals(sensrb.getModule11().size(), 2);
        /*
        1.11    Point Sets      02
        1.11a.1 Point Set Type  Point of Interest
        1.11b.1 Point Count     003
        1.11c.1.1       Row     00000004
        1.11d.1.1       Column  00000007
        1.11e.1.1       Latitude        -0000034.3
        1.11f.1.1       Longitude       000000130.3
        1.11g.1.1       Elevation       000231
        1.11h.1.1       Range   --------
        1.11c.1.2       Row     00000987
        1.11d.1.2       Column  00000024
        1.11e.1.2       Latitude        -000034.31
        1.11f.1.2       Longitude       000000130.4
        1.11g.1.2       Elevation       000232
        1.11h.1.2       Range   --------
        1.11c.1.3       Row     00000290
        1.11d.1.3       Column  00000020
        1.11e.1.3       Latitude        -000000035
        1.11f.1.3       Longitude       00000129.09
        1.11g.1.3       Elevation       000023
        1.11h.1.3       Range   --------
        1.11a.2 Point Set Type  Image Center
        1.11b.2 Point Count     001
        1.11c.2.1       Row     00001023
        1.11d.2.1       Column  00000512
        1.11e.2.1       Latitude        -0000034.4
        1.11f.2.1       Longitude       000000130.4
        1.11g.2.1       Elevation       000235
        1.11h.2.1       Range   --------
        */
        PointSet pointSet0 = sensrb.getModule11().get(0);
        assertNotNull(pointSet0);
        assertEquals(pointSet0.getPointSetType().trim(), "Point of Interest");
        assertEquals(pointSet0.getPoints().size(), 3);
        assertEquals(pointSet0.getPoints().get(0).getRow(), 4);
        assertEquals(pointSet0.getPoints().get(0).getColumn(), 7);
        assertEquals(pointSet0.getPoints().get(0).getLatitude(), "-0000034.3");
        assertEquals(pointSet0.getPoints().get(0).getLongitude(), "000000130.3");
        assertEquals(pointSet0.getPoints().get(0).getElevation(), "000231");
        assertEquals(pointSet0.getPoints().get(0).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(1).getRow(), 987);
        assertEquals(pointSet0.getPoints().get(1).getColumn(), 24);
        assertEquals(pointSet0.getPoints().get(1).getLatitude(), "-000034.31");
        assertEquals(pointSet0.getPoints().get(1).getLongitude(), "000000130.4");
        assertEquals(pointSet0.getPoints().get(1).getElevation(), "000232");
        assertEquals(pointSet0.getPoints().get(1).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(2).getRow(), 290);
        assertEquals(pointSet0.getPoints().get(2).getColumn(), 20);
        assertEquals(pointSet0.getPoints().get(2).getLatitude(), "-000000035");
        assertEquals(pointSet0.getPoints().get(2).getLongitude(), "00000129.09");
        assertEquals(pointSet0.getPoints().get(2).getElevation(), "000023");
        assertEquals(pointSet0.getPoints().get(2).getRange(), "--------");
        PointSet pointSet1 = sensrb.getModule11().get(1);
        assertNotNull(pointSet1);
        assertEquals(pointSet1.getPointSetType().trim(), "Image Center");
        assertEquals(pointSet1.getPoints().size(), 1);
        assertEquals(pointSet1.getPoints().get(0).getRow(), 1023);
        assertEquals(pointSet1.getPoints().get(0).getColumn(), 512);
        assertEquals(pointSet1.getPoints().get(0).getLatitude(), "-0000034.4");
        assertEquals(pointSet1.getPoints().get(0).getLongitude(), "000000130.4");
        assertEquals(pointSet1.getPoints().get(0).getElevation(), "000235");
        assertEquals(pointSet1.getPoints().get(0).getRange(), "--------");
        assertEquals(sensrb.getModule12().size(), 4);
        /*
        1.12	Time Stamps Sets	04
        1.12a.1	Time Stamp Type	09a
        1.12b.1	Time Stamp Count	0001
        1.12c.1.1	Time Stamp Time	0000000345.9
        1.12d.1.1	Attitude Q1	-000000001
        1.12a.2	Time Stamp Type	09b
        1.12b.2	Time Stamp Count	0001
        1.12c.2.1	Time Stamp Time	000000004000
        1.12d.2.1	Attitude Q2	00000000.4
        1.12a.3	Time Stamp Type	09c
        1.12b.3	Time Stamp Count	0001
        1.12c.3.1	Time Stamp Time	000000003000
        1.12d.3.1	Attitude Q3	00000000.5
        1.12a.4	Time Stamp Type	09d
        1.12b.4	Time Stamp Count	0001
        1.12c.4.1	Time Stamp Time	000000002987
        1.12d.4.1	Attitude Q4	00000000.9
        */
        TimeStampedSet timeStampedSet0 = sensrb.getModule12().get(0);
        assertNotNull(timeStampedSet0);
        assertEquals(timeStampedSet0.getType(), "09a");
        assertEquals(timeStampedSet0.getTimeStampedValues().size(), 1);
        assertNotNull(timeStampedSet0.getTimeStampedValues().get(0));
        assertEquals(timeStampedSet0.getTimeStampedValues().get(0).getTimeStamp(), 345.9);
        assertEquals(timeStampedSet0.getTimeStampedValues().get(0).getValue(), "-000000001");
        TimeStampedSet timeStampedSet1 = sensrb.getModule12().get(1);
        assertNotNull(timeStampedSet1);
        assertEquals(timeStampedSet1.getType(), "09b");
        assertEquals(timeStampedSet1.getTimeStampedValues().size(), 1);
        assertNotNull(timeStampedSet1.getTimeStampedValues().get(0));
        assertEquals(timeStampedSet1.getTimeStampedValues().get(0).getTimeStamp(), 4000.0);
        assertEquals(timeStampedSet1.getTimeStampedValues().get(0).getValue(), "00000000.4");
        TimeStampedSet timeStampedSet2 = sensrb.getModule12().get(2);
        assertNotNull(timeStampedSet2);
        assertEquals(timeStampedSet2.getType(), "09c");
        assertEquals(timeStampedSet2.getTimeStampedValues().size(), 1);
        assertNotNull(timeStampedSet2.getTimeStampedValues().get(0));
        assertEquals(timeStampedSet2.getTimeStampedValues().get(0).getTimeStamp(), 3000.0);
        assertEquals(timeStampedSet2.getTimeStampedValues().get(0).getValue(), "00000000.5");
        TimeStampedSet timeStampedSet3 = sensrb.getModule12().get(3);
        assertNotNull(timeStampedSet3);
        assertEquals(timeStampedSet3.getType(), "09d");
        assertEquals(timeStampedSet3.getTimeStampedValues().size(), 1);
        assertNotNull(timeStampedSet3.getTimeStampedValues().get(0));
        assertEquals(timeStampedSet3.getTimeStampedValues().get(0).getTimeStamp(), 2987.0);
        assertEquals(timeStampedSet3.getTimeStampedValues().get(0).getValue(), "00000000.9");
        assertEquals(sensrb.getModule14().size(), 0);
        assertEquals(sensrb.getModule15().size(), 1);
        /*
        1.15	Additional Parameters	001
        1.15a.1	Parameter Name	ASSOCIATED_DATA_MODULE
        1.15b.1	Parameter Size	002
        1.15c.1	Parameter Count	0000 (but that can't be right)
        1.15d.1.1	ASSOCIATED_DATA_MODULE Value
        */
        assertNotNull(sensrb.getModule15().get(0));
        assertEquals(sensrb.getModule15().get(0).getName(), "ASSOCIATED_DATA_MODULE   ");
        assertEquals(sensrb.getModule15().get(0).getValues().size(), 1);
        assertEquals(sensrb.getModule15().get(0).getValues().get(0), "  ");
    }

    @Test
    public void checkPixel9() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        byte[] allBytes =
                classLoader.getResourceAsStream("SENSRB/SENSRB_pixel9.txt").readAllBytes();
        SENSRBParser uut = new SENSRBParser();
        SENSRB sensrb = uut.parse("SENSRB", Arrays.copyOfRange(allBytes, 11, allBytes.length));
        assertNotNull(sensrb);
        assertNotNull(sensrb.getModule1());
        /*
        1.01a	Sensor	SYERS2A
        1.01b	Sensor URI
        1.01c	Platform	U-2
        1.01d	Platform URI
        1.01e	Operational Domain	Airborne
        1.01f	Content Level	5
        1.01g	Geodetic System	WGS84
        1.01h	Geodetic Type	G
        1.01i	Elevation Datum	HAE
        1.01j	Length Unit	SI
        1.01k	Angular Unit	DEG
        1.01l	Start Date	20141012
        1.01m	Start Time	00000000000300
        1.01n	End Date	20141013
        1.01o	End Time	00000000000120
        1.01p	Generation Count	00
        1.01q	Generation Date	--------
        1.01r	Generation Time	----------
        */
        assertEquals(sensrb.getModule1().getSensor().trim(), "SYERS2A");
        assertEquals(sensrb.getModule1().getSensorUri().trim(), "");
        assertEquals(sensrb.getModule1().getPlatform().trim(), "U-2");
        assertEquals(sensrb.getModule1().getPlatformUri().trim(), "");
        assertEquals(sensrb.getModule1().getOperationalDomain(), "Airborne  ");
        assertEquals(sensrb.getModule1().getContentLevel(), 5);
        assertEquals(sensrb.getModule1().getGeodeticSystem(), "WGS84");
        assertEquals(sensrb.getModule1().getGeodeticType(), "G");
        assertEquals(sensrb.getModule1().getElevationDatum(), "HAE");
        assertEquals(sensrb.getModule1().getLengthUnit(), "SI");
        assertEquals(sensrb.getModule1().getAngularUnit(), "DEG");
        assertEquals(sensrb.getModule1().getStartDate(), "20141012");
        assertEquals(sensrb.getModule1().getStartTime(), "00000000000300");
        assertEquals(sensrb.getModule1().getEndDate(), "20141013");
        assertEquals(sensrb.getModule1().getEndTime(), "00000000000120");
        assertEquals(sensrb.getModule1().getGenerationCount(), 0);
        assertEquals(sensrb.getModule1().getGenerationDate(), "--------");
        assertEquals(sensrb.getModule1().getGenerationTime(), "----------");
        assertNotNull(sensrb.getModule2());
        /*
        1.02a	Detection	PAN
        1.02b	Row Detectors	00001024
        1.02c	Column Detectors	00000256
        1.02d	Row Metric	000000.3
        1.02e	Column Metric	000000.1
        1.02f	Focal Length	00000876
        1.02g	Row FOV	--------
        1.02h	Column FOV	--------
        1.02i	Calibrated	N
        */
        assertEquals(sensrb.getModule2().getDetection().trim(), "PAN");
        assertEquals(sensrb.getModule2().getRowDetectors(), 1024);
        assertEquals(sensrb.getModule2().getColumnDetectors(), 256);
        assertEquals(sensrb.getModule2().getRowMetric(), 0.3);
        assertEquals(sensrb.getModule2().getColumnMetric(), 0.1);
        assertEquals(sensrb.getModule2().getFocalLength(), 876.0);
        assertEquals(sensrb.getModule2().getRowFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getColumnFieldOfView(), "--------");
        assertEquals(sensrb.getModule2().getCalibrated(), "N");
        assertNull(sensrb.getModule3());
        assertNotNull(sensrb.getModule4());
        /*
        1.04a	Method	Multi-Frame
        1.04b	Mode	015
        1.04c	Row Count	00002048
        1.04d	Column Count	00000256
        1.04e	Row Set	00002048
        1.04f	Column Set	00000256
        1.04g	Row Rate	000000.002
        1.04h	Column Rate	0000000.04
        1.04i	First Pixel Row	00000000
        1.04j	First Pixel Column	00000000
        1.04k	Transform Params	2
        1.04l	Transform Param 1	0000000002.4
        1.04m	Transform Param 2	0000000000.3
        */
        assertEquals(sensrb.getModule4().getMethod().trim(), "Multi-Frame");
        assertEquals(sensrb.getModule4().getMode(), "015");
        assertEquals(sensrb.getModule4().getRowCount(), 2048);
        assertEquals(sensrb.getModule4().getColumnCount(), 256);
        assertEquals(sensrb.getModule4().getRowSet(), 2048);
        assertEquals(sensrb.getModule4().getColumnSet(), 256);
        assertEquals(sensrb.getModule4().getRowRate(), 0.002);
        assertEquals(sensrb.getModule4().getColumnRate(), 0.04);
        assertEquals(sensrb.getModule4().getFirstPixelRow(), 0);
        assertEquals(sensrb.getModule4().getFirstPixelColumn(), 0);
        double[] transformParams = sensrb.getModule4().getTransformParams();
        assertEquals(transformParams.length, 2);
        assertEquals(transformParams[0], 2.4);
        assertEquals(transformParams[1], 0.3);
        assertNotNull(sensrb.getModule5());
        /*
        1.05a   Reference Time  000000000000
        1.05b   Reference Row   00000001
        1.05c   Reference Column        00000002
        */
        assertEquals(sensrb.getModule5().getReferenceTime(), 0);
        assertEquals(sensrb.getModule5().getReferenceRow(), 1);
        assertEquals(sensrb.getModule5().getReferenceColumn(), 2);
        assertNotNull(sensrb.getModule6());
        /*
        1.06a   Latitude        -00000034.3
        1.06b   Longitude       0000000140.2
        1.06c   Altitude        00000020000
        1.06d   Sensor X Offset 000003.2
        1.06e   Sensor Y Offset -0000001
        1.06f   Sensor Z Offset 00000002
        */
        assertEquals(sensrb.getModule6().getLatitude_or_x(), -34.3);
        assertEquals(sensrb.getModule6().getLongitude_or_y(), 140.2);
        assertEquals(sensrb.getModule6().getAltitude_or_z(), 20000.0);
        assertEquals(sensrb.getModule6().getSensorOffsetX(), 3.2);
        assertEquals(sensrb.getModule6().getSensorOffsetY(), -1.0);
        assertEquals(sensrb.getModule6().getSensorOffsetZ(), 2.0);
        assertNull(sensrb.getModule7());
        assertNull(sensrb.getModule8());
        assertNotNull(sensrb.getModule9());
        /*
        1.09a	Attitude Q1	0.99312919
        1.09b	Attitude Q2	-0.1028514
        1.09c	Attitude Q3	-0.0392319
        1.09d	Attitude Q4	0.03970949
        */
        assertEquals(sensrb.getModule9().getAttitudeQ1(), 0.99312919);
        assertEquals(sensrb.getModule9().getAttitudeQ2(), -0.1028514);
        assertEquals(sensrb.getModule9().getAttitudeQ3(), -0.0392319);
        assertEquals(sensrb.getModule9().getAttitudeQ4(), 0.03970949);
        assertNull(sensrb.getModule10());
        assertEquals(sensrb.getModule11().size(), 2);
        /*
        1.11	Point Sets	02
        1.11a.1	Point Set Type	Point of Interest
        1.11b.1	Point Count	003
        1.11c.1.1	Row	00000004
        1.11d.1.1	Column	00000007
        1.11e.1.1	Latitude	-0000034.3
        1.11f.1.1	Longitude	000000130.3
        1.11g.1.1	Elevation	000231
        1.11h.1.1	Range	--------
        1.11c.1.2	Row	00000987
        1.11d.1.2	Column	00000024
        1.11e.1.2	Latitude	-000034.31
        1.11f.1.2	Longitude	000000130.4
        1.11g.1.2	Elevation	000232
        1.11h.1.2	Range	--------
        1.11c.1.3	Row	00000290
        1.11d.1.3	Column	00000020
        1.11e.1.3	Latitude	-000000035
        1.11f.1.3	Longitude	00000129.09
        1.11g.1.3	Elevation	000023
        1.11h.1.3	Range	--------
        1.11a.2	Point Set Type	Image Center
        1.11b.2	Point Count	001
        1.11c.2.1	Row	00001023
        1.11d.2.1	Column	00000512
        1.11e.2.1	Latitude	-0000034.4
        1.11f.2.1	Longitude	000000130.4
        1.11g.2.1	Elevation	000235
        1.11h.2.1	Range	--------
        */
        PointSet pointSet0 = sensrb.getModule11().get(0);
        assertNotNull(pointSet0);
        assertEquals(pointSet0.getPointSetType().trim(), "Point of Interest");
        assertEquals(pointSet0.getPoints().size(), 3);
        assertEquals(pointSet0.getPoints().get(0).getRow(), 4);
        assertEquals(pointSet0.getPoints().get(0).getColumn(), 7);
        assertEquals(pointSet0.getPoints().get(0).getLatitude(), "-0000034.3");
        assertEquals(pointSet0.getPoints().get(0).getLongitude(), "000000130.3");
        assertEquals(pointSet0.getPoints().get(0).getElevation(), "000231");
        assertEquals(pointSet0.getPoints().get(0).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(1).getRow(), 987);
        assertEquals(pointSet0.getPoints().get(1).getColumn(), 24);
        assertEquals(pointSet0.getPoints().get(1).getLatitude(), "-000034.31");
        assertEquals(pointSet0.getPoints().get(1).getLongitude(), "000000130.4");
        assertEquals(pointSet0.getPoints().get(1).getElevation(), "000232");
        assertEquals(pointSet0.getPoints().get(1).getRange(), "--------");
        assertEquals(pointSet0.getPoints().get(2).getRow(), 290);
        assertEquals(pointSet0.getPoints().get(2).getColumn(), 20);
        assertEquals(pointSet0.getPoints().get(2).getLatitude(), "-000000035");
        assertEquals(pointSet0.getPoints().get(2).getLongitude(), "00000129.09");
        assertEquals(pointSet0.getPoints().get(2).getElevation(), "000023");
        assertEquals(pointSet0.getPoints().get(2).getRange(), "--------");
        PointSet pointSet1 = sensrb.getModule11().get(1);
        assertNotNull(pointSet1);
        assertEquals(pointSet1.getPointSetType().trim(), "Image Center");
        assertEquals(pointSet1.getPoints().size(), 1);
        assertEquals(pointSet1.getPoints().get(0).getRow(), 1023);
        assertEquals(pointSet1.getPoints().get(0).getColumn(), 512);
        assertEquals(pointSet1.getPoints().get(0).getLatitude(), "-0000034.4");
        assertEquals(pointSet1.getPoints().get(0).getLongitude(), "000000130.4");
        assertEquals(pointSet1.getPoints().get(0).getElevation(), "000235");
        assertEquals(pointSet1.getPoints().get(0).getRange(), "--------");
        assertEquals(sensrb.getModule12().size(), 0);
        assertEquals(sensrb.getModule13().size(), 4);
        /*
        1.13	Pixel Reference Sets	04
        1.13a.1	Pixel Reference Type	09a
        1.13b.1	Pixel Reference Count	0001
        1.13c.1.1	Pixel Reference Row	00000020
        1.13d.1.1	Pixel Reference Column	00000030
        1.13e.1.1	Attitude Q1	-000000001
        1.13a.2	Pixel Reference Type	09b
        1.13b.2	Pixel Reference Count	0002
        1.13c.2.1	Pixel Reference Row	00000040
        1.13d.2.1	Pixel Reference Column	00000050
        1.13e.2.1	Attitude Q2	00000000.5
        1.13c.2.2	Pixel Reference Row	00000060
        1.13d.2.2	Pixel Reference Column	00000070
        1.13e.2.2	Attitude Q2	00000000.7
        1.13a.3	Pixel Reference Type	09c
        1.13b.3	Pixel Reference Count	0001
        1.13c.3.1	Pixel Reference Row	00000070
        1.13d.3.1	Pixel Reference Column	00000080
        1.13e.3.1	Attitude Q3	-0000000.2
        1.13a.4	Pixel Reference Type	09d
        1.13b.4	Pixel Reference Count	0001
        1.13c.4.1	Pixel Reference Row	00000090
        1.13d.4.1	Pixel Reference Column	00000120
        1.13e.4.1	Attitude Q4	00000000.3
        */
        assertNotNull(sensrb.getModule13().get(0));
        assertEquals(sensrb.getModule13().get(0).getType(), "09a");
        assertEquals(sensrb.getModule13().get(0).getValues().size(), 1);
        assertNotNull(sensrb.getModule13().get(0).getValues().get(0));
        assertEquals(sensrb.getModule13().get(0).getValues().get(0).getRow(), 20);
        assertEquals(sensrb.getModule13().get(0).getValues().get(0).getColumn(), 30);
        assertEquals(sensrb.getModule13().get(0).getValues().get(0).getValue(), "-000000001");
        assertNotNull(sensrb.getModule13().get(1));
        assertEquals(sensrb.getModule13().get(1).getType(), "09b");
        assertEquals(sensrb.getModule13().get(1).getValues().size(), 2);
        assertNotNull(sensrb.getModule13().get(1).getValues().get(0));
        assertEquals(sensrb.getModule13().get(1).getValues().get(0).getRow(), 40);
        assertEquals(sensrb.getModule13().get(1).getValues().get(0).getColumn(), 50);
        assertEquals(sensrb.getModule13().get(1).getValues().get(0).getValue(), "00000000.5");
        assertNotNull(sensrb.getModule13().get(1).getValues().get(1));
        assertEquals(sensrb.getModule13().get(1).getValues().get(1).getRow(), 60);
        assertEquals(sensrb.getModule13().get(1).getValues().get(1).getColumn(), 70);
        assertEquals(sensrb.getModule13().get(1).getValues().get(1).getValue(), "00000000.7");
        assertNotNull(sensrb.getModule13().get(2));
        assertEquals(sensrb.getModule13().get(2).getType(), "09c");
        assertEquals(sensrb.getModule13().get(2).getValues().size(), 1);
        assertNotNull(sensrb.getModule13().get(2).getValues().get(0));
        assertEquals(sensrb.getModule13().get(2).getValues().get(0).getRow(), 70);
        assertEquals(sensrb.getModule13().get(2).getValues().get(0).getColumn(), 80);
        assertEquals(sensrb.getModule13().get(2).getValues().get(0).getValue(), "-0000000.2");
        assertNotNull(sensrb.getModule13().get(3));
        assertEquals(sensrb.getModule13().get(3).getType(), "09d");
        assertEquals(sensrb.getModule13().get(3).getValues().size(), 1);
        assertNotNull(sensrb.getModule13().get(3).getValues().get(0));
        assertEquals(sensrb.getModule13().get(3).getValues().get(0).getRow(), 90);
        assertEquals(sensrb.getModule13().get(3).getValues().get(0).getColumn(), 120);
        assertEquals(sensrb.getModule13().get(3).getValues().get(0).getValue(), "00000000.3");
        assertEquals(sensrb.getModule14().size(), 0);
        assertEquals(sensrb.getModule15().size(), 0);
    }
}
