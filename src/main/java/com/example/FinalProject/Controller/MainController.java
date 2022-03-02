package com.example.FinalProject.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {
    @FXML
    public Button tableButton;

    @FXML
    public Button SettingButton;

    @FXML
    public Button paymentButton;

    @FXML
    public Button LogoutButton;

    @FXML
    public ImageView imageView2;

    @FXML
    public ImageView imageView3;

    @FXML
    public ImageView imageView4;

    @FXML
    public ImageView imageView5;

    @FXML
    public ImageView imageView6;

    @FXML
    public ImageView imageView7;

    @Autowired
    private ApplicationContext applicationContext;

    int x;
    String clickedImgUrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView2.setOnMouseClicked(event -> {

            clickedImgUrl = imageView2.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 4;
            ShowDescriptionWindow();
           // OpenDescriptionPage();

        });

        imageView3.setOnMouseClicked(event -> {

            clickedImgUrl = imageView3.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 1;
            ShowDescriptionWindow();
           // OpenDescriptionPage();

        });

        imageView4.setOnMouseClicked(event -> {

            clickedImgUrl = imageView4.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 2;
            ShowDescriptionWindow();
           // OpenDescriptionPage();

        });

        imageView5.setOnMouseClicked(event -> {

            clickedImgUrl = imageView5.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 3;
            ShowDescriptionWindow();
        });

        imageView6.setOnMouseClicked(event -> {

            clickedImgUrl = imageView6.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 6;
            ShowDescriptionWindow();

        });

        imageView7.setOnMouseClicked(event -> {

            clickedImgUrl = imageView7.getImage().getUrl();
            System.out.println(clickedImgUrl);
            x = 5;
            ShowDescriptionWindow();

        });
    }

    public void ShowDescriptionWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DescriptionPage.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,600,400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowMainWindow() {
        Stage stage1= (Stage) LogoutButton.getScene().getWindow();
        stage1.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Main.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,600,545));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowSettingWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Setting.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,448,508));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowTableWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/TableView.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,706,469));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void ShowPaymentWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Updatepayment.fxml"));
            fxmlLoader.setControllerFactory(applicationContext::getBean);
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1,393,486));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}