module net.frogmouth.rnd.jim.nitf {
    requires javafx.controls;

    exports net.frogmouth.rnd.jim.nitf;
    exports net.frogmouth.rnd.jim.nitf.tre;
    exports net.frogmouth.rnd.jim.nitf.image;
    exports net.frogmouth.rnd.jim.nitf.text;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser with
            net.frogmouth.rnd.jim.nitf.tre.blocka.BLOCKAParser,
            net.frogmouth.rnd.jim.nitf.tre.engrda.ENGRDAParser,
            net.frogmouth.rnd.jim.nitf.tre.illumb.ILLUMBParser,
            net.frogmouth.rnd.jim.nitf.tre.matesa.MATESAParser;
}
