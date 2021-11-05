package net.frogmouth.rnd.jim.npif.tables.sensorparametric;

import net.frogmouth.rnd.jim.npif.tables.DataTable;

/*
	Even if the JPEG 2000 description contained into the stream is self-sufficient, it can be helpful to get information on the compressed data structure prior to receiving
	it, in order to optimise the exploitation capability.
	Therefore, the JPEG 2000 Description Table contains information already included in the stream inside SIZ and COD markers.
	In JPEG 2000, the number of layers, decomposition levels, and precincts can change for every component. This feature is not supported in STANAG 7023.
*/
public class JPEG2000DescriptionDataTable extends DataTable {
    private int codestreamCapability;
    private int progressionOrder;
    private int numberOfDecompositionLevels;
    private int numberOfLayers;
    private int numberOfComponents;
    private int jpeg2000TilingPerformed;
    private int irep;

    public int getSensorId() {
        return (getHeader().getSourceAddress() & 0x3F);
    }

    public int getCodestreamCapability() {
        return codestreamCapability;
    }

    public String getCodestreamCapabilityAsText() {
        switch (getCodestreamCapability()) {
            case 0x01:
                return "Profile 0 (see ITU-T T.800 | IS 15444-1 AMD-1)";
            case 0x02:
                return "Profile 1";
            default:
                return "Unknown codestream capability (" + getCodestreamCapability() + ")";
        }
    }

    public void setCodestreamCapability(int codestreamCapability) {
        this.codestreamCapability = codestreamCapability;
    }

    public int getProgressionOrder() {
        return progressionOrder;
    }

    public String getProgressionOrderAsText() {
        switch (getProgressionOrder()) {
            case 0x00:
                return "Layer-Resolution-Component-Position";
            case 0x01:
                return "Resolution-Layer-Component-Position";
            case 0x02:
                return "Resolution-Position-Component-Layer";
            case 0x03:
                return "Position-Component-Resolution-Layer";
            case 0x04:
                return "Component-Position-Resolution-Layer";
            default:
                return "Unknown progression order (" + getProgressionOrder() + ")";
        }
    }

    public void setProgressionOrder(int progressionOrder) {
        this.progressionOrder = progressionOrder;
    }

    public int getNumberOfDecompositionLevels() {
        return numberOfDecompositionLevels;
    }

    public void setNumberOfDecompositionLevels(int numberOfDecompositionLevels) {
        this.numberOfDecompositionLevels = numberOfDecompositionLevels;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public void setNumberOfComponents(int numberOfComponents) {
        this.numberOfComponents = numberOfComponents;
    }

    public int getJpeg2000TilingPerformed() {
        return jpeg2000TilingPerformed;
    }

    public String getJpeg2000TilingPerformedAsText() {
        switch (getJpeg2000TilingPerformed()) {
            case 0x00:
                return "No JPEG 2000 Tiling has been used";
            case 0x01:
                return "JPEG 2000 Tiling has been used";
            default:
                return "Unknown JPEG 2000 Tiling (" + getJpeg2000TilingPerformed() + ")";
        }
    }

    public void setJpeg2000TilingPerformed(int jpeg2000TilingPerformed) {
        this.jpeg2000TilingPerformed = jpeg2000TilingPerformed;
    }

    public int getIrep() {
        return irep;
    }

    public String getIrepAsText() {
        switch (getIrep()) {
            case 0x00:
                return "BCS-A";
            case 0x01:
                return "MONO";
            case 0x02:
                return "RGB";
            case 0x03:
                return "RGB/LUT";
            case 0x04:
                return "MULTI";
            case 0x05:
                return "NODISPLY";
            case 0x06:
                return "NVECTOR";
            case 0x07:
                return "POLAR";
            case 0x09:
                return "VPH";
            case 0x0A:
                return "YCbCr601";
            default:
                return "Unknown IREP (" + getIrep() + ")";
        }
    }

    public void setIrep(int irep) {
        this.irep = irep;
    }
}
