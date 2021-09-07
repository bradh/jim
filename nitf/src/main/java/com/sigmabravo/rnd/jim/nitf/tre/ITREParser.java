package com.sigmabravo.rnd.jim.nitf.tre;

/** @author bradh */
public interface ITREParser {

    public void init();

    public String getTag();

    public TRE parse(String tag, byte[] bytes);
}
