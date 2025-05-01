module bd_b {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.zaxxer.hikari;
    requires java.sql;


    opens bd_b to javafx.fxml;
    exports bd_b;
}