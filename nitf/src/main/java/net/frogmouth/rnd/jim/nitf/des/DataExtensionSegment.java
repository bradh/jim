package net.frogmouth.rnd.jim.nitf.des;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.SecurityMetadata;
import net.frogmouth.rnd.jim.nitf.WriterUtils;
import net.frogmouth.rnd.jim.nitf.tre.SerialisableTaggedRecordExtension;

public class DataExtensionSegment {

    private static final byte[] DE_HEADER = new byte[] {0x44, 0x45};
    private String identifier = "";
    private int version = 1;
    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    private List<SerialisableTaggedRecordExtension> extensions = new ArrayList<>();
    private byte[] desData = new byte[0];

    public byte[] getSubheaderAsBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.writeBytes(DE_HEADER);
        baos.writeBytes(WriterUtils.toBCS_A(identifier, 25));
        baos.writeBytes(WriterUtils.toBCS_NPI(version, 2));
        baos.writeBytes(securityMetadata.asBytes());
        writeExtensionArea(baos);
        return baos.toByteArray();
    }

    private void writeExtensionArea(ByteArrayOutputStream baos) {
        byte[] extensionBytes = collectExtensionBytes();
        baos.writeBytes(WriterUtils.toBCS_NPI(extensionBytes.length, 4));
        baos.writeBytes(extensionBytes);
    }

    // TODO: share with TextSegment
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLengthOfDataExtensionSegment() {
        return desData.length;
    }

    public byte[] getDesData() {
        return desData.clone();
    }

    public void setDesData(byte[] desData) {
        this.desData = desData.clone();
    }
}
