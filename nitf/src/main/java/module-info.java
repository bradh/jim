module com.sigmabravo.rnd.jim.nitf {
    requires javafx.controls;

    exports com.sigmabravo.rnd.jim.nitf;
    exports com.sigmabravo.rnd.jim.nitf.tre;
    exports com.sigmabravo.rnd.jim.nitf.image;
    exports com.sigmabravo.rnd.jim.nitf.text;

    uses com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;

    provides com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser with
            com.sigmabravo.rnd.jim.nitf.tre.blocka.BLOCKAParser,
            com.sigmabravo.rnd.jim.nitf.tre.camsda.CAMSDAParser,
            com.sigmabravo.rnd.jim.nitf.tre.fsynwa.FSYNWAParser,
            com.sigmabravo.rnd.jim.nitf.tre.mimcsa.MIMCSAParser,
            com.sigmabravo.rnd.jim.nitf.tre.mtimfa.MTIMFAParser,
            com.sigmabravo.rnd.jim.nitf.tre.mtimsa.MTIMSAParser,
            com.sigmabravo.rnd.jim.nitf.tre.tminta.TMINTAParser;
}
