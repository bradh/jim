package com.sigmabravo.rnd.jim.nitf.image;

import com.sigmabravo.rnd.jim.nitf.SegmentInfo;
import java.util.ArrayList;
import java.util.List;

public class ImageSegmentInfo extends SegmentInfo {
    private ImageSegmentHeader ish;
    private int imageDataOffset;
    private final List<ImageBlockInfo> imageBlocks = new ArrayList<>();

    public ImageSegmentInfo(final int segmentNumber) {
        super(segmentNumber);
    }

    public ImageSegmentHeader getImageSegmentHeader() {
        return ish;
    }

    public void setImageSegmentHeader(ImageSegmentHeader ish) {
        this.ish = ish;
    }

    public int getImageDataOffset() {
        return imageDataOffset;
    }

    public void setImageDataOffset(int imageDataOffset) {
        this.imageDataOffset = imageDataOffset;
    }

    public void addImageBlock(ImageBlockInfo imageBlockInfo) {
        imageBlocks.add(imageBlockInfo);
    }

    public List<ImageBlockInfo> getImageBlocks() {
        return new ArrayList<>(imageBlocks);
    }
}
