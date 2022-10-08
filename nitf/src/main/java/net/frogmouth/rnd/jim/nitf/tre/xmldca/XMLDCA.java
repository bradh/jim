package net.frogmouth.rnd.jim.nitf.tre.xmldca;

import java.io.ByteArrayOutputStream;
import net.frogmouth.rnd.jim.nitf.WriterUtils;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class XMLDCA extends TaggedRecordExtension implements SerialisableTaggedRecordExtension {

    private static final String TRE_TAG = "XMLDCA";

    public XMLDCA() {
        super(TRE_TAG);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    @Override
    public byte[] toBytes() {
        // TODO: this isn't the real body
        byte[] body =
                new byte[] {
                    0x3C, 0x3f, 0X78, 0x6D, 0X6C, 0X20, 0X76, 0X65, 0X72, 0X73, 0X69, 0X6F, 0X6E,
                    0X3D, 0X22, 0X31, 0X2E, 0X30, 0X22, 0X20, 0X65, 0X6E, 0X63, 0X6F, 0X64, 0X69,
                    0X6E, 0X67, 0X3D, 0X22, 0X55, 0X54, 0X46, 0X2D, 0X38, 0X22, 0X3F, 0X3E, 0X0A,
                    0X3C, 0X74, 0X65, 0X73, 0X74, 0X2F, 0X3E,
                };
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(WriterUtils.toBCS_A(TRE_TAG, 6));
        int cel = body.length + 4;
        baos.writeBytes(WriterUtils.toBCS_NPI(cel, 5));
        // TODO: proper subheader
        baos.writeBytes(new byte[] {0x30, 0x30, 0x30, 0x30});
        baos.writeBytes(body);
        return baos.toByteArray();
    }
}
