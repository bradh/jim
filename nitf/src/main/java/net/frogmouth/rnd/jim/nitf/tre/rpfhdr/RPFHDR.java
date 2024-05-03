package net.frogmouth.rnd.jim.nitf.tre.rpfhdr;

import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class RPFHDR extends TaggedRecordExtension {
    private static final String TRE_TAG = "RPFHDR";
    private boolean littleEndianIndicator = false;
    private int headerSectionLength = 48;
    private String fileName;
    private int newReplacementUpdateIndicator = 0;
    private String governingSpecificationNumber;
    private String governingSpecificationDate;
    private String securityClassification;
    private String securityCountryInternationalCode;
    private String securityReleaseMarking;
    private long locationSectionLocation;

    public RPFHDR() {
        super(TRE_TAG);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    public boolean isLittleEndianIndicator() {
        return littleEndianIndicator;
    }

    public void setLittleEndianIndicator(boolean littleEndianIndicator) {
        this.littleEndianIndicator = littleEndianIndicator;
    }

    public int getHeaderSectionLength() {
        return headerSectionLength;
    }

    public void setHeaderSectionLength(int headerSectionLength) {
        this.headerSectionLength = headerSectionLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getNewReplacementUpdateIndicator() {
        return newReplacementUpdateIndicator;
    }

    public void setNewReplacementUpdateIndicator(int newReplacementUpdateIndicator) {
        this.newReplacementUpdateIndicator = newReplacementUpdateIndicator;
    }

    public String getGoverningSpecificationNumber() {
        return governingSpecificationNumber;
    }

    public void setGoverningSpecificationNumber(String governingSpecificationNumber) {
        this.governingSpecificationNumber = governingSpecificationNumber;
    }

    public String getGoverningSpecificationDate() {
        return governingSpecificationDate;
    }

    public void setGoverningSpecificationDate(String governingSpecificationDate) {
        this.governingSpecificationDate = governingSpecificationDate;
    }

    public String getSecurityClassification() {
        return securityClassification;
    }

    public void setSecurityClassification(String securityClassification) {
        this.securityClassification = securityClassification;
    }

    public String getSecurityCountryInternationalCode() {
        return securityCountryInternationalCode;
    }

    public void setSecurityCountryInternationalCode(String securityCountryInternationalCode) {
        this.securityCountryInternationalCode = securityCountryInternationalCode;
    }

    public String getSecurityReleaseMarking() {
        return securityReleaseMarking;
    }

    public void setSecurityReleaseMarking(String securityReleaseMarking) {
        this.securityReleaseMarking = securityReleaseMarking;
    }

    public long getLocationSectionLocation() {
        return locationSectionLocation;
    }

    public void setLocationSectionLocation(long locationSectionLocation) {
        this.locationSectionLocation = locationSectionLocation;
    }

    @Override
    public String toString() {
        return "RPFHDR{"
                + "littleEndianIndicator="
                + littleEndianIndicator
                + ", headerSectionLength="
                + headerSectionLength
                + ", fileName="
                + fileName
                + ", newReplacementUpdateIndicator="
                + newReplacementUpdateIndicator
                + ", governingSpecificationNumber="
                + governingSpecificationNumber
                + ", governingSpecificationDate="
                + governingSpecificationDate
                + ", securityClassification="
                + securityClassification
                + ", securityCountryInternationalCode="
                + securityCountryInternationalCode
                + ", securityReleaseMarking="
                + securityReleaseMarking
                + ", locationSectionLocation="
                + locationSectionLocation
                + '}';
    }
}
