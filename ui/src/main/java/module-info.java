module com.sigmabravo.rnd.jim.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.sigmabravo.rnd.jim.nitf;

    opens com.sigmabravo.rnd.jim.ui to javafx.fxml;
    exports com.sigmabravo.rnd.jim.ui;
    
}
