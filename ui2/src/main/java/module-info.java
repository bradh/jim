@SuppressWarnings("module")
module net.frogmouth.rnd.jim.ui2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires net.frogmouth.rnd.jim.map;

    opens net.frogmouth.rnd.jim.ui2 to javafx.fxml;
    exports net.frogmouth.rnd.jim.ui2;
}
