package com.sigmabravo.rnd.jim.nitf.tre.matesa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.sigmabravo.rnd.jim.nitf.tre.TRE;
import com.sigmabravo.rnd.jim.nitf.tre.TREParser;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;

public class HyperionTestCase {

    private static final byte[] TRE_WITH_HEADER = {
        0x4d, 0x41, 0x54, 0x45, 0x53, 0x41, 0x30, 0x30,
        0x38, 0x39, 0x37, 0x45, 0x4f, 0x2d, 0x31, 0x5f,
        0x48, 0x59, 0x50, 0x45, 0x52, 0x49, 0x4f, 0x4e,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x46, 0x54, 0x49,
        0x54, 0x4c, 0x45, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30, 0x36,
        0x33, 0x30, 0x37, 0x41, 0x50, 0x52, 0x32, 0x30,
        0x30, 0x35, 0x5f, 0x48, 0x79, 0x70, 0x65, 0x72,
        0x69, 0x6f, 0x6e, 0x5f, 0x33, 0x33, 0x31, 0x34,
        0x30, 0x36, 0x4e, 0x30, 0x34, 0x34, 0x32, 0x30,
        0x30, 0x30, 0x45, 0x5f, 0x53, 0x57, 0x49, 0x52,
        0x31, 0x37, 0x32, 0x5f, 0x30, 0x30, 0x31, 0x5f,
        0x4c, 0x31, 0x52, 0x2d, 0x30, 0x31, 0x42, 0x2d,
        0x42, 0x49, 0x42, 0x2d, 0x47, 0x4c, 0x41, 0x53,
        0x30, 0x30, 0x30, 0x35, 0x52, 0x41, 0x44, 0x49,
        0x4f, 0x4d, 0x54, 0x52, 0x43, 0x5f, 0x43, 0x41,
        0x4c, 0x49, 0x42, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x30, 0x30, 0x30, 0x31,
        0x45, 0x4f, 0x2d, 0x31, 0x5f, 0x48, 0x59, 0x50,
        0x45, 0x52, 0x49, 0x4f, 0x4e, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x46, 0x49, 0x4c, 0x45, 0x4e, 0x41,
        0x4d, 0x45, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x30, 0x30, 0x32, 0x30, 0x48, 0x79,
        0x70, 0x47, 0x61, 0x69, 0x6e, 0x5f, 0x72, 0x65,
        0x76, 0x43, 0x2e, 0x64, 0x61, 0x74, 0x2e, 0x73,
        0x76, 0x66, 0x50, 0x41, 0x52, 0x45, 0x4e, 0x54,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x30, 0x30, 0x30, 0x31, 0x45, 0x4f,
        0x2d, 0x31, 0x5f, 0x48, 0x59, 0x50, 0x45, 0x52,
        0x49, 0x4f, 0x4e, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x46, 0x49, 0x4c, 0x45, 0x4e, 0x41, 0x4d, 0x45,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x30, 0x30, 0x33, 0x32, 0x45, 0x4f, 0x31, 0x32,
        0x30, 0x30, 0x35, 0x30, 0x39, 0x37, 0x5f, 0x30,
        0x32, 0x30, 0x44, 0x30, 0x32, 0x30, 0x43, 0x5f,
        0x72, 0x31, 0x5f, 0x57, 0x50, 0x53, 0x5f, 0x30,
        0x31, 0x2e, 0x4c, 0x30, 0x50, 0x52, 0x45, 0x5f,
        0x44, 0x41, 0x52, 0x4b, 0x43, 0x4f, 0x4c, 0x4c,
        0x45, 0x43, 0x54, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x30, 0x30, 0x30, 0x31,
        0x45, 0x4f, 0x2d, 0x31, 0x5f, 0x48, 0x59, 0x50,
        0x45, 0x52, 0x49, 0x4f, 0x4e, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x46, 0x49, 0x4c, 0x45, 0x4e, 0x41,
        0x4d, 0x45, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x30, 0x30, 0x33, 0x32, 0x45, 0x4f,
        0x31, 0x32, 0x30, 0x30, 0x35, 0x30, 0x39, 0x37,
        0x5f, 0x30, 0x32, 0x30, 0x41, 0x30, 0x32, 0x30,
        0x39, 0x5f, 0x72, 0x31, 0x5f, 0x57, 0x50, 0x53,
        0x5f, 0x30, 0x31, 0x2e, 0x4c, 0x30, 0x50, 0x4f,
        0x53, 0x54, 0x5f, 0x44, 0x41, 0x52, 0x4b, 0x43,
        0x4f, 0x4c, 0x4c, 0x45, 0x43, 0x54, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30,
        0x30, 0x31, 0x45, 0x4f, 0x2d, 0x31, 0x5f, 0x48,
        0x59, 0x50, 0x45, 0x52, 0x49, 0x4f, 0x4e, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x46, 0x49, 0x4c, 0x45,
        0x4e, 0x41, 0x4d, 0x45, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x30, 0x30, 0x33, 0x32,
        0x45, 0x4f, 0x31, 0x32, 0x30, 0x30, 0x35, 0x30,
        0x39, 0x37, 0x5f, 0x30, 0x32, 0x30, 0x46, 0x30,
        0x32, 0x30, 0x45, 0x5f, 0x72, 0x31, 0x5f, 0x57,
        0x50, 0x53, 0x5f, 0x30, 0x31, 0x2e, 0x4c, 0x30,
        0x50, 0x41, 0x52, 0x45, 0x4e, 0x54, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x30, 0x30, 0x30, 0x33, 0x45, 0x4f, 0x2d, 0x31,
        0x5f, 0x48, 0x59, 0x50, 0x45, 0x52, 0x49, 0x4f,
        0x4e, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x46, 0x49,
        0x4c, 0x45, 0x4e, 0x41, 0x4d, 0x45, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30,
        0x32, 0x36, 0x45, 0x4f, 0x31, 0x48, 0x31, 0x36,
        0x38, 0x30, 0x33, 0x37, 0x32, 0x30, 0x30, 0x35,
        0x30, 0x39, 0x37, 0x31, 0x31, 0x30, 0x50, 0x5a,
        0x2e, 0x4c, 0x31, 0x52, 0x45, 0x4f, 0x2d, 0x31,
        0x5f, 0x48, 0x59, 0x50, 0x45, 0x52, 0x49, 0x4f,
        0x4e, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x46, 0x49,
        0x4c, 0x45, 0x4e, 0x41, 0x4d, 0x45, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30,
        0x32, 0x36, 0x45, 0x4f, 0x31, 0x48, 0x31, 0x36,
        0x38, 0x30, 0x33, 0x37, 0x32, 0x30, 0x30, 0x35,
        0x30, 0x39, 0x37, 0x31, 0x31, 0x30, 0x50, 0x5a,
        0x2e, 0x41, 0x55, 0x58, 0x45, 0x4f, 0x2d, 0x31,
        0x5f, 0x48, 0x59, 0x50, 0x45, 0x52, 0x49, 0x4f,
        0x4e, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x46, 0x49,
        0x4c, 0x45, 0x4e, 0x41, 0x4d, 0x45, 0x20, 0x20,
        0x20, 0x20, 0x20, 0x20, 0x20, 0x20, 0x30, 0x30,
        0x32, 0x36, 0x45, 0x4f, 0x31, 0x48, 0x31, 0x36,
        0x38, 0x30, 0x33, 0x37, 0x32, 0x30, 0x30, 0x35,
        0x30, 0x39, 0x37, 0x31, 0x31, 0x30, 0x50, 0x5a,
        0x2e, 0x4d, 0x45, 0x54
    };

