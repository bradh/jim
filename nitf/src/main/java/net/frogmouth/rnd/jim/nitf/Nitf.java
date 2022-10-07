package net.frogmouth.rnd.jim.nitf;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.text.TextSegment;

public class Nitf {

    private final SecurityMetadata securityMetadata = new SecurityMetadata();
    private List<ImageSegment> imageSegments = new ArrayList<>();
    private List<GraphicSegment> graphicSegments = new ArrayList<>();
    private List<TextSegment> textSegments = new ArrayList<>();
    private List<DataExtensionSegment> dataExtensionSegments = new ArrayList<>();

    private static final int LTSH_BYTES = 4;
    private static final int LT_BYTES = 5;

    public boolean isNitf21() {
        // TODO: proper implementation
        return true;
    }

    public int getComplexityLevel() {
        // TODO: work this out
        return 3;
    }

    public String getOriginatingStationID() {
        // TODO: use something if we have it, else default
        return "JIM";
    }

    public byte[] getFileDateTimeAsBytes() {
        // TODO: actually have a datetime here and format it
        // CCYYMMDDhhmmss
        String fdt = "20221006060654";
        byte[] bytes = fdt.getBytes(StandardCharsets.US_ASCII);
        return bytes;
    }

    String getFileTitle() {
        // TODO: return real title if we have it
        return "";
    }

    public SecurityMetadata getSecurityMetadata() {
        return securityMetadata;
    }

    public int getCopyNumber() {
        return 0;
    }

    public int getNumberOfCopies() {
        return 0;
    }

    public byte[] getBackgroundColourAsBytes() {
        return new byte[] {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
    }

    public String getOriginatorName() {
        // TODO: fix this
        return "";
    }

    public String getOriginatorPhone() {
        // TODO: fix this
        return "";
    }

    public int getNumberOfImageSegments() {
        return imageSegments.size();
    }

    public int getNumberOfGraphicSegments() {
        return graphicSegments.size();
    }

    public int getNumberOfTextSegments() {
        return textSegments.size();
    }

    public int getNumberOfDataExtensionSegments() {
        return dataExtensionSegments.size();
    }

    public int calculateFileSize() {
        // TODO: calculate more
        int count = 388;
        for (TextSegment textSegment : textSegments) {
            count += LTSH_BYTES;
            count += LT_BYTES;
            count += textSegment.getSubheaderAsBytes().length;
            count += textSegment.getLengthOfTextSegment();
        }
        return count;
    }

    public int calculateHeaderSize() {
        // TODO: calculate more
        int count = 388;
        for (TextSegment textSegment : textSegments) {
            count += LTSH_BYTES;
            count += LT_BYTES;
        }
        return count;
    }

    public List<ImageSegment> getImageSegments() {
        return new ArrayList<>(imageSegments);
    }

    public List<GraphicSegment> getGraphicSegments() {
        return new ArrayList<>(graphicSegments);
    }

    public List<TextSegment> getTextSegments() {
        return new ArrayList<>(textSegments);
    }

    public void addTextSegment(TextSegment textSegment) {
        this.textSegments.add(textSegment);
    }

    public List<DataExtensionSegment> getDataExtensionSegments() {
        return new ArrayList<>(dataExtensionSegments);
    }
}
