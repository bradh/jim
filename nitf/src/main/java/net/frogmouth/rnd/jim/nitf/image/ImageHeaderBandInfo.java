package net.frogmouth.rnd.jim.nitf.image;

public class ImageHeaderBandInfo {
    private String irepband;
    private String isubcat;
    private String ifc;
    private String imflt;
    // TODO: LUTs.

    public String getIrepband() {
        return irepband;
    }

    public void setIrepband(String irepband) {
        this.irepband = irepband;
    }

    public String getIsubcat() {
        return isubcat;
    }

    public void setIsubcat(String isubcat) {
        this.isubcat = isubcat;
    }

    public String getIfc() {
        return ifc;
    }

    public void setIfc(String ifc) {
        this.ifc = ifc;
    }

    public String getImflt() {
        return imflt;
    }

    public void setImflt(String imflt) {
        this.imflt = imflt;
    }
}
