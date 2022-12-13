module net.frogmouth.rnd.jim.mie4nitf {
    requires javafx.controls;
    requires net.frogmouth.rnd.jim.nitf;

    uses net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser;

    provides net.frogmouth.rnd.jim.nitf.tre.AbstractTaggedRecordExtensionParser with
            net.frogmouth.rnd.jim.mie4nitf.tre.camsda.CAMSDAParser,
            net.frogmouth.rnd.jim.mie4nitf.tre.fsynwa.FSYNWAParser,
            net.frogmouth.rnd.jim.mie4nitf.tre.mimcsa.MIMCSAParser,
            net.frogmouth.rnd.jim.mie4nitf.tre.mtimfa.MTIMFAParser,
            net.frogmouth.rnd.jim.mie4nitf.tre.mtimsa.MTIMSAParser,
            net.frogmouth.rnd.jim.mie4nitf.tre.tminta.TMINTAParser;
}
