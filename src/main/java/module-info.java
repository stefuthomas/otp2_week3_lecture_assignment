module org.example.otp2_week3_lecture_assignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.otp2_week3_lecture_assignment to javafx.fxml;
    exports org.example.otp2_week3_lecture_assignment;
}