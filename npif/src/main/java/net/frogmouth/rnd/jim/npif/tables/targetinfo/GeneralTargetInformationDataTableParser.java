package net.frogmouth.rnd.jim.npif.tables.targetinfo;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class GeneralTargetInformationDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFF00F;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000000;

    public GeneralTargetInformationDataTableParser() {}

    @Override
    public GeneralTargetInformationDataTable parse(
            MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        GeneralTargetInformationDataTable dataTable = new GeneralTargetInformationDataTable();
        dataTable.setName("General Target Information");
        dataTable.setSourceFile("Target");
        dataTable.setTargetType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setTargetPriority(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setBasicEncyclopaediaNumber(this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setTargetSecurityClassification(this.readASCII(mappedByteBuffer, offset, 64));
        offset += 64;
        dataTable.setRequiredTimeOnTarget(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRequestedSensorType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRequestedSensorResponseBand(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRequestedCollectionTechnique(
                this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setNumberOfLocations(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRequesterAddressIndex(this.readUnsignedBinary(mappedByteBuffer, offset, 4));
        offset += 4;
        dataTable.setTargetName(this.readASCII(mappedByteBuffer, offset, 32));
        offset += 32;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.TARGET_DATA_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
