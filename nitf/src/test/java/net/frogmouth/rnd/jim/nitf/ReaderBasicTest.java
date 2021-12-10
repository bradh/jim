package net.frogmouth.rnd.jim.nitf;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.image.ImageSegmentHeader;
import net.frogmouth.rnd.jim.nitf.image.ImageSegmentInfo;
import net.frogmouth.rnd.jim.nitf.text.TextSegmentHeader;
import net.frogmouth.rnd.jim.nitf.tre.TRE;
import net.frogmouth.rnd.jim.nitf.tre.TREParser;
import net.frogmouth.rnd.jim.nitf.tre.csdida.CSDIDA;
import net.frogmouth.rnd.jim.nitf.tre.matesa.MATESA;
import org.testng.annotations.Test;

/** Basic tests for Reader. */
public class ReaderBasicTest extends TestSupport {

    public ReaderBasicTest() {}

    @Test
    public void bib() throws IOException {
        Reader reader = new Reader(getHyperionBIBTestData());
        assertTrue(reader.isNITF());
        assertEquals(reader.getCLEVEL(), 5);
        assertEquals(reader.getOSTAID(), "L3Harris  ");
        assertEquals(reader.getONAME(), "Dr. Barbara Eckstein    ");
        assertEquals(reader.getOPHONE(), "571-557-5526      ");
        assertEquals(reader.getFileDateTime(), "20200723125002");
        assertEquals(reader.getNumberOfImageSegments(), 9);
        assertEquals(reader.getNumberOfGraphicSegments(), 0);
        assertEquals(reader.getNumberOfDES(), 4);
        assertEquals(reader.getNumberOfTextSegments(), 1);
        verifyXHD(reader.getExtendedHeaderData());
        verifyUDHD(reader.getUserDefinedHeaderData());
        verifyImageSegment0(reader.getImageSegmentInfo(0));
        verifyImageSegment0Header(reader.getImageSegmentHeader(0));
        verifyImageSegment1(reader.getImageSegmentInfo(1));
        verifyImageSegment1Header(reader.getImageSegmentHeader(1));
        verifyImageSegment2(reader.getImageSegmentInfo(2));
        verifyImageSegment2Header(reader.getImageSegmentHeader(2));
        verifyImageSegment3(reader.getImageSegmentInfo(3));
        verifyImageSegment3Header(reader.getImageSegmentHeader(3));
        verifyImageSegment4(reader.getImageSegmentInfo(4));
        verifyImageSegment4Header(reader.getImageSegmentHeader(4));
        verifyImageSegment5(reader.getImageSegmentInfo(5));
        verifyImageSegment5Header(reader.getImageSegmentHeader(5));
        verifyImageSegment6(reader.getImageSegmentInfo(6));
        verifyImageSegment6Header(reader.getImageSegmentHeader(6));
        verifyImageSegment7(reader.getImageSegmentInfo(7));
        verifyImageSegment7Header(reader.getImageSegmentHeader(7));
        verifyImageSegment8(reader.getImageSegmentInfo(8));
        verifyImageSegment8Header(reader.getImageSegmentHeader(8));
        verifyTextSegment0Header(reader.getTextSegmentHeader(0));
        verifyTextSegment0Body(reader.getTextSegmentBody(0));
    }

