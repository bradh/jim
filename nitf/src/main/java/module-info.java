module com.sigmabravo.rnd.jim.nitf {
    requires javafx.controls;

    exports com.sigmabravo.rnd.jim.nitf;
    exports com.sigmabravo.rnd.jim.nitf.tre;

    uses com.sigmabravo.rnd.jim.nitf.tre.ITREParser;

    provides com.sigmabravo.rnd.jim.nitf.tre.ITREParser with
            com.sigmabravo.rnd.jim.nitf.tre.camsda.CAMSDAParser,
            com.sigmabravo.rnd.jim.nitf.tre.MIMCSAParser,
            com.sigmabravo.rnd.jim.nitf.tre.TMINTAParser;
}
