package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.Paymentmethod;
import com.example.FinalProject.entity.Signup;
import com.example.FinalProject.repository.PaymentmethodRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Component
public class UpdatePaymentFX {
    @Autowired
    SignUpController signUpController;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    PaymentmethodRepository paymentmethodRepository;

    @FXML
    public TextField UserField;

    @FXML
    public TextField cardField;

    @FXML
    public DatePicker dateField;

    LogInFx logInFx;

    @FXML
    public Button submitButton;

    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId=ZoneId.systemDefault();
        javafx.stage.Window owner=submitButton.getScene().getWindow();

        String Name=UserField.getText();
        String Card=cardField.getText();
        LocalDate date=dateField.getValue();
        LocalTime time=LocalTime.now();

        Paymentmethod paymentmethod=signUpController.findPaymentId(Name);
        paymentmethod.setCardNumber(Card);
        paymentmethod.setDate(date);
        paymentmethod.setPaymentTime(time);
        paymentmethodRepository.save(paymentmethod);
        showAlert(owner, "Welcome " + cardField.getText());
        clearField();
        Stage stage= (Stage) submitButton.getScene().getWindow();
        stage.close();
    }
    private void clearField()
    {
        cardField.setText("");
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

    private void showAlert(Window owner, String s1) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Registration Successful!");
        alert.setHeaderText(null);
        alert.setContentText(s1);
        alert.initOwner(owner);
        alert.show();
    }

}
