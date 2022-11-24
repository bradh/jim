module net.frogmouth.rnd.jim.nitf {
    requires javafx.controls;
    requires com.github.snksoft.crc;
    requires net.frogmouth.rnd.jim.charsets;
    requires com.ctc.wstx;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.codehaus.stax2;

    exports net.frogmouth.rnd.jim.nitf;
    exports net.frogmouth.rnd.jim.nitf.tre;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.collection;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.nonsatellite;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite;
    exports net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.security;
    exports net.frogmouth.rnd.jim.nitf.image;
    exports net.frogmouth.rnd.jim.nitf.text;

    opens net.frogmouth.rnd.jim.nitf.tre.soddxa.xml to
            com.fasterxml.jackson.databind;
    opens net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.catalog to
            com.fasterxml.jackson.databind;
    opens net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.orbit to
            com.fasterxml.jackson.databind;
    opens net.frogmouth.rnd.jim.nitf.tre.soddxa.xml.satellite to
            com.fasterxml.jackson.databind;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser with
            net.frogmouth.rnd.jim.nitf.tre.blocka.BLOCKAParser,
            net.frogmouth.rnd.jim.nitf.tre.ccinf2.CCINFAParser,
            net.frogmouth.rnd.jim.nitf.tre.csdida.CSDIDAParser,
            net.frogmouth.rnd.jim.nitf.tre.cscrna.CSCRNAParser,
            net.frogmouth.rnd.jim.nitf.tre.csexrb.CSEXRBParser,
            net.frogmouth.rnd.jim.nitf.tre.engrda.ENGRDAParser,
            net.frogmouth.rnd.jim.nitf.tre.grdpsb.GRDPSBParser,
            net.frogmouth.rnd.jim.nitf.tre.illumb.ILLUMBParser,
            net.frogmouth.rnd.jim.nitf.tre.matesa.MATESAParser;
}
