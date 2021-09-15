package com.sigmabravo.rnd.jim.nitf.image;

public class ImageBlockInfo {
    private final int blockOffset;
    private int blockLength;

    public ImageBlockInfo(int blockOffset) {
        this.blockOffset = blockOffset;
    }

    public int getBlockOffset() {
        return blockOffset;
    }

    public void setBlockLength(int length) {
        this.blockLength = length;
    }

    public int getBlockLength() {
        return blockLength;
    }
}
