module com.sigmabravo.rnd.jim.nitf {
    requires javafx.controls;

    exports com.sigmabravo.rnd.jim.nitf;
    exports com.sigmabravo.rnd.jim.nitf.tre;

    uses com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;

    provides com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser with
            com.sigmabravo.rnd.jim.nitf.tre.camsda.CAMSDAParser,
            com.sigmabravo.rnd.jim.nitf.tre.mimcsa.MIMCSAParser,
            com.sigmabravo.rnd.jim.nitf.tre.tminta.TMINTAParser;
}
