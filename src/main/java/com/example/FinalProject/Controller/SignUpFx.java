package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.Country;
import com.example.FinalProject.entity.Religion;
import com.example.FinalProject.entity.Signup;
import com.example.FinalProject.repository.CountryRepository;
import com.example.FinalProject.repository.ReligionRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class SignUpFx implements Initializable {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    SignUpController signUpController;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ReligionRepository religionRepository;

    @FXML
    private TextField NameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

   @FXML
   private ComboBox<String> countryField;

    @FXML
    private ComboBox<String> religionField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    List<Country> countryList;
    List<Religion> religionList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryList=countryRepository.findAll();
        System.out.println(countryList.toString());
        religionList=religionRepository.findAll();
        System.out.println(religionList.toString());

        for (int i = 0; i <countryList.size(); i++) {
            countryField.getItems().add(countryList.get(i).getCountryName());
        }

        for (int i = 0; i <religionList.size(); i++) {
            religionField.getItems().add(religionList.get(i).getReligionName());

        }
    }

    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId=ZoneId.systemDefault();
        javafx.stage.Window owner=submitButton.getScene().getWindow();

        String UserName=NameField.getText();
        String Password=passwordField.getText();
        String Phone=phoneField.getText();
        String Email=emailField.getText();
        String Country=countryField.getValue();
        String Religion=religionField.getValue();

        Signup signup=new Signup();
        signup.setUserName(UserName);
        signup.setPassword(Password);
        signup.setPhoneNo(Phone);
        signup.setEmail(Email);
        signup.setCountry(signUpController.findCountryId(Country));
        signup.setReligion(signUpController.findReligionId(Religion));

        signUpController.insertSingUpData(signup);

        showAlert(owner,
                "Welcome " + NameField.getText());

        clearField();
        Stage stage= (Stage) submitButton.getScene().getWindow();
        stage.close();
        //showLoginWindow();
    }
    private void clearField()
    {
        NameField.setText("");
        passwordField.setText("");
        phoneField.setText("");
        emailField.setText("");
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
    public void cancel(ActionEvent actionEvent) {
        //owner.onCloseRequestProperty();
        //System.exit(0);
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

}
