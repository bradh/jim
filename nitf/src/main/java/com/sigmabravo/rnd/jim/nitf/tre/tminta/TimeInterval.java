package com.sigmabravo.rnd.jim.nitf.tre.tminta;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;

public class TimeInterval extends TreePart {
    private int time_interval_index;
    private String start_timestamp;
    private String end_timestamp;

    @TREField(label = "TIME_INTERVAL_INDEX")
    @TREOrder(order = 1)
    public int getTime_interval_index() {
        return time_interval_index;
    }

    public void setTime_interval_index(int time_interval_index) {
        this.time_interval_index = time_interval_index;
    }

    @TREField(label = "START_TIMESTAMP")
    @TREOrder(order = 2)
    public String getStart_timestamp() {
        return start_timestamp;
    }

    public void setStart_timestamp(String start_timestamp) {
        this.start_timestamp = start_timestamp;
    }

    @TREField(label = "END_TIMESTAMP")
    @TREOrder(order = 3)
    public String getEnd_timestamp() {
        return end_timestamp;
    }

    public void setEnd_timestamp(String end_timestamp) {
        this.end_timestamp = end_timestamp;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Time Interval";
    }
}
