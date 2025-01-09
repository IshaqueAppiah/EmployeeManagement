package org.example.employeemanagementsystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class DashboardController {
    @FXML
    private Button logout;

    public  void logout(){
       try {
           logout.getScene().getWindow().hide();
           Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
           Stage stage = new Stage();
           Scene scene = new Scene(root);

           stage.setScene(scene);
           stage.show();
       }
       catch (Exception e){
           System.out.println(e);
       }

    }
}
