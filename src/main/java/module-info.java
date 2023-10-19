module com.example.movieverse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movieverse to javafx.fxml;
    exports com.example.movieverse;
}