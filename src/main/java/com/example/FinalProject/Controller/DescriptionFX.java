package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.Project;
import com.example.FinalProject.repository.ProjectRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class DescriptionFX implements Initializable {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    MainController mainController;

    @Autowired
    ProjectRepository projectRepository;

    @FXML
    public ImageView descriptionImage;

    @FXML
    public TextArea descriptionLabel;

    @FXML
    public Button submitButton;

    List<Project> projectList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        projectList = projectRepository.findAll();
        descriptionLabel.setWrapText(true);
        descriptionLabel.setDisable(true);

        for (int i = 0; i < projectList.size(); i++){

            if (projectList.get(i).getId().equals(mainController.x)){

                Image image = new Image(mainController.clickedImgUrl);
                descriptionImage.setImage(image);
                descriptionLabel.setText(projectList.get(i).getProjectDescription());

            }

        }

    }
    public void showDonateWindow()
    {
        Stage stage1= (Stage) submitButton.getScene().getWindow();
        stage1.close();
        try{
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/donate.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1= fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root1,363,477));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
