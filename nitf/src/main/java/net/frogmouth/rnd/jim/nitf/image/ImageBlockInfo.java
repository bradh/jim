package net.frogmouth.rnd.jim.nitf.image;

/**
 * Image block information.
 *
 * <p>Each image block is effectively a tile.
 *
 * <p>Refer to the Joint BIIF Profile section 5.13.3 Image Data Mask and 5.12.1.8 Blocked Images for
 * more detail.
 */
public class ImageBlockInfo {
    private final int blockOffset;
    private int blockLength;
    private final int columnIndex;
    private final int rowIndex;

    /**
     * Constructor.
     *
     * <p>Note that this constructor is not sufficient - you also need to set the block length.
     *
     * @param blockOffset the block offset
     * @param columnIndex the column index
     * @param rowIndex the row index
     */
    public ImageBlockInfo(int blockOffset, int columnIndex, int rowIndex) {
        this.blockOffset = blockOffset;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
    }

    /**
     * Block offset.
     *
     * @return the block offset in bytes
     */
    public int getBlockOffset() {
        return blockOffset;
    }

    /**
     * Set the block length
     *
     * @param length the block length in bytes
     */
    public void setBlockLength(int length) {
        this.blockLength = length;
    }

    /**
     * Block length.
     *
     * @return the block length in bytes
     */
    public int getBlockLength() {
        return blockLength;
    }

    /**
     * Column index.
     *
     * @return column index for the image block (tile).
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Row index.
     *
     * @return row index for the image block (tile).
     */
    public int getRowIndex() {
        return rowIndex;
    }
}
