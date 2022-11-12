package net.frogmouth.rnd.jim.nitf.tre.sensrb;

import java.util.ArrayList;
import java.util.List;

public class AdditionalParameter {
    private String name;
    private final List<String> values = new ArrayList<>();

    public AdditionalParameter() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return new ArrayList<>(values);
    }

    public void addValue(String value) {
        values.add(value);
    }
}
