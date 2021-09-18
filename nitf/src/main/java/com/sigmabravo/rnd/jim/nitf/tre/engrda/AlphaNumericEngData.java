package com.sigmabravo.rnd.jim.nitf.tre.engrda;

class AlphaNumericEngData extends EngData {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
