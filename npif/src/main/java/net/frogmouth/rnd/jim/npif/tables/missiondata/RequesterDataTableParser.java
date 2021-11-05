package net.frogmouth.rnd.jim.npif.tables.missiondata;

import java.nio.MappedByteBuffer;
import net.frogmouth.rnd.jim.npif.tables.DataTable;
import net.frogmouth.rnd.jim.npif.tables.DataTableParser;
import net.frogmouth.rnd.jim.npif.tables.Header;

public class RequesterDataTableParser extends DataTableParser {

    private static final int FILE_ADDRESS_MASK = 0xFFFFFFE0;
    private static final int FILE_ADDRESS_SUPPORTED = 0x00000040;

    public RequesterDataTableParser() {}

    @Override
    public DataTable parse(MappedByteBuffer mappedByteBuffer, int offset, Header header) {
        RequesterDataTable dataTable = new RequesterDataTable();
        dataTable.setName("Requester");
        dataTable.setSourceFile("Mission");
        dataTable.setReportMessageType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setMessageCommunicationsChannel(this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setSecondaryImageryDisseminationChannel(
                this.readASCII(mappedByteBuffer, offset, 16));
        offset += 16;
        dataTable.setLtoiv(this.readDTG(mappedByteBuffer, offset, 8));
        offset += 8;
        dataTable.setRequesterSerialNumber(this.readASCII(mappedByteBuffer, offset, 6));
        offset += 6;
        dataTable.setMissionPriority(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setRequesterAddress(this.readASCII(mappedByteBuffer, offset, 512));
        offset += 512;
        dataTable.setRequesterType(this.readUnsignedBinary(mappedByteBuffer, offset, 1));
        offset += 1;
        dataTable.setOperationCodeword(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        dataTable.setOperationPlanOriginatorAndNumber(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        dataTable.setOperationOptionNamePrimary(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        dataTable.setOperationOptionNameSecondary(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        dataTable.setExerciseNickname(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        dataTable.setMessageAdditionalIdentifier(readASCII(mappedByteBuffer, offset, 48));
        offset += 48;
        return dataTable;
    }

    @Override
    public boolean canHandle(final int sourceAddress, final int fileAddress) {
        return ((sourceAddress == Constants.MISSION_DATA_SOURCE_ADDRESS)
                && ((fileAddress & FILE_ADDRESS_MASK) == FILE_ADDRESS_SUPPORTED));
    }
}
