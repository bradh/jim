package net.frogmouth.rnd.jim.nitf.image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TREParser;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.utils.ReaderUtils;

/** Image Segment Header. */
public class ImageSegmentHeader {

    private static final int IM_OFFSET = 0;
    private static final int IM_LEN = 2;
    private static final int IID1_LEN = 10;
    private static final int TGTID_LEN = 17;
    private static final int IID2_LEN = 80;
    private static final int ISORCE_LEN = 42;
    private static final int NROWS_LEN = 8;
    private static final int NCOLS_LEN = 8;
    private static final int PVTYPE_LEN = 3;
    private static final int IREP_LEN = 8;
    private static final int ICAT_LEN = 8;
    private static final int ABPP_LEN = 2;
    private static final int PJUST_LEN = 1;
    private static final int ICORDS_LEN = 1;
    private static final int IGEOLO_LEN = 60;
    private static final int NICOM_LEN = 1;
    private static final int ICOM_LEN = 80;
    private static final int IC_LEN = 2;
    private static final int COMRAT_LEN = 4;
    private static final int NBANDS_LEN = 1;
    private static final int XBANDS_LEN = 5;
    private static final int IREPBAND_LEN = 2;
    private static final int ISUBCAT_LEN = 6;
    private static final int IFC_LEN = 1;
    private static final int IMFLT_LEN = 3;
    private static final int NLUTS_LEN = 1;
    private static final int ISYNC_LEN = 1;
    private static final int IMODE_LEN = 1;
    private static final int NBPR_LEN = 4;
    private static final int NBPC_LEN = 4;
    private static final int NPPBH_LEN = 4;
    private static final int NPPBV_LEN = 4;
    private static final int NBPP_LEN = 2;
    private static final int IDLVL_LEN = 3;
    private static final int IALVL_LEN = 3;
    private static final int ILOC_LEN = 10;
    private static final int IMAG_LEN = 4;
    private static final int UDIDL_LEN = 5;
    private static final int UDOFL_LEN = 3;
    private static final int IXSHDL_LEN = 5;
    private static final int IXSOFL_LEN = 3;
    // TODO: NBANDS onwards

    private final byte[] subheaderBytes;
    private final String iid1;
    private final String imageDateTime;
    private final String tgtid;
    private final String iid2;
    private final String isource;
    private final int nrows;
    private final int ncols;
    private final String pvtype;
    private final String irep;
    private final String icat;
    private final int abpp;
    private final String pjust;
    private final String icords;
    private String igeolo; // this needs to change
    private final List<String> imageComments = new ArrayList<>();
    private final String ic;
    private final String comrat;
    private final List<ImageHeaderBandInfo> bandInfos = new ArrayList<>();
    private final int isync;
    private final String imode;
    private final int nbpr;
    private final int nbpc;
    private final int nppbh;
    private final int nppbv;
    private final int nbpp;
    private final int idlvl;
    private final int ialvl;
    private final int iloc;
    private final double imag;

    private int udofl = 0;
    private int udidOffset = -1;
    private int udidLength = 0;
    private int ixsofl = 0;
    private int ixshdOffset = -1;
    private int ixshdLength = 0;

