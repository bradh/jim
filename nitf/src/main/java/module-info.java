module net.frogmouth.rnd.jim.nitf {
    requires javafx.controls;
    requires com.github.snksoft.crc;

    exports net.frogmouth.rnd.jim.nitf;
    exports net.frogmouth.rnd.jim.nitf.tre;
    exports net.frogmouth.rnd.jim.nitf.image;
    exports net.frogmouth.rnd.jim.nitf.text;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser with
            net.frogmouth.rnd.jim.nitf.tre.blocka.BLOCKAParser,
            net.frogmouth.rnd.jim.nitf.tre.csdida.CSDIDAParser,
            net.frogmouth.rnd.jim.nitf.tre.cscrna.CSCRNAParser,
            net.frogmouth.rnd.jim.nitf.tre.csexrb.CSEXRBParser,
            net.frogmouth.rnd.jim.nitf.tre.engrda.ENGRDAParser,
            net.frogmouth.rnd.jim.nitf.tre.grdpsb.GRDPSBParser,
            net.frogmouth.rnd.jim.nitf.tre.illumb.ILLUMBParser,
            net.frogmouth.rnd.jim.nitf.tre.matesa.MATESAParser;
}