    public HyperionTestCase() {}

    @Test
    public void parseDirect() {
        MATESAParser parser = new MATESAParser();
        MATESA tre =
                parser.parse(
                        "MATESA", Arrays.copyOfRange(TRE_WITH_HEADER, 11, TRE_WITH_HEADER.length));
        validateHyperionMATESA(tre);
    }

    @Test
    public void parseViaParser() {
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(TRE_WITH_HEADER);
        assertEquals(tres.size(), 1);
        TRE tre = tres.get(0);
        assertTrue(tre instanceof MATESA);
        MATESA matesa = (MATESA) tre;
        validateHyperionMATESA(matesa);
    }

    private void validateHyperionMATESA(MATESA tre) {
        assertEquals(tre.getTag(), "MATESA");
        assertEquals(tre.getTreeItemLabel(), "MATESA");
        assertEquals(tre.getCur_source().trim(), "EO-1_HYPERION");
        assertEquals(tre.getCur_mate_type().trim(), "FTITLE");
        assertEquals(
                tre.getCur_file_id(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS");
        assertEquals(tre.getGroups().size(), 5);

        Group group1 = tre.getGroups().get(0);
        assertNotNull(group1);
        assertEquals(group1.getRelationship().trim(), "RADIOMTRC_CALIB");
        assertEquals(group1.getMates().size(), 1);
        Mate mate11 = group1.getMates().get(0);
        assertEquals(mate11.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate11.getMate_type().trim(), "FILENAME");
        assertEquals(mate11.getMate_id().trim(), "HypGain_revC.dat.svf");
        assertEquals(group1.getTreeItemLabel(), "Group: RADIOMTRC_CALIB");

        Group group2 = tre.getGroups().get(1);
        assertNotNull(group2);
        assertEquals(group2.getRelationship().trim(), "PARENT");
        assertEquals(group2.getMates().size(), 1);
        Mate mate21 = group2.getMates().get(0);
        assertEquals(mate21.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate21.getMate_type().trim(), "FILENAME");
        assertEquals(mate21.getMate_id().trim(), "EO12005097_020D020C_r1_WPS_01.L0");
        assertEquals(group2.getTreeItemLabel(), "Group: PARENT");

        Group group3 = tre.getGroups().get(2);
        assertNotNull(group3);
        assertEquals(group3.getRelationship().trim(), "PRE_DARKCOLLECT");
        assertEquals(group3.getMates().size(), 1);
        Mate mate31 = group3.getMates().get(0);
        assertEquals(mate31.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate31.getMate_type().trim(), "FILENAME");
        assertEquals(mate31.getMate_id().trim(), "EO12005097_020A0209_r1_WPS_01.L0");
        assertEquals(group3.getTreeItemLabel(), "Group: PRE_DARKCOLLECT");

        Group group4 = tre.getGroups().get(3);
        assertNotNull(group4);
        assertEquals(group4.getRelationship().trim(), "POST_DARKCOLLECT");
        assertEquals(group4.getMates().size(), 1);
        Mate mate41 = group4.getMates().get(0);
        assertEquals(mate41.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate41.getMate_type().trim(), "FILENAME");
        assertEquals(mate41.getMate_id().trim(), "EO12005097_020F020E_r1_WPS_01.L0");
        assertEquals(group4.getTreeItemLabel(), "Group: POST_DARKCOLLECT");

        Group group5 = tre.getGroups().get(4);
        assertNotNull(group5);
        assertEquals(group5.getRelationship().trim(), "PARENT");
        assertEquals(group5.getMates().size(), 3);
        Mate mate51 = group5.getMates().get(0);
        assertEquals(mate51.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate51.getMate_type().trim(), "FILENAME");
        assertEquals(mate51.getMate_id().trim(), "EO1H1680372005097110PZ.L1R");
        Mate mate52 = group5.getMates().get(1);
        assertEquals(mate52.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate52.getMate_type().trim(), "FILENAME");
        assertEquals(mate52.getMate_id().trim(), "EO1H1680372005097110PZ.AUX");
        Mate mate53 = group5.getMates().get(2);
        assertEquals(mate53.getSource().trim(), "EO-1_HYPERION");
        assertEquals(mate53.getMate_type().trim(), "FILENAME");
        assertEquals(mate53.getMate_id().trim(), "EO1H1680372005097110PZ.MET");
        assertEquals(group2.getTreeItemLabel(), "Group: PARENT");
    }
}
