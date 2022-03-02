package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.Donate;
import com.example.FinalProject.entity.Project;
import com.example.FinalProject.entity.Signup;
import com.example.FinalProject.repository.DonateRepository;
import com.example.FinalProject.repository.ProjectRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class DonateFx implements Initializable {

    @Autowired
    TableFX tableFX;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    DonateRepository donateRepository;

    @Autowired
    SignUpController signUpController;

    @FXML
    public ComboBox<String> projectField;

    @FXML
    public DatePicker dateField;

    @FXML
    public TextField UserField;

    @FXML
    public TextField donateField;

    @FXML
    public Button submitButton;

    List<Project> projectList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        projectList=projectRepository.findAll();

        for (int i = 0; i < projectList.size(); i++) {
            projectField.getItems().add(projectList.get(i).getProjectName());
        }

    }

    public void register(ActionEvent event) throws SQLException
    {
        ZoneId defaultZoneId=ZoneId.systemDefault();
        javafx.stage.Window owner=submitButton.getScene().getWindow();

        String UserName=UserField.getText();
        String ProjectName=projectField.getValue();
        LocalDate date=dateField.getValue();
        String Amount=donateField.getText();
        LocalTime time=LocalTime.now();

        Donate donate=new Donate();
        donate.setUserName(UserName);
        donate.setProjectName(ProjectName);
        donate.setDonateAmount(Amount);
        donate.setDonateDate(date);
        donate.setDonateTime(time);
        donate.setSignUp(signUpController.findSignId(UserName));
        donate.setProject(signUpController.findProjectId(ProjectName));

        donateRepository.save(donate);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Donate Successful!",
                "To " + projectField.getValue());

      //  tableFX.Table1(UserName);
        clearField();
        Stage stage= (Stage) submitButton.getScene().getWindow();
        stage.close();
        //showLoginWindow();
    }
    private void showAlert(Alert.AlertType confirmation, Window owner, String s, String s1) {
        Alert alert = new Alert(confirmation);
        alert.setTitle(s);
        alert.setHeaderText(null);
        alert.setContentText(s1);
        alert.initOwner(owner);
        alert.show();
    }

    private void clearField()
    {
        UserField.setText("");
        /*projectField.setText("");*/
        donateField.setText("");
    }
}
