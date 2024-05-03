package net.frogmouth.rnd.jim.nitf.tre.rpfimg;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class RPFIMG extends TaggedRecordExtension {
    private static final String TRE_TAG = "RPFIMG";
    private final List<ComponentLocationRecord> componentLocationRecords = new ArrayList<>();
    private CoverageRecord coverage;
    private Colormap colormap;
    private ImageDescription imageDescription;
    private ColorGrayscale colorGrayscale;

    public RPFIMG() {
        super(TRE_TAG);
    }

    public List<ComponentLocationRecord> getComponentLocationRecords() {
        return new ArrayList<>(componentLocationRecords);
    }

    public void addComponentLocationRecord(ComponentLocationRecord componentLocationRecord) {
        this.componentLocationRecords.add(componentLocationRecord);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }

    public CoverageRecord getCoverage() {
        return new CoverageRecord(coverage);
    }

    public void setCoverage(CoverageRecord coverageRecord) {
        this.coverage = new CoverageRecord(coverageRecord);
    }

    public Colormap getColormap() {
        return colormap;
    }

    public void setColormap(Colormap colormap) {
        this.colormap = colormap;
    }

    public ImageDescription getImageDescription() {
        if (imageDescription == null) {
            return null;
        }
        return new ImageDescription(imageDescription);
    }

    public void setImageDescription(ImageDescription description) {
        if (description != null) {
            this.imageDescription = new ImageDescription(description);
        }
    }

    public ColorGrayscale getColorGrayscale() {
        if (this.colorGrayscale == null) {
            return null;
        }
        return new ColorGrayscale(colorGrayscale);
    }

    public void setColorGrayscale(ColorGrayscale colourGrayscale) {
        if (colourGrayscale != null) {
            this.colorGrayscale = new ColorGrayscale(colourGrayscale);
        }
    }
}
