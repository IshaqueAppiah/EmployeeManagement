module org.example.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires fontawesomefx;

    opens org.example.employeemanagementsystem to javafx.fxml;
    exports org.example.employeemanagementsystem;
}