    private void verifyImageSegment0(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment0Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment0Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "QUICK_LOOK");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "VIS     ");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 2);
        assertEquals(
                ish.getImageComments().get(0),
                "Created from Bands 134 (R), 80 (G), 23 (B) (2.1937, 1.6489, 1.07389 µm)         ");
        assertEquals(
                ish.getImageComments().get(1),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 8);
        assertEquals(ish.getNbpp(), 8);
        assertEquals(ish.getNrows(), 838);
        assertEquals(ish.getNcols(), 64);
        assertEquals(ish.getIdlvl(), 1);
        assertEquals(ish.getNbpc(), 1);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 64);
        assertEquals(ish.getNppbv(), 838);
    }

    private void verifyImageSegment1(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment1Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment1Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "HYPERSPECT");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "SWIR    ");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 1);
        assertEquals(
                ish.getImageComments().get(0),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 16);
        assertEquals(ish.getNbpp(), 16);
        assertEquals(ish.getNrows(), 3352);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 2);
        assertEquals(ish.getNbpc(), 4);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1024);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 8051);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: should be 10, and need to check the results properly
        assertEquals(tres.size(), 4);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment2(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment2Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment2Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PIX_LATLON");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "LOCG    ");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 0);
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 64);
        assertEquals(ish.getNbpp(), 64);
        assertEquals(ish.getNrows(), 3352);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 3);
        assertEquals(ish.getNbpc(), 4);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1024);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment3(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment3Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment3Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PIX_HEIGHT");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "DTEM    ");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 0);
        assertEquals(ish.getIsource(), "DTED0                                     ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 64);
        assertEquals(ish.getNbpp(), 64);
        assertEquals(ish.getNrows(), 3352);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 4);
        assertEquals(ish.getNbpc(), 4);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1024);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 685);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 1);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment4(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment4Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment4Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "BADPIXMAP ");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "PIXQUAL ");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 1);
        assertEquals(
                ish.getImageComments().get(0),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 3);
        assertEquals(ish.getNbpp(), 8);
        assertEquals(ish.getNrows(), 1);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 5);
        assertEquals(ish.getNbpc(), 1);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 142);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment5(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment5Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment5Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PMS_WAVLEN");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "SPECTRAD");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 1);
        assertEquals(
                ish.getImageComments().get(0),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 32);
        assertEquals(ish.getNbpp(), 32);
        assertEquals(ish.getNrows(), 1);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 6);
        assertEquals(ish.getNbpc(), 1);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 166);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment6(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment6Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment6Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PMS_FWHM  ");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "SPECTRAD");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 1);
        assertEquals(
                ish.getImageComments().get(0),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 32);
        assertEquals(ish.getNbpp(), 32);
        assertEquals(ish.getNrows(), 1);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 7);
        assertEquals(ish.getNbpc(), 1);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 166);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment7(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment7Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment7Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PMS_RDGAIN");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "SPECTRAD");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 1);
        assertEquals(
                ish.getImageComments().get(0),
                "Hyperion image courtesy of the U.S. Geological Survey                           ");
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 32);
        assertEquals(ish.getNbpp(), 32);
        assertEquals(ish.getNrows(), 1);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 8);
        assertEquals(ish.getNbpc(), 1);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 166);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyImageSegment8(ImageSegmentInfo imageSegmentInfo) {
        verifyImageSegment8Header(imageSegmentInfo.getImageSegmentHeader());
        // TODO: fix this
        // assertEquals(imageSegmentInfo.getImageBlocks().size(), 1);
    }

    private void verifyImageSegment8Header(ImageSegmentHeader ish) {
        assertEquals(ish.getIid1(), "PXMETRIC  ");
        assertEquals(
                ish.getIid2(),
                "07APR2005_Hyperion_331406N0442000E_SWIR172_001_L1R-01B-BIB-GLAS                 ");
        assertEquals(ish.getImageDateTime(), "20050407072410");
        assertEquals(ish.getIcat(), "VIEWILLM");
        assertEquals(ish.getIloc(), 0);
        assertEquals(ish.getImageComments().size(), 0);
        assertEquals(ish.getIsource(), "EO-1_HYPERION                             ");
        assertEquals(ish.getIc(), "NC");
        assertEquals(ish.getIalvl(), 0);
        assertEquals(ish.getAbpp(), 32);
        assertEquals(ish.getNbpp(), 32);
        assertEquals(ish.getNrows(), 3352);
        assertEquals(ish.getNcols(), 256);
        assertEquals(ish.getIdlvl(), 9);
        assertEquals(ish.getNbpc(), 4);
        assertEquals(ish.getNbpr(), 1);
        assertEquals(ish.getNppbh(), 256);
        assertEquals(ish.getNppbv(), 1024);
        byte[] xhd = ish.getExtendedHeaderData();
        assertEquals(xhd.length, 247);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(xhd);
        // TODO: need to implement more and check the results properly
        assertEquals(tres.size(), 0);
        byte[] uhd = ish.getUserDefinedHeaderData();
        assertEquals(uhd.length, 0);
    }

    private void verifyTextSegment0Header(TextSegmentHeader textSegmentHeader) {
        assertEquals(textSegmentHeader.getDateTime(), "20200723125002");
        // TODO: full check of header
    }

    private void verifyTextSegment0Body(String textSegmentBody) {
        assertEquals(textSegmentBody.length(), 1029);
        assertEquals(
                textSegmentBody,
                "TEXT_SEGMENT_TITLE: STANDARD CITATIONS: Standards used to create this dataset.\n\r\n"
                        + "STANDARD CITATION 1\n\r\n"
                        + "DOC_TITLE: National Imagery Transmission Format Version 2.1 Spectral NITF Implementation Profile: Specification of the data content, structure and metadata for passive electro-optical spectral data products, including Multispectral (MSI) and Hyperspectral Imaging (HSI) Systems \n\r\n"
                        + "DOC_VERSION: 1.0 \n\r\n"
                        + "DOC_DATE: 7 June 2019\n\r\n"
                        + "DOC_ID: NGA.STND.0072_1.0_SNIP\n\r\n"
                        + "DOC_TYPE: National Geospatial-Intelligence Agency (NGA) Standardization Document Implementation Profile \n\r\n"
                        + "DOC_URL: https://nsgreg.nga.mil/doc/view?i=4829 \n\r\n"
                        + "PRODUCT_CERT_DATE: 17 June 2019\n\r\n"
                        + "CUSTODIAN_ORG_1: Geospatial Intelligence Standards Working Group (GWG) NITFS Technical Board (NTB) \n\r\n"
                        + "CUSTODIAN_AGENCY: National Geospatial-Intelligence Agency (NGA)\n\r\n"
                        + "CUSTODIAN_EMAIL: NTBChair@nga.mil\n\r\n"
                        + "CUSTODIAN_ADDRESS: 7500 GEOINT Drive, Mail Stop N32, Springfield, Virginia 22150, USA\n\r\n"
                        + "CUSTODIAN_URL: http://www.gwg.nga.mil/ntb/\n\r\n"
                        + "CUSTODIAN_URL: https://nsgreg.nga.mil\r\n");
    }

    private void verifyXHD(byte[] extendedHeaderData) {
        assertEquals(extendedHeaderData.length, 8650);
        TREParser parser = new TREParser();
        List<TRE> tres = parser.parse(extendedHeaderData);
        // There are really 3 TREs, but CCINFA gets handled in a separate module
        assertEquals(tres.size(), 2);
        assertTrue(tres.get(0) instanceof CSDIDA);
        CSDIDA csdida = (CSDIDA) tres.get(0);
        net.frogmouth.rnd.jim.nitf.tre.csdida.HyperionTestCase.validateHyperionCSDIDA(csdida);
        assertTrue(tres.get(1) instanceof MATESA);
        MATESA matesa = (MATESA) tres.get(1);
        net.frogmouth.rnd.jim.nitf.tre.matesa.HyperionTestCase.validateHyperionMATESA(matesa);
    }

    private void verifyUDHD(byte[] userDefinedHeaderData) {
        assertEquals(userDefinedHeaderData.length, 0);
    }
}
