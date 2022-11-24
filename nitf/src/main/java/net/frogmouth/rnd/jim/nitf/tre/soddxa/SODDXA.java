package net.frogmouth.rnd.jim.nitf.tre.soddxa;

import net.frogmouth.rnd.jim.nitf.tre.TREField;
import net.frogmouth.rnd.jim.nitf.tre.TREOrder;
import net.frogmouth.rnd.jim.nitf.tre.TaggedRecordExtension;

/**
 * Space object data description XML (SODDXA) TRE.
 *
 * <p>The Space Object Data Description XML, Version A (SODDXA) Tagged Record Extension (TRE)
 * provides an explicit profile of space objects in a system and sensor-agnostic data container
 * within a NITF file. The SODDXA TRE is placed in the NITF File Header to summarily describe the
 * collection of imagery observations contained within the NITF file as a whole.
 *
 * <p>The TRE structure consists of the usual tag and length, followed by the XML blob as the body
 * of the TRE.
 */
public class SODDXA extends TaggedRecordExtension {

    private static final String TRE_TAG = "SODDXA";
    private String cedata;

    /** Constructor. */
    public SODDXA() {
        super(TRE_TAG);
    }

    /**
     * Data body of the TRE.
     *
     * @return the TRE body as an XML string
     */
    @TREOrder(order = 1)
    @TREField(label = "CEDATA")
    public String getData() {
        return cedata;
    }

    /**
     * Set the data body of the TRE
     *
     * @param cedata the TRE body as an XML string.
     */
    public void setData(String cedata) {
        this.cedata = cedata;
    }

    @Override
    protected String getTreeItemLabel() {
        return TRE_TAG;
    }
}
