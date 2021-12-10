package net.frogmouth.rnd.jim.nitf.tre.csdida;

import static org.testng.Assert.*;

import java.util.Arrays;
import org.testng.annotations.Test;

public class HyperionTestCase {

    private static final byte[] TRE_WITH_HEADER = {
        0x43, 0x53, 0x44, 0x49,
        0x44, 0x41, 0x30, 0x30,
        0x30, 0x37, 0x30, 0x30,
        0x37, 0x41, 0x50, 0x52,
        0x32, 0x30, 0x30, 0x35,
        0x48, 0x50, 0x30, 0x31,
        0x30, 0x30, 0x30, 0x30,
        0x30, 0x48, 0x4f, 0x50,
        0x34, 0x30, 0x30, 0x30,
        0x30, 0x32, 0x30, 0x30,
        0x35, 0x30, 0x34, 0x30,
        0x37, 0x30, 0x37, 0x32,
        0x34, 0x31, 0x30, 0x32,
        0x30, 0x32, 0x30, 0x30,
        0x37, 0x32, 0x33, 0x31,
        0x32, 0x35, 0x30, 0x30,
        0x32, 0x30, 0x30, 0x30,
        0x31, 0x4e, 0x4e, 0x49,
        0x56, 0x41, 0x70, 0x79,
        0x20, 0x20, 0x20, 0x20,
        0x20
    };

    @Test
    public void parseDirect() {
        CSDIDAParser parser = new CSDIDAParser();
        CSDIDA tre =
                parser.parse(
                        "CSDIDA", Arrays.copyOfRange(TRE_WITH_HEADER, 11, TRE_WITH_HEADER.length));
        validateHyperionCSDIDA(tre);
    }

    public static void validateHyperionCSDIDA(CSDIDA tre) {
        assertEquals(tre.getTag(), "CSDIDA");
        assertEquals(tre.getTreeItemLabel(), "CSDIDA");
        assertEquals(tre.getDay(), 7);
        assertEquals(tre.getMonth(), "APR");
        assertEquals(tre.getYear(), 2005);
        assertEquals(tre.getPlatformCode(), "HP");
        assertEquals(tre.getVehicleId(), 1);
        assertEquals(tre.getPassNumber(), 0);
        assertEquals(tre.getOperationNumber(), 0);
        assertEquals(tre.getSensorId(), "HO");
        assertEquals(tre.getProductId(), "P4");
        assertEquals(tre.getTime(), "20050407072410");
        assertEquals(tre.getProcessTime(), "20200723125002");
        assertEquals(tre.getSoftwareVersionNumber(), "IVApy     ");
    }
}
