module com.sigmabravo.rnd.jim.ccinfa {
    requires javafx.controls;
    requires com.sigmabravo.rnd.jim.nitf;

    uses com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser;

    provides com.sigmabravo.rnd.jim.nitf.tre.AbstractTREParser with
            com.sigmabravo.rnd.jim.ccinfa.tre.CCINFAParser;
}