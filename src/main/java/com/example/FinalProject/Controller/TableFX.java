package com.example.FinalProject.Controller;

import com.example.FinalProject.entity.Donate;
import com.example.FinalProject.repository.DonateRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

@Component
public class TableFX implements Initializable {

    ObservableList<FetchData> fetchData= FXCollections.observableArrayList();

    @Autowired
    DonateRepository donateRepository;

    @FXML
    public TableView<FetchData> tableview;

    @FXML
    public TableColumn<FetchData,Integer> ID;

    @FXML
    public TableColumn<FetchData,String> NAME;

    @FXML
    public TableColumn<FetchData,String> DONATION;

    @FXML
    public TableColumn<FetchData,String> PROJECT;

    @FXML
    public TableColumn<FetchData, LocalDate> DATE;

    @FXML
    public TableColumn<FetchData,String> EMAIL;

    @FXML
    public Button submitButton;

    List<Donate> donateList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        donateList=donateRepository.findAll();
        ColumnData();
        Table();
    }

    private void ColumnData()
    {
        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        NAME.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DONATION.setCellValueFactory(new PropertyValueFactory<>("Donation"));
        PROJECT.setCellValueFactory(new PropertyValueFactory<>("Project"));
        DATE.setCellValueFactory(new PropertyValueFactory<>("Date"));
        EMAIL.setCellValueFactory(new PropertyValueFactory<>("Email"));
    }
    public void Table()
    {
        tableview.getItems().removeAll(fetchData);
        fetchData.removeAll(fetchData);
        ColumnData();
        donateList=donateRepository.findAll();
        System.out.println(donateList.size());
        for (Donate donate : donateList) {
            FetchData record = new FetchData(donate.getSignUp().getId(), donate.getSignUp().getUserName(), donate.getDonateAmount(), donate.getProjectName(), donate.getDonateDate(),
                    donate.getSignUp().getEmail());
            fetchData.add(new FetchData(donate.getSignUp().getId(), donate.getSignUp().getUserName(), donate.getDonateAmount(), donate.getProjectName(), donate.getDonateDate(),
                    donate.getSignUp().getEmail()));
        }
        tableview.getItems().addAll(fetchData);
    }
    public void Table1(String UserName)
    {
        tableview.getItems().removeAll(fetchData);
        fetchData.removeAll(fetchData);
        ColumnData();
        donateList=donateRepository.findAll();
        for (int i = 0; i < donateList.size(); i++) {
            if(Objects.equals(donateList.get(i).getUserName(), UserName))
            {
                System.out.println(donateList.get(i));
            }
            else
            {
                donateList.remove(donateList.get(i));
            }
        }

        System.out.println(donateList.size());
        for (int i = 0; i < donateList.size(); i++) {
            FetchData record=new FetchData(donateList.get(i).getSignUp().getId(),donateList.get(i).getSignUp().getUserName(),donateList.get(i).getDonateAmount(),donateList.get(i).getProjectName(),donateList.get(i).getDonateDate(),
                    donateList.get(i).getSignUp().getEmail());
            fetchData.add(new FetchData(donateList.get(i).getSignUp().getId(),donateList.get(i).getSignUp().getUserName(),donateList.get(i).getDonateAmount(),donateList.get(i).getProjectName(),donateList.get(i).getDonateDate(),
                    donateList.get(i).getSignUp().getEmail()));
        }
        tableview.getItems().addAll(fetchData);
    }

    public static class FetchData
    {
        private final Integer Id;
        private final String Name;
        private final String Donation;
        private final String Project;
        private final LocalDate Date;
        private final String Email;

        public FetchData(Integer id, String name, String donation, String project, LocalDate date, String email) {
            Id = id;
            Name = name;
            Donation = donation;
            Project = project;
            Date = date;
            Email = email;
        }

        public Integer getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public String getDonation() {
            return Donation;
        }

        public String getProject() {
            return Project;
        }

        public LocalDate getDate() {
            return Date;
        }

        public String getEmail() {
            return Email;
        }
    }

    public void cancel(ActionEvent actionEvent) {

       Stage stage= (Stage) submitButton.getScene().getWindow();
       stage.close();

    }

}
