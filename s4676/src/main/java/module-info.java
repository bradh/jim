/**
 * Dynamic Activity Reporter.
 *
 * <p>This module currently handles STANAG 4674 (AEDP-12) NATO ISR Tracking Standard tracks.
 *
 * <p>Other tracks are possible in the future.
 */
module DynamicActivityReporterDAR {
    requires com.ctc.wstx;
    requires com.fasterxml.jackson.dataformat.xml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.codehaus.stax2;
}
