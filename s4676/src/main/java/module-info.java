/**
 * Dynamic Activity Reporter.
 *
 * <p>This module currently handles STANAG 4674 (AEDP-12) NATO ISR Tracking Standard tracks.
 *
 * <p>Other tracking standards are possible in the future.
 */
@SuppressWarnings("module") // That is not a version number - its a document number.
module net.frogmouth.rnd.jim.s4676 {
    requires com.ctc.wstx;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.codehaus.stax2;

    exports net.frogmouth.rnd.jim.s4676;
    exports net.frogmouth.rnd.jim.s4676.collection;
    exports net.frogmouth.rnd.jim.s4676.common;
    exports net.frogmouth.rnd.jim.s4676.message;
    exports net.frogmouth.rnd.jim.s4676.message.detection;
    exports net.frogmouth.rnd.jim.s4676.message.dynamicsourceinformation;
    exports net.frogmouth.rnd.jim.s4676.message.motionevent;
    exports net.frogmouth.rnd.jim.s4676.message.processedtrack;
    exports net.frogmouth.rnd.jim.s4676.message.sensormeasurement;
    exports net.frogmouth.rnd.jim.s4676.message.trackdata;
    exports net.frogmouth.rnd.jim.s4676.message.tracklinkage;
    exports net.frogmouth.rnd.jim.s4676.message.trackpoint;
    exports net.frogmouth.rnd.jim.s4676.message.tracksegment;
    exports net.frogmouth.rnd.jim.s4676.s4774;
    exports net.frogmouth.rnd.jim.s4676.sensor;
    exports net.frogmouth.rnd.jim.s4676.tracker;
}
