package net.frogmouth.rnd.jim.nitf.tre.matesa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class Mate extends TreePart {
    private String source;
    private String mate_type;
    private String mate_id;

    @TREOrder(order = 1)
    @TREField(label = "SOURCE")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @TREOrder(order = 2)
    @TREField(label = "MATE_TYPE")
    public String getMate_type() {
        return mate_type;
    }

    public void setMate_type(String mate_type) {
        this.mate_type = mate_type;
    }

    @TREOrder(order = 3)
    @TREField(label = "MATE_ID")
    public String getMate_id() {
        return mate_id;
    }

    public void setMate_id(String mate_id) {
        this.mate_id = mate_id;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Mate " + getMate_id();
    }
}
