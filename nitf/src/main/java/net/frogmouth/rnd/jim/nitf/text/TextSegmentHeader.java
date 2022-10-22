package net.frogmouth.rnd.jim.nitf.text;

import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TEXTID_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTALVL_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTFMT_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTITL_LEN;

import java.util.Arrays;
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

    private final byte[] bytes;
    private String id;
    private int attachmentLevel;
    private String dateTime;
    private String title;
    private String format;

    public TextSegmentHeader(byte[] subheaderBytes) {
        bytes = Arrays.copyOf(subheaderBytes, subheaderBytes.length);
        id = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, TEXTID_OFFSET, TEXTID_LEN);
        attachmentLevel =
                ReaderUtils.convertByteArrayToBCS_NPI(subheaderBytes, TXTALVL_OFFSET, TXTALVL_LEN);
        dateTime =
                ReaderUtils.convertByteArrayToBCSA(
                        subheaderBytes, TXTDT_OFFSET, ReaderUtils.DATE_TIME_LEN);
        title = ReaderUtils.convertByteArrayToECSA(subheaderBytes, TXTITL_OFFSET, TXTITL_LEN);
        format = ReaderUtils.convertByteArrayToBCSA(subheaderBytes, TXTFMT_OFFSET, TXTFMT_LEN);
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
