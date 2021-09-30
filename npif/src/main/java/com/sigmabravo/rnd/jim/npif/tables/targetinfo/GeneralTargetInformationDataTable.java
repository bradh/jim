package com.sigmabravo.rnd.jim.npif.tables.targetinfo;

import com.sigmabravo.rnd.jim.npif.tables.DataTable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/*
	Targets can be collected on any particular mission, or for any number of operations and for any number of requesters. If the requester or the targets must be
	associated with a particular operation then target and requester IDs will be used.
	The Fields to be completed within the table will depend on the target type; line, area or point.
	File Addressing scheme is $0000 0xx0 where xx represents the target number.
	The value relates to the file address scheme in A.4.5
	Requester Data Table.
	The 32 bits have a one-to-one mapping with the
	Requester Index Number. If the bit is set then the
	Requester(s) require Target Information.
	Bit 0 maps to $0000 0040
	Bit 1 maps to $0000 0041
	Bit 2 maps to $0000 0042
	……………………………………………………………
	Bit 31 maps to $0000 005F
	11           Target Name                           Opt         32        Immed           ASCII        Target reference name.
	Definition of target types [ATP-47(A)]:
	Point:            A point target is a precisely defined point location and should be expressed to an accuracy of 100 metres. The planned sensor coverage should be
	not less than 100 metres radius around the defined location.
	Line:             A line search is a section of a Line of Communication (LOC) and is identified by precisely defined point locations for the start and end points, and by
	a description of the LOC.
	Area:     Area searches are tasked by identifying the corners of the required area coverage.
	Strip:    A strip point is a straight line between 2 defined point locations.
*/
public class GeneralTargetInformationDataTable extends DataTable {
    private int targetType;
    private int targetPriority;
    private String basicEncyclopaediaNumber;
    private String targetSecurityClassification;
    private ZonedDateTime requiredTimeOnTarget;
    private int requestedSensorType;
    private int requestedSensorResponseBand;
    private int requestedCollectionTechnique;
    private int numberOfLocations;
    private int requesterAddressIndex;
    private String targetName;

    public int getTargetType() {
        return targetType;
    }

    public String getTargetTypeAsText() {
        switch (getTargetType()) {
            case 0:
                return "POINT";
            case 1:
                return "LINE";
            case 2:
                return "AREA";
            case 3:
                return "STRIP";
            default:
                return "Unknown Target Type: (" + getTargetType() + ")";
        }
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public int getTargetPriority() {
        return targetPriority;
    }

    public String getTargetPriorityAsText() {
        switch (getTargetPriority()) {
            case 1:
                return "PRIORITY 1 (TOP PRIORITY)";
            case 2:
                return "PRIORITY 2";
            case 3:
                return "PRIORITY 3";
            default:
                return "UNKNOWN (" + getTargetPriority() + ")";
        }
    }

    public void setTargetPriority(int targetPriority) {
        this.targetPriority = targetPriority;
    }

    public String getBasicEncyclopaediaNumber() {
        return basicEncyclopaediaNumber;
    }

    public void setBasicEncyclopaediaNumber(String basicEncyclopaediaNumber) {
        this.basicEncyclopaediaNumber = basicEncyclopaediaNumber;
    }

    public String getTargetSecurityClassification() {
        return targetSecurityClassification;
    }

    public void setTargetSecurityClassification(String targetSecurityClassification) {
        this.targetSecurityClassification = targetSecurityClassification;
    }

    public ZonedDateTime getRequiredTimeOnTarget() {
        if (requiredTimeOnTarget == null) {
            return null;
        } else {
            return requiredTimeOnTarget.plusHours(0);
        }
    }

    public void setRequiredTimeOnTarget(ZonedDateTime requiredTimeOnTarget) {
        if (requiredTimeOnTarget == null) {
            this.requiredTimeOnTarget = null;
        } else {
            this.requiredTimeOnTarget = requiredTimeOnTarget.plusHours(0);
        }
    }

    public int getRequestedSensorType() {
        return requestedSensorType;
    }

    public String getRequestedSensorTypeAsText() {
        switch (getRequestedSensorType()) {
            case 0x01:
                return "FRAMING";
            case 0x02:
                return "LINESCAN";
            case 0x03:
                return "PUSHBROOM";
            case 0x04:
                return "PAN FRAME";
            case 0x5:
                return "STEP FRAME";
            case 0x10:
                return "SAR";
            case 0x11:
                return "MTI (other than 4607)";
            default:
                return "Unknown Requested Sensor Type (" + getRequestedSensorType() + ")";
        }
    }

    public void setRequestedSensorType(int requestedSensorType) {
        this.requestedSensorType = requestedSensorType;
    }

    public int getRequestedSensorResponseBand() {
        return requestedSensorResponseBand;
    }

    public String getRequestedSensorResponseBandAsText() {
        switch (getRequestedSensorResponseBand()) {
            case 0x01:
                return "VISUAL";
            case 0x02:
                return "NEAR IR";
            case 0x03:
                return "IR";
            case 0x04:
                return "DUAL BAND";
            case 0x10:
                return "MICROWAVE";
            case 0x11:
                return "mm WAVE";
            default:
                return "Unnown Requested Sensor Response Band ("
                        + getRequestedSensorResponseBand()
                        + ")";
        }
    }

    public void setRequestedSensorResponseBand(int requestedSensorResponseBand) {
        this.requestedSensorResponseBand = requestedSensorResponseBand;
    }

    public int getRequestedCollectionTechnique() {
        return requestedCollectionTechnique;
    }

    public String getRequestedCollectionTechniqueAsText() {
        switch (getRequestedCollectionTechnique()) {
            case 0x01:
                return "VERTICAL";
            case 0x02:
                return "FORWARD OBLIQUE";
            case 0x03:
                return "RIGHT OBLIQUE";
            case 0x04:
                return "LEFT OBLIQUE";
            case 0x05:
                return "BEST POSSIBLE";
            case 0x10:
                return "SWATH";
            case 0x11:
                return "SPOTLIGHT";
            case 0x12:
                return "RBGM";
            case 0x13:
                return "ENHANCED RBGM";
            case 0x14:
                return "DBSM";
            case 0x15:
                return "SAR OVERLAID WITH MTI";
            case 0x16:
                return "INSAR";
            case 0x17:
                return "POLSAR";
            case 0x18:
                return "INVSAR";
            case 0x19:
                return "SLAR";
            default:
                return "Unknown requested collection technique ("
                        + getRequestedCollectionTechnique()
                        + ")";
        }
    }

    public void setRequestedCollectionTechnique(int requestedCollectionTechnique) {
        this.requestedCollectionTechnique = requestedCollectionTechnique;
    }

    public int getNumberOfLocations() {
        return numberOfLocations;
    }

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    public int getRequesterAddressIndex() {
        return requesterAddressIndex;
    }

    public String getRequesterAddressIndexAsText() {
        List<String> requesters = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            int mask = 0x01 << i;
            if ((getRequesterAddressIndex() & mask) == mask) {
                requesters.add(String.format("%d", i));
            }
        }
        return String.join("; ", requesters);
    }

    public void setRequesterAddressIndex(int requesterAddressIndex) {
        this.requesterAddressIndex = requesterAddressIndex;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getTargetNumber() {
        return ((getHeader().getDataFileAddress() & 0x00000FF0) >> 4);
    }
}
