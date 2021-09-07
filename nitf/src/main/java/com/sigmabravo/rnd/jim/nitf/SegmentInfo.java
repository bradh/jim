package com.sigmabravo.rnd.jim.nitf;

/** Information about a NITF segment. */
class SegmentInfo {
    private int subheaderLength;
    private int segmentLength;
    private int segmentFileOffset;

    public int getSubheaderLength() {
        return subheaderLength;
    }

    public void setSubheaderLength(int subheaderLength) {
        this.subheaderLength = subheaderLength;
    }

    public int getSegmentLength() {
        return segmentLength;
    }

    public void setSegmentLength(int segmentLength) {
        this.segmentLength = segmentLength;
    }

    public int getSegmentFileOffset() {
        return segmentFileOffset;
    }

    public void setSegmentFileOffset(int segmentFileOffset) {
        this.segmentFileOffset = segmentFileOffset;
    }
}
