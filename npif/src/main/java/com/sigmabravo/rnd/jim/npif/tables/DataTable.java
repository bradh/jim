package com.sigmabravo.rnd.jim.npif.tables;

public class DataTable {
    private String sourceFile;
    private String name;
    private Header header;

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Header getHeader() {
        return new Header(header);
    }

    public void setHeader(Header header) {
        this.header = new Header(header);
    }

    protected double radiansToDegrees(double angleInRadians) {
        return 180 * angleInRadians / Math.PI;
    }
}
