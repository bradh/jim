package net.frogmouth.rnd.jim.nitf.tre.grdpsb;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;
import net.frogmouth.rnd.jim.nitf.tre.TRE;

/** GRDPSB TRE Parser. */
public class GRDPSBParser extends AbstractTREParser {

    private static final int NUM_GRDS_LEN = 2;
    private static final int ZVL_LEN = 10;
    private static final int BAD_LEN = 10;
    private static final int LOD_LEN = 12;
    private static final int LAD_LEN = 12;
    private static final int LSO_LEN = 11;
    private static final int PSO_LEN = 11;

    @Override
    public String getTag() {
        return "GRDPSB";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        GRDPSB tre = new GRDPSB();
        int offset = 0;
        int numGrids = this.readBCSN(bytes, offset, NUM_GRDS_LEN);
        offset += NUM_GRDS_LEN;
        for (int i = 0; i < numGrids; i++) {
            LocationGrid grid = new LocationGrid();
            grid.setLocationGridElevation(this.readDoubleOrNullFromBCSN(bytes, offset, ZVL_LEN));
            offset += ZVL_LEN;
            grid.setLocationGridId(this.readBCSA(bytes, offset, BAD_LEN));
            offset += BAD_LEN;
            grid.setDataDensityInColumns(this.readDoubleFromBCSN(bytes, offset, LOD_LEN));
            offset += LOD_LEN;
            grid.setDataDensityInRows(this.readDoubleFromBCSN(bytes, offset, LAD_LEN));
            offset += LAD_LEN;
            grid.setOriginInColumns(this.readDoubleFromBCSN(bytes, offset, LSO_LEN));
            offset += LSO_LEN;
            grid.setOriginInRows(this.readDoubleFromBCSN(bytes, offset, PSO_LEN));
            offset += PSO_LEN;
            tre.addGrid(grid);
        }
        assert offset == bytes.length;
        return tre;
    }
}
