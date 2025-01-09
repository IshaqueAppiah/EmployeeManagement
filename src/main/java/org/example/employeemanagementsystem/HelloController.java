package org.example.employeemanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HelloController {

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private  Connection connect;
    private   PreparedStatement prepare;

    private  Boolean isConnected = false;

    private  ResultSet result;

    public  void connectDB(){
        try {
            Database db= new Database();
            connect =db.connectDB();
        }
        catch (Exception e){
            isConnected=false;
            e.printStackTrace();
        }
    }

    public void loginAdmin(){

        String sql = "SELECT * FROM admin WHERE username =? and password =?";
        if(!isConnected){
            connectDB();
        }
       isConnected=true;

        try {
            prepare= connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            result = prepare.executeQuery();
            Alert alert;

            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert= new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("please fill in all fields");
                alert.showAndWait();
            }
            else{
                if(result.next()){
                    alert= new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successful Login");
                    alert.showAndWait();

                    loginBtn.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage  stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    alert= new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("wrong user name or password");
                    alert.showAndWait();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        System.exit(0);

    }
}