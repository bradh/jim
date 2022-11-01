package net.frogmouth.rnd.jim.nitf.image;

public class ImageConstants {

    /** Image header signature length in bytes. */
    public static final int IM_LEN = 2;

    /** IID1 field length in bytes. */
    public static final int IID1_LEN = 10;

    /** TGTID field length in bytes. */
    public static final int TGTID_LEN = 17;

    /** IID2 field length in bytes. */
    public static final int IID2_LEN = 80;

    /** ISORCE field length in bytes. */
    public static final int ISORCE_LEN = 42;

    /** NROWS field length in bytes. */
    public static final int NROWS_LEN = 8;

    /** NCOLS field length in bytes. */
    public static final int NCOLS_LEN = 8;

    /** PVTYPE field length in bytes. */
    public static final int PVTYPE_LEN = 3;

    /** IREP field length in bytes. */
    public static final int IREP_LEN = 8;

    /** ICAT field length in bytes. */
    public static final int ICAT_LEN = 8;

    /** ABPP field length in bytes. */
    public static final int ABPP_LEN = 2;

    /** PJUST field length in bytes. */
    public static final int PJUST_LEN = 1;

    /** ICORDS field length in bytes. */
    public static final int ICORDS_LEN = 1;

    /**
     * IGEOLO field length in bytes.
     *
     * <p>This field may be omitted if the ICORDS field is blank filled.
     */
    public static final int IGEOLO_LEN = 60;

    /** NICOM field length in bytes. */
    public static final int NICOM_LEN = 1;

    /**
     * ICOM field length in bytes.
     *
     * <p>This is the length of a single instance of the repeating field (which may be omitted).
     */
    public static final int ICOM_LEN = 80;

    /** IC field length in bytes. */
    public static final int IC_LEN = 2;

    /** COMRAT field length in bytes. */
    public static final int COMRAT_LEN = 4;

    /** NBANDS field length in bytes. */
    public static final int NBANDS_LEN = 1;

    /**
     * XBANDS field length in bytes.
     *
     * <p>This field is omitted unless NBANDS is set to {@code 0}.
     */
    public static final int XBANDS_LEN = 5;

    /** IREPBANDn field length in bytes. */
    public static final int IREPBAND_LEN = 2;

    /** ISUBCATn field length in bytes. */
    public static final int ISUBCAT_LEN = 6;

    /** IFCn field length in bytes. */
    public static final int IFC_LEN = 1;

    /** IMFLT field length in bytes. */
    public static final int IMFLT_LEN = 3;

    /** NLUTS field length in bytes. */
    public static final int NLUTS_LEN = 1;

    /** ISYNC field length in bytes. */
    public static final int ISYNC_LEN = 1;

    /** IMODE field length in bytes. */
    public static final int IMODE_LEN = 1;

    /** NBPR field length in bytes. */
    public static final int NBPR_LEN = 4;

    /** NBPC field length in bytes. */
    public static final int NBPC_LEN = 4;

    /** NPPBH field length in bytes. */
    public static final int NPPBH_LEN = 4;

    /** NPPBV field length in bytes. */
    public static final int NPPBV_LEN = 4;

    /** NBPP field length in bytes. */
    public static final int NBPP_LEN = 2;

    /** IDLVL field length in bytes. */
    public static final int IDLVL_LEN = 3;

    /** IALVL field length in bytes. */
    public static final int IALVL_LEN = 3;

    /**
     * ILOC field length in bytes.
     *
     * <p>This is the total length (5 bytes for rows, 5 bytes for columns).
     */
    public static final int ILOC_LEN = 10;

    /** IMAG field length in bytes. */
    public static final int IMAG_LEN = 4;

    /** UDIDL field length in bytes. */
    public static final int UDIDL_LEN = 5;

    /** UDOFL field length in bytes. */
    public static final int UDOFL_LEN = 3;

    /** IXSHDL field length in bytes. */
    public static final int IXSHDL_LEN = 5;

    /** UXSOFL field length in bytes. */
    public static final int IXSOFL_LEN = 3;
}
