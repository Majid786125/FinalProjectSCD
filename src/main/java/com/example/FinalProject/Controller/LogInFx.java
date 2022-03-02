package com.example.FinalProject.Controller;
import com.example.FinalProject.entity.Paymentmethod;
import com.example.FinalProject.entity.Signup;
import com.example.FinalProject.repository.PaymentmethodRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Component
public class LogInFx  {

    @Autowired
    TableFX tableFX;

    @Autowired
    PaymentmethodRepository paymentmethodRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    SignUpController signUpController;

    @FXML
    private TextField NameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    List<Signup> signupList;
    List<Paymentmethod> paymentmethodList;

    boolean flag=false;
    boolean flag2=false;

    Window owner;
    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId=ZoneId.systemDefault();
        Window owner=submitButton.getScene().getWindow();

        String UserName=NameField.getText();
        String Password=passwordField.getText();

        signupList=signUpController.findAll();
        paymentmethodList=paymentmethodRepository.findAll();
        for (Signup signup : signupList) {
            if (Objects.equals(signup.getUserName(), UserName) && Objects.equals(signup.getPassword(), Password)) {
                flag = true;
                showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                        "Welcome " + NameField.getText());
                clearField();
               /* tableFX.Table1(UserName);*/
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
                for (Paymentmethod paymentmethod : paymentmethodList) {
                    if (Objects.equals(paymentmethod.getUserName(), UserName)) {
                        flag2 = true;
                        showHomePageWindow();
                        break;
                    }
                }
                break;
            }
        }
        if (!flag2)
        {
            showPaymentWindow();
        }
        if (!flag)
        {
            showAlert(Alert.AlertType.ERROR, owner, "Recheck Your User Name and Password!",
                    "Recheck :" + NameField.getText());
        }
    }
    private void clearField()
    {
        NameField.setText("");
        passwordField.setText("");
    }
    public void showPaymentWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/payment.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1,393,486));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSignUpWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/FinalSignUp.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHomePageWindow()
    {
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/HomePage.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1,900,700));
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

    public void cancel(ActionEvent actionEvent) {

        System.exit(0);

    }

}
