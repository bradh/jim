package com.sigmabravo.rnd.jim.nitf.tre.tminta;

import com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;
import com.sigmabravo.rnd.jim.nitf.tre.TRE;

/** TMINTA TRE Parser. */
public class TMINTAParser extends AbstractTREParser {

    private static final int NUM_TIME_INT_LEN = 4;
    private static final int TIME_INTERVAL_INDEX_LEN = 6;

    @Override
    public void init() {}

    @Override
    public String getTag() {
        return "TMINTA";
    }

    @Override
    public TRE parse(String tag, byte[] bytes) {
        TMINTA tre = new TMINTA();
        int offset = 0;
        int num_time_int = readBCSN(bytes, offset, NUM_TIME_INT_LEN);
        offset += NUM_TIME_INT_LEN;
        for (int i = 0; i < num_time_int; i++) {
            TimeInterval timeInterval = new TimeInterval();
            timeInterval.setTime_interval_index(readBCSN(bytes, offset, TIME_INTERVAL_INDEX_LEN));
            offset += TIME_INTERVAL_INDEX_LEN;
            timeInterval.setStart_timestamp(readTimeStampAsString(bytes, offset));
            offset += TIMESTAMP_LEN;
            timeInterval.setEnd_timestamp(readTimeStampAsString(bytes, offset));
            offset += TIMESTAMP_LEN;
            tre.addTimeInterval(timeInterval);
        }
        return tre;
    }
}