    public ImageSegmentHeader(byte[] subheaderBytes) {
        this.subheaderBytes = Arrays.copyOf(subheaderBytes, subheaderBytes.length);
        int offset = IM_OFFSET;
        String im = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IM_LEN);
        assert im.equals("IM");
        offset += IM_LEN;
        iid1 = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IID1_LEN);
        offset += IID1_LEN;
        imageDateTime =
                ReaderUtils.convertByteArrayToBCSA(
                        subheaderBytes, offset, ReaderUtils.DATE_TIME_LEN);
        offset += ReaderUtils.DATE_TIME_LEN;
        tgtid = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, TGTID_LEN);
        offset += TGTID_LEN;
        iid2 = ReaderUtils.convertByteArrayToECSA(subheaderBytes, offset, IID2_LEN);
        offset += IID2_LEN;
        offset += ReaderUtils.SECURITY_FIELDS_LEN;
        offset += ReaderUtils.ENCRYP_LEN;
        isource = ReaderUtils.convertByteArrayToECSA(subheaderBytes, offset, ISORCE_LEN);
        offset += ISORCE_LEN;
        nrows = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NROWS_LEN);
        offset += NROWS_LEN;
        ncols = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NCOLS_LEN);
        offset += NCOLS_LEN;
        pvtype = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, PVTYPE_LEN);
        offset += PVTYPE_LEN;
        irep = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IREP_LEN);
        offset += IREP_LEN;
        icat = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, ICAT_LEN);
        offset += ICAT_LEN;
        abpp = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, ABPP_LEN);
        offset += ABPP_LEN;
        pjust = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, PJUST_LEN);
        offset += PJUST_LEN;
        icords = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, ICORDS_LEN);
        offset += ICORDS_LEN;
        if (!icords.isBlank()) {
            igeolo = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IGEOLO_LEN);
            offset += IGEOLO_LEN;
        }
        int nicom = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NICOM_LEN);
        offset += NICOM_LEN;
        for (int i = 0; i < nicom; i++) {
            String icom = ReaderUtils.convertByteArrayToECSA(subheaderBytes, offset, ICOM_LEN);
            offset += ICOM_LEN;
            imageComments.add(icom);
        }
        ic = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IC_LEN);
        offset += IC_LEN;
        if (!(ic.equals("NC") || ic.equals("NM"))) {
            comrat = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, COMRAT_LEN);
            offset += COMRAT_LEN;
        } else {
            comrat = "";
        }
        int bands = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NBANDS_LEN);
        offset += NBANDS_LEN;
        if (bands == 0) {
            bands = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, XBANDS_LEN);
            offset += XBANDS_LEN;
        }
        for (int i = 0; i < bands; i++) {
            ImageHeaderBandInfo bandInfo = new ImageHeaderBandInfo();
            bandInfo.setIrepband(
                    ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IREPBAND_LEN));
            offset += IREPBAND_LEN;
            bandInfo.setIsubcat(
                    ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, ISUBCAT_LEN));
            offset += ISUBCAT_LEN;
            bandInfo.setIfc(ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IFC_LEN));
            offset += IFC_LEN;
            bandInfo.setImflt(
                    ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IMFLT_LEN));
            offset += IMFLT_LEN;
            offset += NLUTS_LEN;
            // TODO: handle LUTS
            this.bandInfos.add(bandInfo);
        }
        isync = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, ISYNC_LEN);
        offset += ISYNC_LEN;
        imode = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, offset, IMODE_LEN);
        offset += IMODE_LEN;
        nbpr = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NBPR_LEN);
        offset += NBPR_LEN;
        nbpc = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NBPC_LEN);
        offset += NBPC_LEN;
        nppbh = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NPPBH_LEN);
        offset += NPPBH_LEN;
        nppbv = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NPPBV_LEN);
        offset += NPPBV_LEN;
        nbpp = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, NBPP_LEN);
        offset += NBPP_LEN;
        idlvl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, IDLVL_LEN);
        offset += IDLVL_LEN;
        ialvl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, IALVL_LEN);
        offset += IALVL_LEN;
        iloc = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, ILOC_LEN);
        offset += ILOC_LEN;
        imag = ReaderUtils.convertByteArrayToBCS_NPI_Double(subheaderBytes, offset, IMAG_LEN);
        offset += IMAG_LEN;
        int udidl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, UDIDL_LEN);
        offset += UDIDL_LEN;
        if (udidl != 0) {
            udofl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, UDOFL_LEN);
            offset += UDOFL_LEN;
            udidOffset = offset;
            udidLength = udidl - UDOFL_LEN;
            offset += udidLength;
        }
        int ixshdl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, IXSHDL_LEN);
        offset += IXSHDL_LEN;
        if (ixshdl != 0) {
            ixsofl = ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, offset, IXSOFL_LEN);
            offset += IXSOFL_LEN;
            ixshdOffset = offset;
            ixshdLength = ixshdl - IXSOFL_LEN;
            // Would be a dead store: offset += ixshdLength;
        }
    }

    public byte[] getUserDefinedHeaderData() {
        if ((udidOffset <= 0) || (udidLength <= 0)) {
            return new byte[0];
        }
        return Arrays.copyOfRange(subheaderBytes, udidOffset, udidOffset + udidLength);
    }

    public byte[] getExtendedHeaderData() {
        if ((ixshdOffset <= 0) || (ixshdLength <= 0)) {
            return new byte[0];
        }
        return Arrays.copyOfRange(subheaderBytes, ixshdOffset, ixshdOffset + ixshdLength);
    }

    public List<TaggedRecordExtension> getTREs() {
        TREParser parser = new TREParser();
        List<TaggedRecordExtension> tres = new ArrayList<>();
        byte[] udhd = getUserDefinedHeaderData();
        if (udhd.length > 0) {
            tres.addAll(parser.parse(udhd));
        }
        byte[] xhd = getExtendedHeaderData();
        if (xhd.length > 0) {
            tres.addAll(parser.parse(xhd));
        }
        // TODO: overflow DES.
        return tres;
    }

    public String getIid1() {
        return iid1;
    }

    public String getImageDateTime() {
        return imageDateTime;
    }

    public String getTgtid() {
        return tgtid;
    }

    public String getIid2() {
        return iid2;
    }

    public String getIsource() {
        return isource;
    }

    public int getNrows() {
        return nrows;
    }

    public int getNcols() {
        return ncols;
    }

    public String getPvtype() {
        return pvtype;
    }

    public String getIrep() {
        return irep;
    }

    public String getIcat() {
        return icat;
    }

    public int getAbpp() {
        return abpp;
    }

    public String getPjust() {
        return pjust;
    }

    public String getIcords() {
        return icords;
    }

    public String getIgeolo() {
        return igeolo;
    }

    public List<String> getImageComments() {
        return new ArrayList<>(imageComments);
    }

    public String getIc() {
        return ic;
    }

    public String getComrat() {
        return comrat;
    }

    public List<ImageHeaderBandInfo> getBandInfo() {
        return new ArrayList<>(bandInfos);
    }

    public int getBandIndex(String c) {
        for (int i = 0; i < getBandInfo().size(); i++) {
            ImageHeaderBandInfo info = getBandInfo().get(i);
            if (info.getIrepband().trim().equals(c)) {
                return i;
            }
        }
        throw new RuntimeException("Bad IREPBAND look up request: " + c);
    }

    public int getIsync() {
        return isync;
    }

    public String getImode() {
        return imode;
    }

    public int getNbpr() {
        return nbpr;
    }

    public int getNbpc() {
        return nbpc;
    }

    public int getNppbh() {
        return nppbh;
    }

    public int getNppbv() {
        return nppbv;
    }

    public int getNbpp() {
        return nbpp;
    }

    public int getIdlvl() {
        return idlvl;
    }

    public int getIalvl() {
        return ialvl;
    }

    public int getIloc() {
        return iloc;
    }

    public double getImag() {
        return imag;
    }
}
