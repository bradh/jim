package net.frogmouth.rnd.jim.nitf.text;

import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TEXTID_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXSHDL_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXSOFL_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTALVL_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTFMT_LEN;
import static net.frogmouth.rnd.jim.nitf.text.TextConstants.TXTITL_LEN;
import static net.frogmouth.rnd.jim.nitf.utils.ReaderUtils.ENCRYP_LEN;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.JBPDateTime;
import net.frogmouth.rnd.jim.nitf.SecurityMetadata;
import net.frogmouth.rnd.jim.nitf.WriterUtils;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;

// TODO: split this class into a POD instance, and a serialiser instance.
public class TextSegment {

    private static final byte[] TE_HEADER = "TE".getBytes(StandardCharsets.US_ASCII);
    private static final int DEFAULT_ENCRYP_VALUE = 0;

    private String identifier = "";
    private int attachmentLevel = 0;
    private JBPDateTime dateTime = new JBPDateTime();
    private String title = "";
    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    private TextFormat textFormat = TextFormat.Standard;
    private String body;
    private List<SerialisableTaggedRecordExtension> extensions = new ArrayList<>();

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(TE_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(identifier, TEXTID_LEN));
        baos.writeBytes(WriterUtils.toBCS_NPI(attachmentLevel, TXTALVL_LEN));
        baos.writeBytes(dateTime.asBytes());
        baos.writeBytes(WriterUtils.toECS_A(title, TXTITL_LEN));
        baos.writeBytes(securityMetadata.asBytes());
        baos.writeBytes(WriterUtils.toBCS_NPI(DEFAULT_ENCRYP_VALUE, ENCRYP_LEN));
        baos.writeBytes(WriterUtils.toBCS_A(textFormat.getEncodedValue(), TXTFMT_LEN));
        writeExtensionArea(baos);
        return baos.toByteArray();
    }

    private void writeExtensionArea(ByteArrayOutputStream baos) {
        byte[] extensionBytes = collectExtensionBytes();
        if (extensionBytes.length == 0) {
            baos.writeBytes(WriterUtils.toBCS_NPI(0, TXSHDL_LEN));
        } else {
            int txshdl = TXSOFL_LEN + extensionBytes.length;
            // TODO: handle case where it is too long to fit in TXSHD
            int txsofl = 0;
            baos.writeBytes(WriterUtils.toBCS_NPI(txshdl, TXSHDL_LEN));
            baos.writeBytes(WriterUtils.toBCS_NPI(txsofl, TXSOFL_LEN));
            baos.writeBytes(extensionBytes);
        }
    }

    private byte[] collectExtensionBytes() {
        if (this.extensions.isEmpty()) {
            return new byte[0];
        } else {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            for (SerialisableTaggedRecordExtension extension : extensions) {
                if (extension != null) {
                    baos.writeBytes(extension.toBytes());
                }
            }
            return baos.toByteArray();
        }
    }

    public int getLengthOfTextSegment() {
        return getBodyAsBytes().length;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public JBPDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(JBPDateTime dateTime) {
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
     * <p>This field contains a valid three-character code indicating the format or type of text
     * data.
     *
     * <p>Note: Valid codes are MTF to indicate USMTF (Refer to STANAG 5500 (NSIF) or MIL-STD-6040
     * (NITF) for examples of the USMTF format), STA to indicate BCS formatting, UT1 to indicate ECS
     * text formatting, and U8S to indicate U8S text formatting.
     *
     * @return the text format as an enumeration value.
     */
    public TextFormat getTextFormat() {
        return textFormat;
    }

    /**
     * Set the text format (TXTFMT).
     *
     * <p>This field contains a valid three-character code indicating the format or type of text
     * data.
     *
     * <p>Note: Valid codes are MTF to indicate USMTF (Refer to STANAG 5500 (NSIF) or MIL-STD-6040
     * (NITF) for examples of the USMTF format), STA to indicate BCS formatting, UT1 to indicate ECS
     * text formatting, and U8S to indicate U8S text formatting.
     *
     * @param textFormat the text format as an enumeration value.
     */
    public void setTextFormat(TextFormat textFormat) {
        this.textFormat = textFormat;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getBodyAsBytes() {
        // TODO: properly handle encoding
        return body.getBytes(StandardCharsets.US_ASCII);
    }

    public List<SerialisableTaggedRecordExtension> getExtensions() {
        return new ArrayList<>(extensions);
    }

    public void addExtension(SerialisableTaggedRecordExtension tre) {
        this.extensions.add(tre);
    }
}
