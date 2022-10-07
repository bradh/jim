package net.frogmouth.rnd.jim.nitf.tre.csdida;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

/** CSDIDA TRE Parser. */
public class CSDIDAParser extends AbstractTaggedRecordExtensionParser {

    private static final int DAY_LEN = 2;
    private static final int MONTH_LEN = 3;
    private static final int YEAR_LEN = 4;
    private static final int PLATFORM_CODE_LEN = 2;
    private static final int VEHICLE_ID_LEN = 2;
    private static final int PASS_LEN = 2;
    private static final int OPERATION_LEN = 3;
    private static final int SENSOR_ID_LEN = 2;
    private static final int PRODUCT_ID_LEN = 2;
    private static final int RESERVED1_LEN = 4;
    private static final int RESERVED2_LEN = 2 + 2 + 1 + 1;
    private static final int TIME_LEN = 14;
    private static final int PROCESS_TIME_LEN = 14;
    private static final int SOFTWARE_VERSION_NUMBER_LEN = 10;

    @Override
    public String getTag() {
        return "CSDIDA";
    }

    @Override
    public CSDIDA parse(String tag, byte[] bytes) {
        CSDIDA tre = new CSDIDA();
        int offset = 0;
        tre.setDay(readBCSNPI(bytes, offset, DAY_LEN));
        offset += DAY_LEN;
        tre.setMonth(readBCSA(bytes, offset, MONTH_LEN));
        offset += MONTH_LEN;
        tre.setYear(readBCSNPI(bytes, offset, YEAR_LEN));
        offset += YEAR_LEN;
        tre.setPlatformCode(readBCSA(bytes, offset, PLATFORM_CODE_LEN));
        offset += PLATFORM_CODE_LEN;
        tre.setVehicleId(readBCSNPI(bytes, offset, VEHICLE_ID_LEN));
        offset += VEHICLE_ID_LEN;
        tre.setPassNumber(readBCSNPI(bytes, offset, PASS_LEN));
        offset += PASS_LEN;
        tre.setOperationNumber(readBCSNPI(bytes, offset, OPERATION_LEN));
        offset += OPERATION_LEN;
        tre.setSensorId(readBCSA(bytes, offset, SENSOR_ID_LEN));
        offset += SENSOR_ID_LEN;
        tre.setProductId(readBCSA(bytes, offset, PRODUCT_ID_LEN));
        offset += PRODUCT_ID_LEN;
        offset += RESERVED1_LEN;
        tre.setTime(readBCSA(bytes, offset, TIME_LEN));
        offset += TIME_LEN;
        tre.setProcessTime(readBCSA(bytes, offset, PROCESS_TIME_LEN));
        offset += PROCESS_TIME_LEN;
        offset += RESERVED2_LEN;
        tre.setSoftwareVersionNumber(readBCSA(bytes, offset, SOFTWARE_VERSION_NUMBER_LEN));
        offset += SOFTWARE_VERSION_NUMBER_LEN;
        assert offset == bytes.length;
        return tre;
    }
}
