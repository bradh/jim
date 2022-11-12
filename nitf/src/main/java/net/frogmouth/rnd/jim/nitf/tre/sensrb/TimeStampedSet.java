package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.util.ArrayList;
import java.util.List;

public class TimeStampedSet {
    private String type;
    private List<TimeStampedValuePair> values = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TimeStampedValuePair> getTimeStampedValues() {
        return new ArrayList<>(values);
    }

    public void addTimeStampedValue(TimeStampedValuePair tsvp) {
        this.values.add(tsvp);
    }
}
