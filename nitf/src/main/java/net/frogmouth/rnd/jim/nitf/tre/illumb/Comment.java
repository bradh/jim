package net.frogmouth.rnd.jim.nitf.tre.illumb;

import net.frogmouth.rnd.jim.nitf.tre.TreePart;

public class Comment extends TreePart {

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    protected String getTreeItemLabel() {
        return "COMMENT: " + getComment();
    }
}
