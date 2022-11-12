package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.util.ArrayList;
import java.util.List;

public class PixelReferencedDataSet {
    private String type;
    private final List<PixelReferencedValue> values = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PixelReferencedValue> getValues() {
        return new ArrayList<>(values);
    }

    public void addPixelReferencedValue(PixelReferencedValue value) {
        this.values.add(value);
    }
}
