module com.example.bartabalazs_lotto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.bartabalazs_lotto to javafx.fxml;
    exports com.example.bartabalazs_lotto;
}