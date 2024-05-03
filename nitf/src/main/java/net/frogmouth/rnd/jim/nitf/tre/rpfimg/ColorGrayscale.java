package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

public class ColorGrayscale {

    private int numberOfColorGrayscaleOffsetRecords;
    private int numberOfColorConverterOffsetRecords;
    private String externalColorGrayscaleFileName;

    public ColorGrayscale() {}

    public ColorGrayscale(final ColorGrayscale other) {
        this.numberOfColorGrayscaleOffsetRecords = other.numberOfColorGrayscaleOffsetRecords;
        this.numberOfColorConverterOffsetRecords = other.numberOfColorConverterOffsetRecords;
        this.externalColorGrayscaleFileName = other.externalColorGrayscaleFileName;
    }

    public int getNumberOfColorGrayscaleOffsetRecords() {
        return numberOfColorGrayscaleOffsetRecords;
    }

    public void setNumberOfColorGrayscaleOffsetRecords(int number) {
        this.numberOfColorGrayscaleOffsetRecords = number;
    }

    public int getNumberOfColorConverterOffsetRecords() {
        return numberOfColorConverterOffsetRecords;
    }

    public void setNumberOfColorConverterOffsetRecords(int number) {
        this.numberOfColorConverterOffsetRecords = number;
    }

    public String getExternalColorGrayscaleFileName() {
        return externalColorGrayscaleFileName;
    }

    public void setExternalColorGrayscaleFileName(String filename) {
        this.externalColorGrayscaleFileName = filename;
    }

    @Override
    public String toString() {
        return "ColorGrayscale{"
                + "numberOfColorGrayscaleOffsetRecords="
                + numberOfColorGrayscaleOffsetRecords
                + ", numberOfColorConverterOffsetRecords="
                + numberOfColorConverterOffsetRecords
                + ", externalColorGrayscaleFileName="
                + externalColorGrayscaleFileName
                + '}';
    }
}
