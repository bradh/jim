package net.frogmouth.rnd.jim.nitf.tre.cscrna;

import net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

/** CSCRNA TRE Parser. */
public class CSCRNAParser extends AbstractTaggedRecordExtensionParser {

    private static final int PREDICT_CORNERS_LEN = 1;
    private static final int LAT_LEN = 9;
    private static final int LON_LEN = 10;
    private static final int HT_LEN = 8;

    @Override
    public String getTag() {
        return "CSCRNA";
    }

    @Override
    public CSCRNA parse(String tag, byte[] bytes) {
        CSCRNA tre = new CSCRNA();
        int offset = 0;
        tre.setPredictCorners(readBCSA(bytes, offset, PREDICT_CORNERS_LEN));
        offset += PREDICT_CORNERS_LEN;
        tre.setUlcnr_lat(readBCSNLatitude(bytes, offset, LAT_LEN));
        offset += LAT_LEN;
        tre.setUlcnr_lon(readBCSNLongitude(bytes, offset, LON_LEN));
        offset += LON_LEN;
        tre.setUlcnr_lon(readBCSNHeight(bytes, offset, HT_LEN));
        offset += HT_LEN;
        tre.setUrcnr_lat(readBCSNLatitude(bytes, offset, LAT_LEN));
        offset += LAT_LEN;
        tre.setUrcnr_lon(readBCSNLongitude(bytes, offset, LON_LEN));
        offset += LON_LEN;
        tre.setUrcnr_lon(readBCSNHeight(bytes, offset, HT_LEN));
        offset += HT_LEN;
        tre.setLrcnr_lat(readBCSNLatitude(bytes, offset, LAT_LEN));
        offset += LAT_LEN;
        tre.setLrcnr_lon(readBCSNLongitude(bytes, offset, LON_LEN));
        offset += LON_LEN;
        tre.setLrcnr_lon(readBCSNHeight(bytes, offset, HT_LEN));
        offset += HT_LEN;
        tre.setLlcnr_lat(readBCSNLatitude(bytes, offset, LAT_LEN));
        offset += LAT_LEN;
        tre.setLlcnr_lon(readBCSNLongitude(bytes, offset, LON_LEN));
        offset += LON_LEN;
        tre.setLlcnr_lon(readBCSNHeight(bytes, offset, HT_LEN));
        offset += HT_LEN;
        assert offset == bytes.length;
        return tre;
    }
}
