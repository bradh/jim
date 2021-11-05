package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.time.ZonedDateTime;
import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	Each requester is assigned a unique requester index number. STANAG 7023 can handle both Information Requesters and Mission Requesters simultaneously. This
	table describes the Requester and the required Report type, it also identifies the communications channels to be used.
*/
public class RequesterDataTable extends DataTable {
    private int reportMessageType;
    private String messageCommunications;
    private String secondaryImagery;
    private ZonedDateTime ltoiv;
    private String requesterSerialNumber;
    private int missionPriority;
    private String requesterAddress;
    private int requesterType;
    private String operationCodeword;
    private String operationPlanOriginatorAndNumber;
    private String operationOptionNamePrimary;
    private String operationOptionNameSecondary;
    private String exerciseNickname;
    private String messageAdditionalIdentifier;

    public int getReportMessageType() {
        return reportMessageType;
    }

    public String getReportMessageTypeAsText() {
        switch (getReportMessageType()) {
            case 1:
                return "INFLIGHTREP";
            case 2:
                return "RECCEXREP";
            case 3:
                return "IPIR/SUPIR";
            case 4:
                return "IPIR/SUPIR (ADP)";
            case 5:
                return "RADARXREP";
            case 6:
                return "RECCEXREP (ADP)";
            default:
                return "UNKNOWN (" + getReportMessageType() + ")";
        }
    }

    public void setReportMessageType(int reportMessageType) {
        this.reportMessageType = reportMessageType;
    }

    public String getMessageCommunicationsChannel() {
        return messageCommunications;
    }

    public void setMessageCommunicationsChannel(String messageCommunications) {
        this.messageCommunications = messageCommunications;
    }

    public String getSecondaryImageryDisseminationChannel() {
        return secondaryImagery;
    }

    public void setSecondaryImageryDisseminationChannel(String secondaryImagery) {
        this.secondaryImagery = secondaryImagery;
    }

    public ZonedDateTime getLtoiv() {
        return ltoiv.plusHours(0);
    }

    public void setLtoiv(ZonedDateTime ltoiv) {
        this.ltoiv = ltoiv.plusHours(0);
    }

    public String getRequesterSerialNumber() {
        return requesterSerialNumber;
    }

    public void setRequesterSerialNumber(String requesterSerialNumber) {
        this.requesterSerialNumber = requesterSerialNumber;
    }

    public int getMissionPriority() {
        return missionPriority;
    }

    public String getMissionPriorityAsText() {
        switch (getMissionPriority()) {
            case 1:
                return "PRIORITY 1 (TOP PRIORITY)";
            case 2:
                return "PRIORITY 2";
            case 3:
                return "PRIORITY 3";
            default:
                return "UNKNOWN (" + getMissionPriority() + ")";
        }
    }

    public void setMissionPriority(int missionPriority) {
        this.missionPriority = missionPriority;
    }

    public String getRequesterAddress() {
        return requesterAddress;
    }

    public void setRequesterAddress(String requesterAddress) {
        this.requesterAddress = requesterAddress;
    }

    public int getRequesterType() {
        return requesterType;
    }

    public String getRequesterTypeAsText() {
        switch (getRequesterType()) {
            case 1:
                return "MISSION REQUESTER";
            case 2:
                return "INFORMATION REQUESTER";
            default:
                return "Unknown requester (" + getRequesterType() + ")";
        }
    }

    public void setRequesterType(int requesterType) {
        this.requesterType = requesterType;
    }

    public String getOperationCodeword() {
        return operationCodeword;
    }

    public void setOperationCodeword(String operationCodeword) {
        this.operationCodeword = operationCodeword;
    }

    public String getOperationPlanOriginatorAndNumber() {
        return operationPlanOriginatorAndNumber;
    }

    public void setOperationPlanOriginatorAndNumber(String operationPlanOriginatorAndNumber) {
        this.operationPlanOriginatorAndNumber = operationPlanOriginatorAndNumber;
    }

    public String getOperationOptionNamePrimary() {
        return operationOptionNamePrimary;
    }

    public void setOperationOptionNamePrimary(String operationOptionNamePrimary) {
        this.operationOptionNamePrimary = operationOptionNamePrimary;
    }

    public String getOperationOptionNameSecondary() {
        return operationOptionNameSecondary;
    }

    public void setOperationOptionNameSecondary(String operationOptionNameSecondary) {
        this.operationOptionNameSecondary = operationOptionNameSecondary;
    }

    public String getExerciseNickname() {
        return exerciseNickname;
    }

    public void setExerciseNickname(String exerciseNickname) {
        this.exerciseNickname = exerciseNickname;
    }

    public String getMessageAdditionalIdentifier() {
        return messageAdditionalIdentifier;
    }

    public void setMessageAdditionalIdentifier(String messageAdditionalIdentifier) {
        this.messageAdditionalIdentifier = messageAdditionalIdentifier;
    }

    public int getRequesterId() {
        return ((getHeader().getDataFileAddress() & 0x5F) - 0x40);
    }
}
