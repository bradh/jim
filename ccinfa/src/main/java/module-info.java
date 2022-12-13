/**
 * STDI-0002 CCINFA Ontology Term Translator (SCOTT).
 *
 * <p>This module provides country code information support for NITF.
 */
module net.frogmouth.rnd.jim.ccinfa {
    requires javafx.controls;
    requires net.frogmouth.rnd.jim.nitf;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser with
            net.frogmouth.rnd.jim.ccinfa.tre.CCINFAParser;
}
