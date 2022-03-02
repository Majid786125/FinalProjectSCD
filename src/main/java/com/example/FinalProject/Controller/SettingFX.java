package com.example.FinalProject.Controller;
import com.example.FinalProject.entity.Signup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

@Component
public class SettingFX {

    @Autowired
    SignUpController signUpController;

    @Autowired
    private ApplicationContext applicationContext;

    @FXML
    public TextField UserField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField confirmField;

    @FXML
    public Button submitButton;

    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId=ZoneId.systemDefault();
        javafx.stage.Window owner=submitButton.getScene().getWindow();

        String Name=UserField.getText();
        String Password=passwordField.getText();
        String confirmFieldText=confirmField.getText();

        if(Objects.equals(Password, confirmFieldText))
        {
            Signup signup=signUpController.findSignId(Name);
            if(signup!=null)
            {
                signup.setPassword(Password);
                signUpController.updateSignUp(signup);
                showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                        "Welcome " + UserField.getText());
                clearField();
                Stage stage= (Stage) submitButton.getScene().getWindow();
                stage.close();
            }
            else
            {
                showAlert(Alert.AlertType.ERROR, owner, "No User Exist!",
                        "With User Name : " + UserField.getText());
                clearField();
            }
        }
        else
        {
            showAlert(Alert.AlertType.ERROR, owner, "Password Not Matched!",
                    "" + UserField.getText());
            clearField();
        }
    }
    private void clearField()
    {
        UserField.setText("");
        passwordField.setText("");
        confirmField.setText("");
    }

    public void showLoginWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/LogIn_View.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType confirmation, Window owner, String s, String s1) {
        Alert alert = new Alert(confirmation);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(s1);
        alert.initOwner(owner);
        alert.show();
    }

}
