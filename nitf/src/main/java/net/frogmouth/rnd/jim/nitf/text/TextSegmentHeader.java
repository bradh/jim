package net.frogmouth.rnd.jim.nitf.text;

import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TEXTID_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTALVL_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTFMT_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTITL_LEN;

import net.frogmouth.rnd.jim.nitf.utils.ReaderUtils;

public class TextSegmentHeader {

    private static final int TE_OFFSET = 0;
    private static final int TE_LEN = 2;
    private static final int TEXTID_OFFSET = TE_OFFSET + TE_LEN;
    private static final int TXTALVL_OFFSET = TEXTID_OFFSET + TEXTID_LEN;
    private static final int TXTDT_OFFSET = TXTALVL_OFFSET + TXTALVL_LEN;
    private static final int TXTITL_OFFSET = TXTDT_OFFSET + ReaderUtils.DATE_TIME_LEN;
    private static final int TEXT_SECURITY_OFFSET = TXTITL_OFFSET + TXTITL_LEN;
    private static final int ENCRYP_OFFSET = TEXT_SECURITY_OFFSET + ReaderUtils.SECURITY_FIELDS_LEN;
    private static final int TXTFMT_OFFSET = ENCRYP_OFFSET + ReaderUtils.ENCRYP_LEN;
    private static final int TXSHDL_OFFSET = TXTFMT_OFFSET + TXTFMT_LEN;

    private String id;
    private int attachmentLevel;
    private String dateTime;
    private String title = "";
    private TextFormat textFormat = TextFormat.Standard;

    /** Constructor. */
    public TextSegmentHeader() {}

    public TextSegmentHeader(byte[] subheaderBytes) {
        id = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, TEXTID_OFFSET, TEXTID_LEN);
        attachmentLevel =
                ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, TXTALVL_OFFSET, TXTALVL_LEN);
        dateTime =
                ReaderUtils.convertByteArrayToBCSA(
                        subheaderBytes, TXTDT_OFFSET, ReaderUtils.DATE_TIME_LEN);
        title = ReaderUtils.convertByteArrayToECSA(subheaderBytes, TXTITL_OFFSET, TXTITL_LEN);
        String formatAsText =
                ReaderUtils.convertByteArrayToBCSA(subheaderBytes, TXTFMT_OFFSET, TXTFMT_LEN);
        textFormat = TextFormat.lookupByIdent(formatAsText);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAttachmentLevel() {
        return attachmentLevel;
    }

    public void setAttachmentLevel(int attachmentLevel) {
        this.attachmentLevel = attachmentLevel;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Text format (TXTFMT).
     *
     * <p>This field contains a valid three-character code indicating the textFormat or type of text
     * data.
     *
     * <p>Note: Valid codes are MTF to indicate USMTF (Refer to STANAG 5500 (NSIF) or MIL-STD-6040
     * (NITF) for examples of the USMTF textFormat), STA to indicate BCS formatting, UT1 to indicate
     * ECS text formatting, and U8S to indicate U8S text formatting.
     *
     * @return the text textFormat as an enumeration value.
     */
    public TextFormat getTextFormat() {
        return textFormat;
    }

    /**
     * Set the text format (TXTFMT).
     *
     * <p>This field contains a valid three-character code indicating the textFormat or type of text
     * data.
     *
     * <p>Note: Valid codes are MTF to indicate USMTF (Refer to STANAG 5500 (NSIF) or MIL-STD-6040
     * (NITF) for examples of the USMTF textFormat), STA to indicate BCS formatting, UT1 to indicate
     * ECS text formatting, and U8S to indicate U8S text formatting.
     *
     * @param textFormat the text textFormat as an enumeration value.
     */
    public void setTextFormat(TextFormat textFormat) {
        this.textFormat = textFormat;
    }
}
