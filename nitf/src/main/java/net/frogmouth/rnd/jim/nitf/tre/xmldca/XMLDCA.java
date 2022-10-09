package net.frogmouth.rnd.jim.nitf.tre.xmldca;

import com.github.snksoft.crc.CRC;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import net.frogmouth.rnd.jim.nitf.WriterUtils;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class XMLDCA extends TaggedRecordExtension implements SerialisableTaggedRecordExtension {

    private static final String TRE_TAG = "XMLDCA";
    private static final int TRESHL_LEN = 4;
    private boolean crcEnabled = false;
    // TODO: this isn't the real body
    private String body;

    public XMLDCA() {
        super(TRE_TAG);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    @Override
    public byte[] toBytes() {
        byte[] bodyBytes = new byte[0];
        if (body != null) {
            bodyBytes = body.getBytes(StandardCharsets.UTF_8);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_A(TRE_TAG, 6));
        // TODO: proper subheader handling
        int treshl = 0;
        if (crcEnabled) {
            // TODO: constant
            treshl = 5;
        }
        int cel = bodyBytes.length + TRESHL_LEN + treshl;
        baos.writeBytes(WriterUtils.toBCS_NPI(cel, 5));
        baos.writeBytes(WriterUtils.toBCS_NPI(treshl, TRESHL_LEN));
        if (crcEnabled) {
            // TODO: calculate and write CRC
            int crc = (int) CRC.calculateCRC(CRC.Parameters.CRC16, bodyBytes);
            baos.writeBytes(WriterUtils.toBCS_NPI(crc, 5));
        }
        baos.writeBytes(bodyBytes);
        return baos.toByteArray();
    }

    public boolean isCrcEnabled() {
        return crcEnabled;
    }

    public void setCrcEnabled(boolean crcEnabled) {
        this.crcEnabled = crcEnabled;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
