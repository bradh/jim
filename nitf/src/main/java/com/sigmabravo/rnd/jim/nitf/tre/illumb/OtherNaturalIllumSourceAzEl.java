package com.sigmabravo.rnd.jim.nitf.tre.illumb;

import com.sigmabravo.rnd.jim.nitf.tre.TREField;
import com.sigmabravo.rnd.jim.nitf.tre.TREOrder;
import com.sigmabravo.rnd.jim.nitf.tre.TreePart;

public class OtherNaturalIllumSourceAzEl extends TreePart {
    private double other_azimuth;
    private double other_elev;

    @TREOrder(order = 1)
    @TREField(label = "OTHER_AZIMUTH")
    public double getOther_azimuth() {
        return other_azimuth;
    }

    public void setOther_azimuth(double other_azimuth) {
        this.other_azimuth = other_azimuth;
    }

    @TREOrder(order = 2)
    @TREField(label = "OTHER_ELEV")
    public double getOther_elev() {
        return other_elev;
    }

    public void setOther_elev(double other_elev) {
        this.other_elev = other_elev;
    }

    @Override
    protected String getTreeItemLabel() {
        return "Other Natural Light Source";
    }
}
