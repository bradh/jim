package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

public class ImageDescription {
    private int numberOfSpectralGroups;
    private int numberOfSubframeTables;
    private int numberOfSpectralBandTables;
    private int numberOfSpectralBandLinesPerImageRow;
    private int numberOfSubframesInEastWestOrLeftRightDirection;
    private int numberOfSubframesInNorthSouthOrUpDownDirection;
    private int numberOfOutputColumnsPerSubframe;
    private int numberOfOutputRowsPerSubframe;
    private int subframeMaskTableOffset;
    private int transparencyMaskTableOffset;

    public ImageDescription() {}

    public ImageDescription(final ImageDescription other) {
        this.numberOfSpectralGroups = other.numberOfSpectralGroups;
        this.numberOfSubframeTables = other.numberOfSubframeTables;
        this.numberOfSpectralBandTables = other.numberOfSpectralBandTables;
        this.numberOfSpectralBandLinesPerImageRow = other.numberOfSpectralBandLinesPerImageRow;
        this.numberOfSubframesInEastWestOrLeftRightDirection =
                other.numberOfSubframesInEastWestOrLeftRightDirection;
        this.numberOfSubframesInNorthSouthOrUpDownDirection =
                other.numberOfSubframesInNorthSouthOrUpDownDirection;
        this.numberOfOutputColumnsPerSubframe = other.numberOfOutputColumnsPerSubframe;
        this.numberOfOutputRowsPerSubframe = other.numberOfOutputRowsPerSubframe;
        this.subframeMaskTableOffset = other.subframeMaskTableOffset;
        this.transparencyMaskTableOffset = other.transparencyMaskTableOffset;
    }

    public int getNumberOfSpectralGroups() {
        return numberOfSpectralGroups;
    }

    public void setNumberOfSpectralGroups(int numberOfSpectralGroups) {
        this.numberOfSpectralGroups = numberOfSpectralGroups;
    }

    public int getNumberOfSubframeTables() {
        return numberOfSubframeTables;
    }

    public void setNumberOfSubframeTables(int numberOfSubframeTables) {
        this.numberOfSubframeTables = numberOfSubframeTables;
    }

    public int getNumberOfSpectralBandTables() {
        return numberOfSpectralBandTables;
    }

    public void setNumberOfSpectralBandTables(int numberOfSpectralBandTables) {
        this.numberOfSpectralBandTables = numberOfSpectralBandTables;
    }

    public int getNumberOfSpectralBandLinesPerImageRow() {
        return numberOfSpectralBandLinesPerImageRow;
    }

    public void setNumberOfSpectralBandLinesPerImageRow(int numberOfSpectralBandLinesPerImageRow) {
        this.numberOfSpectralBandLinesPerImageRow = numberOfSpectralBandLinesPerImageRow;
    }

    public int getNumberOfSubframesInEastWestOrLeftRightDirection() {
        return numberOfSubframesInEastWestOrLeftRightDirection;
    }

    public void setNumberOfSubframesInEastWestOrLeftRightDirection(
            int numberOfSubframesInEastWestOrLeftRightDirection) {
        this.numberOfSubframesInEastWestOrLeftRightDirection =
                numberOfSubframesInEastWestOrLeftRightDirection;
    }

    public int getNumberOfSubframesInNorthSouthOrUpDownDirection() {
        return numberOfSubframesInNorthSouthOrUpDownDirection;
    }

    public void setNumberOfSubframesInNorthSouthOrUpDownDirection(
            int numberOfSubframesInNorthSouthOrUpDownDirection) {
        this.numberOfSubframesInNorthSouthOrUpDownDirection =
                numberOfSubframesInNorthSouthOrUpDownDirection;
    }

    public int getNumberOfOutputColumnsPerSubframe() {
        return numberOfOutputColumnsPerSubframe;
    }

    public void setNumberOfOutputColumnsPerSubframe(int numberOfOutputColumnsPerSubframe) {
        this.numberOfOutputColumnsPerSubframe = numberOfOutputColumnsPerSubframe;
    }

    public int getNumberOfOutputRowsPerSubframe() {
        return numberOfOutputRowsPerSubframe;
    }

    public void setNumberOfOutputRowsPerSubframe(int numberOfOutputRowsPerSubframe) {
        this.numberOfOutputRowsPerSubframe = numberOfOutputRowsPerSubframe;
    }

    public int getSubframeMaskTableOffset() {
        return subframeMaskTableOffset;
    }

    public void setSubframeMaskTableOffset(int subframeMaskTableOffset) {
        this.subframeMaskTableOffset = subframeMaskTableOffset;
    }

    public int getTransparencyMaskTableOffset() {
        return transparencyMaskTableOffset;
    }

    public void setTransparencyMaskTableOffset(int transparencyMaskTableOffset) {
        this.transparencyMaskTableOffset = transparencyMaskTableOffset;
    }

    @Override
    public String toString() {
        return "ImageDescription{"
                + "numberOfSpectralGroups="
                + numberOfSpectralGroups
                + ", numberOfSubframeTables="
                + numberOfSubframeTables
                + ", numberOfSpectralBandTables="
                + numberOfSpectralBandTables
                + ", numberOfSpectralBandLinesPerImageRow="
                + numberOfSpectralBandLinesPerImageRow
                + ", numberOfSubframesInEastWestOrLeftRightDirection="
                + numberOfSubframesInEastWestOrLeftRightDirection
                + ", numberOfSubframesInNorthSouthOrUpDownDirection="
                + numberOfSubframesInNorthSouthOrUpDownDirection
                + ", numberOfOutputColumnsPerSubframe="
                + numberOfOutputColumnsPerSubframe
                + ", numberOfOutputRowsPerSubframe="
                + numberOfOutputRowsPerSubframe
                + ", subframeMaskTableOffset="
                + subframeMaskTableOffset
                + ", transparencyMaskTableOffset="
                + transparencyMaskTableOffset
                + '}';
    }
}
