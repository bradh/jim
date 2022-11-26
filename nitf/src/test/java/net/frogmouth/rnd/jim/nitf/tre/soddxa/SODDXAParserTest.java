package net.frogmouth.rnd.jim.nitf.tre.soddxa;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

import java.io.IOException;
import java.util.UUID;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.SpaceObjectDescriptionData;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.SpaceObjectDescriptionDataParser;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.SpaceObjectType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog.SourceCatalogName;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection.Background;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection.LightingCondition;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit.OrbitCentre;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit.OrbitRegimeRegion;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit.OrbitRegimeType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.AttitudeActuatorType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.AttitudeControlMode;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.FlightOrientation;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.Modality;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.OrganisationRole;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.OrganisationType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.PieceType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.SatelliteCategory;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.StatusType;
import net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite.ThreatCategory;
import org.testng.annotations.Test;
import org.xmlunit.builder.Input;

public class SODDXAParserTest {

    public SODDXAParserTest() {}

    @Test
    public void test621() throws IOException {
        SpaceObjectDescriptionDataParser parser = new SpaceObjectDescriptionDataParser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("soddxa_621.xml")
                                .readAllBytes());
        SpaceObjectDescriptionData rootElement = parser.parse(xml);
        assertNotNull(rootElement);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }

    @Test
    public void test622() throws IOException {
        SpaceObjectDescriptionDataParser parser = new SpaceObjectDescriptionDataParser();
        String xml =
                new String(
                        getClass()
                                .getClassLoader()
                                .getResourceAsStream("soddxa_622.xml")
                                .readAllBytes());
        SpaceObjectDescriptionData rootElement = parser.parse(xml);
        assertNotNull(rootElement);
        assertNotNull(rootElement.getSecurityData());
        assertNotNull(rootElement.getSourceCatalog());
        assertEquals(
                rootElement.getSourceCatalog().getCatalogDate().toString(), "2021-11-22T16:36:40Z");
        assertEquals(rootElement.getSourceCatalog().getCatalogVersion(), "1.0");
        assertEquals(
                rootElement.getSourceCatalog().getCatalogName(), SourceCatalogName.SPACE_TRACK);
        assertEquals(rootElement.getAbsoluteVisualMagnitude(), 123.456);
        assertEquals(rootElement.getRadarCrossSection(), 13.761);
        assertEquals(rootElement.getLength(), 8.752);
        assertEquals(rootElement.getWidth(), 7.081);
        assertEquals(rootElement.getHeight(), 3.277);
        assertEquals(rootElement.getDiameter(), 3.218);
        assertEquals(rootElement.getMass(), 6762.962);
        assertEquals(
                rootElement.getSoUid(), UUID.fromString("24b1907e-6cac-4dfa-9958-a919f7999ed6"));
        assertEquals(rootElement.getSoType(), SpaceObjectType.SATELLITE);
        assertNotNull(rootElement.getSatelliteInformation());
        assertEquals(rootElement.getSatelliteInformation().getSatNo(), 987654321);
        assertEquals(rootElement.getSatelliteInformation().getTargetId(), "rIY4Vc");
        assertEquals(rootElement.getSatelliteInformation().getSatelliteName(), "Battlestar Falcon");
        assertEquals(rootElement.getSatelliteInformation().getPlatformId(), "BF_001");
        assertEquals(rootElement.getSatelliteInformation().getSatelliteCategories().size(), 1);
        assertEquals(
                rootElement.getSatelliteInformation().getSatelliteCategories().get(0),
                SatelliteCategory.INTER_PLANETARY_MISSION);
        assertEquals(
                rootElement.getSatelliteInformation().getSatelliteDescription(),
                "Mission to find New Earth in the Outer Rim");
        assertEquals(rootElement.getSatelliteInformation().getInternationalDesignators().size(), 2);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getInternationalDesignators()
                        .get(0)
                        .getPieceType(),
                PieceType.PLATFORM);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getInternationalDesignators()
                        .get(0)
                        .getValue(),
                "2021-123A");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getInternationalDesignators()
                        .get(1)
                        .getPieceType(),
                PieceType.PAYLOAD);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getInternationalDesignators()
                        .get(1)
                        .getValue(),
                "2021-123B");
        assertFalse(rootElement.getSatelliteInformation().isConstellation());
        assertFalse(rootElement.getSatelliteInformation().isCloselySpacedObject());
        assertEquals(
                rootElement.getSatelliteInformation().getThreatCategory(), ThreatCategory.FRIEND);
        assertNotNull(rootElement.getSatelliteInformation().getStatus());
        assertEquals(
                rootElement.getSatelliteInformation().getStatus().getStatusDate().toString(),
                "2021-06-24T16:36:40Z");
        assertEquals(rootElement.getSatelliteInformation().getStatus().getValue(), StatusType.AFMC);
        assertEquals(
                rootElement.getSatelliteInformation().getFlightOrientation(),
                FlightOrientation.EARTH_CENTER_STABLE);
        assertEquals(
                rootElement.getSatelliteInformation().getAttitudeControlMode(),
                AttitudeControlMode.THREE_AXIS);
        assertEquals(
                rootElement.getSatelliteInformation().getAttitudeActuatorType(),
                AttitudeActuatorType.ACTIVE_MAG_TORQUE);
        assertNotNull(rootElement.getSatelliteInformation().getManeuverData());
        assertEquals(
                rootElement.getSatelliteInformation().getManeuverData().isManoeuvrableVehicle(),
                true);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getManeuverData()
                        .getManoeuvreEpoch()
                        .toString(),
                "2021-07-18T16:36:40Z");
        assertEquals(
                rootElement.getSatelliteInformation().getManeuverData().getManoeuvrePurpose(),
                "Align weapons for planetary defense");
        assertNotNull(rootElement.getSatelliteInformation().getPayloads());
        assertEquals(rootElement.getSatelliteInformation().getPayloads().size(), 1);
        assertEquals(
                rootElement.getSatelliteInformation().getPayloads().get(0).getPayloadName(),
                "WormholeGenerator");
        assertEquals(
                rootElement.getSatelliteInformation().getPayloads().get(0).getPayloadId(), "WG42");
        assertEquals(
                rootElement.getSatelliteInformation().getPayloads().get(0).getPayloadDescription(),
                "Generate wormhole for inter-galaxy travel");
        assertEquals(
                rootElement.getSatelliteInformation().getPayloads().get(0).getSensors().size(), 1);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getPayloads()
                        .get(0)
                        .getSensors()
                        .get(0)
                        .getMissionId(),
                "WGM-SN9");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getPayloads()
                        .get(0)
                        .getSensors()
                        .get(0)
                        .getSensorName(),
                "Temporal Shift Detector");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getPayloads()
                        .get(0)
                        .getSensors()
                        .get(0)
                        .getSensorId(),
                "TSD99");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getPayloads()
                        .get(0)
                        .getSensors()
                        .get(0)
                        .getModality(),
                Modality.HSI);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getPayloads()
                        .get(0)
                        .getSensors()
                        .get(0)
                        .getSensorDescription(),
                "Detect temporal shift from spectral distribution of light coming through an open wormhole");
        assertNotNull(rootElement.getSatelliteInformation().getLaunch());
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getLaunch()
                        .getLaunchSiteId()
                        .getFacilityName(),
                "Andrews Spaceport");
        assertEquals(
                rootElement.getSatelliteInformation().getLaunch().getLaunchSiteId().getIdentifier(),
                "ntZxixqXAq1Gv43GFSG");
        assertEquals(
                rootElement.getSatelliteInformation().getLaunch().getLaunchOrg(), "US Space Force");
        assertEquals(
                rootElement.getSatelliteInformation().getLaunch().getLaunchDate().toString(),
                "2021-07-03T16:36:40Z");
        assertEquals(
                rootElement.getSatelliteInformation().getLaunch().getLaunchVehicle(),
                "Battlestar Falcon");
        assertNotNull(rootElement.getSatelliteInformation().getAffiliations());
        assertEquals(rootElement.getSatelliteInformation().getAffiliations().size(), 2);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getCountry()
                        .getCountryCode(),
                "ge:GENC:3:ed1:USA");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getCountry()
                        .getName(),
                "UNITED STATES");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getOrganisationName(),
                "US Space Force");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getOrganisationType(),
                OrganisationType.MILITARY);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getOrganisationRoles()
                        .size(),
                2);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getOrganisationRoles()
                        .get(0),
                OrganisationRole.OWNER);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(0)
                        .getOrganisationRoles()
                        .get(1),
                OrganisationRole.OPERATOR);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getCountry()
                        .getCountryCode(),
                "ge:GENC:3:ed1:GBR");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getCountry()
                        .getName(),
                "UNITED KINGDOM");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getOrganisationName(),
                "Royal Space Navy");
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getOrganisationType(),
                OrganisationType.MILITARY);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getOrganisationRoles()
                        .size(),
                1);
        assertEquals(
                rootElement
                        .getSatelliteInformation()
                        .getAffiliations()
                        .get(1)
                        .getOrganisationRoles()
                        .get(0),
                OrganisationRole.OWNER);
        assertEquals(rootElement.getCollectionData().getCollectionReqId(), "LeqxAjtNRuqC");
        assertEquals(rootElement.getCollectionData().getPriority(), 9);
        assertEquals(rootElement.getCollectionData().getRevNumber(), 9813892);
        assertEquals(rootElement.getCollectionData().getPassNumber(), 42);
        assertEquals(rootElement.getCollectionData().getBackground(), Background.DEEP_SPACE);
        assertEquals(rootElement.getCollectionData().getLightingConditions().size(), 1);
        assertEquals(
                rootElement.getCollectionData().getLightingConditions().get(0),
                LightingCondition.SUNLIT);
        assertEquals(rootElement.getCollectionData().getAppVisualMagnitude(), 201.99);
        assertEquals(rootElement.getCollectionData().getReflectance(), 72);
        assertEquals(rootElement.getCollectionData().getSnr(), -8.196);
        assertEquals(rootElement.getOrbitData().getEpochDate().toString(), "2021-09-06Z");
        assertEquals(
                rootElement.getOrbitData().getOrbitRegime().getType(),
                OrbitRegimeType.EARTH_ESCAPE_ORBIT);
        assertEquals(
                rootElement.getOrbitData().getOrbitRegime().getRegime(),
                OrbitRegimeRegion.INTERPLANETARY);
        assertEquals(rootElement.getOrbitData().getOrbitCentre(), OrbitCentre.EARTH);
        assertEquals(rootElement.getOrbitData().getMeanMotion(), 125.212);
        assertEquals(rootElement.getOrbitData().getOrbitalPeriod(), 11.97);
        assertEquals(rootElement.getOrbitData().getInclination(), 125.748);
        assertEquals(rootElement.getOrbitData().getEccentricity(), 0.664);
        assertEquals(rootElement.getOrbitData().getApogeeAltitude(), 37618.693);
        assertEquals(rootElement.getOrbitData().getPerigeeAltitude(), 51560.34);
        String serialisedXml = parser.serialise(rootElement);
        assertThat(
                Input.fromString(serialisedXml),
                isSimilarTo(Input.fromString(xml)).ignoreWhitespace());
    }
}
