module com.sigmabravo.rnd.jim.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sigmabravo.rnd.jim.nitf;

    opens com.sigmabravo.rnd.jim.ui to javafx.fxml;
    exports com.sigmabravo.rnd.jim.ui;
    requires org.freedesktop.gstreamer;
    requires org.freedesktop.gstreamer.fx;
    // opens gst1.java.core;
    
}
