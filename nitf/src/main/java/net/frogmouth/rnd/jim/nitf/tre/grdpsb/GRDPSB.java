package net.frogmouth.rnd.jim.nitf.tre.grdpsb;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class GRDPSB extends TaggedRecordExtension {
    private static final String TRE_TAG = "GRDPSB";
    private final List<LocationGrid> grids = new ArrayList<>();

    public GRDPSB() {
        super(TRE_TAG);
    }

    public List<LocationGrid> getGrids() {
        return new ArrayList<>(grids);
    }

    public void addGrid(LocationGrid grid) {
        grids.add(grid);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
