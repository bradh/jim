module net.frogmouth.rnd.jim.ccinfa {
    requires javafx.controls;
    requires net.frogmouth.rnd.jim.nitf;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTREParser with
            net.frogmouth.rnd.jim.ccinfa.tre.CCINFAParser;
}