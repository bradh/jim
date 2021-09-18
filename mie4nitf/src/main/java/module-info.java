module com.sigmabravo.rnd.jim.mie4nitf {
    requires javafx.controls;
    requires com.sigmabravo.rnd.jim.nitf;

    uses com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;

    provides com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser with
            com.sigmabravo.rnd.jim.mie4nitf.tre.camsda.CAMSDAParser,
            com.sigmabravo.rnd.jim.mie4nitf.tre.fsynwa.FSYNWAParser,
            com.sigmabravo.rnd.jim.mie4nitf.tre.mimcsa.MIMCSAParser,
            com.sigmabravo.rnd.jim.mie4nitf.tre.mtimfa.MTIMFAParser,
            com.sigmabravo.rnd.jim.mie4nitf.tre.mtimsa.MTIMSAParser,
            com.sigmabravo.rnd.jim.mie4nitf.tre.tminta.TMINTAParser;
}
