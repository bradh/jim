package net.frogmouth.rnd.jim.nitf.tre.matesa;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

public class MATESA extends TaggedRecordExtension {

    private static final String TRE_TAG = "MATESA";
    private String cur_source;
    private String cur_mate_type;
    private String cur_file_id;
    private final List<Group> groups = new ArrayList<>();

    public MATESA() {
        super(TRE_TAG);
    }

    @TREOrder(order = 1)
    @TREField(label = "CUR_SOURCE")
    public String getCur_source() {
        return cur_source;
    }

    public void setCur_source(String cur_source) {
        this.cur_source = cur_source;
    }

    @TREOrder(order = 2)
    @TREField(label = "CUR_MATE_TYPE")
    public String getCur_mate_type() {
        return cur_mate_type;
    }

    public void setCur_mate_type(String cur_mate_type) {
        this.cur_mate_type = cur_mate_type;
    }

    @TREOrder(order = 3)
    @TREField(label = "CUR_FILE_ID")
    public String getCur_file_id() {
        return cur_file_id;
    }

    public void setCur_file_id(String cur_file_id) {
        this.cur_file_id = cur_file_id;
    }

    @TREOrder(order = 4)
    @TREGroup
    public List<Group> getGroups() {
        return new ArrayList<>(groups);
    }

    public void addGroup(final Group group) {
        groups.add(group);
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
