module com.thisisivan.linesfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.logging;

    opens com.thisisivan.linesfx to javafx.fxml;
    exports com.thisisivan.linesfx;
}