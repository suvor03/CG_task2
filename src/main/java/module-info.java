module com.example.kg_task2_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ru.vsu.cs.suvorov_d_a.kg_task2_fx to javafx.fxml;
    exports ru.vsu.cs.suvorov_d_a.kg_task2_fx;
}