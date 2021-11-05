package net.frogmouth.rnd.jim.nitf.tre.matesa;

import java.util.ArrayList;
import java.util.List;
import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREGroup;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class Group extends TreePart {
    private String relationship;
    private final List<Mate> mates = new ArrayList<>();

    @TREOrder(order = 1)
    @TREField(label = "RELATIONSHIP")
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @TREOrder(order = 2)
    @TREGroup
    public List<Mate> getMates() {
        return new ArrayList<>(mates);
    }

    public void addMate(final Mate mate) {
        mates.add(mate);
    }

    @Override
    protected String getTreeItemLabel() {
        return "Group: " + getRelationship().trim();
    }
}
