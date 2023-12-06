module base.example.base2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens base.example.base2 to javafx.fxml;
    exports base.example.base2;
    exports base.example;
    opens base.example to javafx.fxml;
}