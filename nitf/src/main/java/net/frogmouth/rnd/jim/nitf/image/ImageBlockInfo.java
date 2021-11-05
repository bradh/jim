package net.frogmouth.rnd.jim.nitf.image;

public class ImageBlockInfo {
    private final int blockOffset;
    private int blockLength;
    private final int columnIndex;
    private final int rowIndex;

    public ImageBlockInfo(int blockOffset, int columnIndex, int rowIndex) {
        this.blockOffset = blockOffset;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
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

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }
}
