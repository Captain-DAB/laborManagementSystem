/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms1;

import java.sql.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class mainPageController implements Initializable {

    @FXML
    private TextField address;

    @FXML
    private Button att_backBtn;

    @FXML
    private AnchorPane attendanceForm;

    @FXML
    private TableColumn<detailsData, String> col_contact;

    @FXML
    private TableColumn<detailsData, String> col_date;

    @FXML
    private TableColumn<detailsData, String> col_email;

    @FXML
    private TableColumn<detailsData, String> col_experience;

    @FXML
    private TableColumn<detailsData, String> col_height;

    @FXML
    private TableColumn<detailsData, String> col_id;

    @FXML
    private TableColumn<detailsData, String> col_identification;

    @FXML
    private TableColumn<detailsData, String> col_name;

    @FXML
    private TableColumn<detailsData, String> col_nokContact;

    @FXML
    private TableColumn<detailsData, String> col_nokEmail;

    @FXML
    private TableColumn<detailsData, String> col_nokName;

    @FXML
    private TableColumn<detailsData, String> col_referrer;

    @FXML
    private TableColumn<detailsData, String> col_status;

    @FXML
    private TableColumn<detailsData, String> col_weight;

    @FXML
    private TextField contact;

    @FXML
    private TextField email;

    @FXML
    private ComboBox<?> experience;

    @FXML
    private TextField height;

    @FXML
    private ComboBox<?> identification;

    @FXML
    private Button laborBtn;

    @FXML
    private TextField name;

    @FXML
    private TextField nok_contact;

    @FXML
    private TextField nok_email;

    @FXML
    private TextField nok_name;

    @FXML
    private TextField referrer;

    @FXML
    private Button signout;

    @FXML
    private ComboBox<?> status;

    @FXML
    private TableView<detailsData> tableView;

    @FXML
    private Label username;

    @FXML
    private TextField weight;

    @FXML
    private AnchorPane workerForm;

    @FXML
    private Button worker_add;

    @FXML
    private Button worker_clear;

    @FXML
    private Button worker_next;

    @FXML
    private AnchorPane tableForm;

    @FXML
    private TextField worker_id;

    @FXML
    private Button att_updateBtn;

    @FXML
    private Button viewBtn;

    @FXML
    private Button attendanceBtn;

    @FXML
    private Button salaryBtn;

    @FXML
    private TableView<attendanceData> attendanceView;

    @FXML
    private TextField attendance_id;

    @FXML
    private ComboBox<?> extraShift;

    @FXML
    private TextField time_in;

    @FXML
    private TextField time_out;

    @FXML
    private ComboBox<?> totalShift;

    @FXML
    private TextField building;

    @FXML
    private TableColumn<attendanceData, String> col_building;

    @FXML
    private TableColumn<attendanceData, String> col_id2;

    @FXML
    private TableColumn<attendanceData, String> col_date2;

    @FXML
    private TableColumn<attendanceData, String> col_extrashift;

    @FXML
    private TableColumn<attendanceData, String> col_shift;

    @FXML
    private TableColumn<attendanceData, String> col_timein;

    @FXML
    private TableColumn<attendanceData, String> col_timeout;

    @FXML
    private AnchorPane salaryForm;

    @FXML
    private Button calculateBtn;

    @FXML
    private Button generateReport;

    @FXML
    private TextField overallShiftSal;

    @FXML
    private TextField salary;

    @FXML
    private TextField salary_id;

    @FXML
    private TextField workerName;

    @FXML
    private TextField extraShiftSal;

    @FXML
    private TextField totalShiftSal;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private Alert alert;

    public void tableAddBtn() {

        if (worker_id.getText().isEmpty()
                || name.getText().isEmpty()
                || email.getText().isEmpty()
                || contact.getText().isEmpty()
                || referrer.getText().isEmpty()
                || experience.getSelectionModel().getSelectedItem() == null
                || identification.getSelectionModel().getSelectedItem() == null
                || weight.getText().isEmpty()
                || status.getSelectionModel().getSelectedItem() == null
                || height.getText().isEmpty()
                || address.getText().isEmpty()
                || nok_name.getText().isEmpty()
                || nok_email.getText().isEmpty()
                || nok_contact.getText().isEmpty()) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            //CHECK Worker ID
            String checkWorkerID = "SELECT worker_id FROM details WHERE worker_id = '"
                    + worker_id.getText() + "'";

            connect = database.connectDB();

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkWorkerID);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(worker_id.getText() + "is already taken");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO details "
                            + "(worker_id, name, email, contact, referrer, experience, identification, weight,"
                            + " status, height, address, nok_name, nok_email, nok_contact, date) "
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, worker_id.getText());
                    prepare.setString(2, name.getText());
                    prepare.setString(3, email.getText());
                    prepare.setString(4, contact.getText());
                    prepare.setString(5, referrer.getText());
                    prepare.setString(6, (String) experience.getSelectionModel().getSelectedItem());
                    prepare.setString(7, (String) identification.getSelectionModel().getSelectedItem());
                    prepare.setString(8, weight.getText());
                    prepare.setString(9, (String) status.getSelectionModel().getSelectedItem());
                    prepare.setString(10, height.getText());
                    prepare.setString(11, address.getText());
                    prepare.setString(12, nok_name.getText());
                    prepare.setString(13, nok_email.getText());
                    prepare.setString(14, nok_contact.getText());

                    //TO GET CURRENT DATE
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(15, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added");
                    alert.showAndWait();

                    tableShowData();
                    tableClearBtn();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void tableClearBtn() {

        worker_id.setText("");
        name.setText("");
        email.setText("");
        contact.setText("");
        referrer.setText("");
        experience.getSelectionModel().clearSelection();
        identification.getSelectionModel().clearSelection();
        weight.setText("");
        status.getSelectionModel().clearSelection();
        height.setText("");
        address.setText("");
        nok_name.setText("");
        nok_email.setText("");
        nok_contact.setText("");
        data.id = 0;

        // Set the prompt text again
        experience.setPromptText("Choose Experience...");
        identification.setPromptText("Choose Identification...");
        status.setPromptText("Choose Status...");

    }

    //MERGE ALL Details DATAS
    public ObservableList<detailsData> tableDataList() {

        ObservableList<detailsData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM details";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            detailsData detData;

            while (result.next()) {
                detData = new detailsData(
                        result.getInt("id"),
                        result.getString("worker_id"),
                        result.getString("name"),
                        result.getString("email"),
                        result.getString("contact"),
                        result.getString("referrer"),
                        result.getString("experience"),
                        result.getString("identification"),
                        result.getDouble("weight"),
                        result.getString("status"),
                        result.getDouble("height"),
                        result.getString("address"),
                        result.getString("nok_name"),
                        result.getString("nok_email"),
                        result.getString("nok_contact"),
                        result.getDate("date")
                );
                listData.add(detData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    //TO SHOW DATA ON OUR TABLE For Details
    private ObservableList<detailsData> tableListData;

    public void tableShowData() {
        tableListData = tableDataList();

        col_id.setCellValueFactory(new PropertyValueFactory<>("workerId"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        col_referrer.setCellValueFactory(new PropertyValueFactory<>("referrer"));
        col_experience.setCellValueFactory(new PropertyValueFactory<>("experience"));
        col_identification.setCellValueFactory(new PropertyValueFactory<>("identification"));
        col_weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_height.setCellValueFactory(new PropertyValueFactory<>("height"));
        col_height.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_nokName.setCellValueFactory(new PropertyValueFactory<>("nokName"));
        col_nokEmail.setCellValueFactory(new PropertyValueFactory<>("nokEmail"));
        col_nokContact.setCellValueFactory(new PropertyValueFactory<>("nokContact"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(tableListData);
    }

    public void tableUpdateBtn() {
        if (attendance_id.getText().isEmpty()
                || totalShift.getSelectionModel().getSelectedItem() == null
                || extraShift.getSelectionModel().getSelectedItem() == null
                || time_in.getText().isEmpty()
                || time_out.getText().isEmpty()
                || building.getText().isEmpty()) {

            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();

        } else {
            //CHECK Attendance ID
            String checkAttendanceID = "SELECT worker_id FROM details WHERE worker_id = '"
                    + attendance_id.getText() + "'";

            connect = database.connectDB();

            try {

                statement = connect.createStatement();
                result = statement.executeQuery(checkAttendanceID);

                if (!result.next()) {
                    // Attendance ID does not exist in the worker details table
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(attendance_id.getText() + " does not exist");
                    alert.showAndWait();
                } else {

                    // Now, insert data into the attendance table
                    String insertData = "INSERT INTO attendance "
                            + "(attendance_id, totalshift, extrashift, timein, timeout, building, date) "
                            + "VALUES(?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, attendance_id.getText());
                    prepare.setString(2, (String) totalShift.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String) extraShift.getSelectionModel().getSelectedItem());
                    prepare.setString(4, time_in.getText());
                    prepare.setString(5, time_out.getText());
                    prepare.setString(6, building.getText());

                    //TO GET CURRENT DATE
                    java.util.Date date = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(7, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated");
                    alert.showAndWait();

                    tableShowAttendanceData();
                    attendanceClearBtn();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void attendanceClearBtn() {

        attendance_id.setText("");
        totalShift.getSelectionModel().clearSelection();
        extraShift.getSelectionModel().clearSelection();
        time_in.setText("");
        time_out.setText("");
        building.setText("");
        data.id = 0;

        // Set the prompt text again
        extraShift.setPromptText("Choose ExtraShift Undertaken...");
    }

    //MERGE ALL DATAS in Attendance
    public ObservableList<attendanceData> tableDataListAttendance() {

        ObservableList<attendanceData> listAttData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM attendance";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            attendanceData attData;

            while (result.next()) {
                attData = new attendanceData(
                        result.getInt("id"),
                        result.getString("attendance_id"),
                        result.getString("totalshift"),
                        result.getString("extrashift"),
                        result.getString("timein"),
                        result.getString("timeout"),
                        result.getString("building"),
                        result.getDate("date")
                );
                listAttData.add(attData);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAttData;
    }

    //TO SHOW Attendance DATA ON OUR TABLE
    private ObservableList<attendanceData> tableListAttendanceData;

    public void tableShowAttendanceData() {
        tableListAttendanceData = tableDataListAttendance();

        col_id2.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        col_shift.setCellValueFactory(new PropertyValueFactory<>("totalShift"));
        col_extrashift.setCellValueFactory(new PropertyValueFactory<>("extraShift"));
        col_timein.setCellValueFactory(new PropertyValueFactory<>("timeIn"));
        col_timeout.setCellValueFactory(new PropertyValueFactory<>("timeOut"));
        col_building.setCellValueFactory(new PropertyValueFactory<>("building"));
        col_date2.setCellValueFactory(new PropertyValueFactory<>("date"));

        attendanceView.setItems(tableListAttendanceData);
    }

    //Salary Form
// Add this method to initialize the listener
    private void initializeWorkerIdListener() {
        salary_id.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                salaryData shifts = fetchShiftsForWorker(newValue);

                totalShiftSal.setText(String.valueOf(shifts.getTotalShift()));
                extraShiftSal.setText(String.valueOf(shifts.getExtraShift()));
                overallShiftSal.setText(String.valueOf(shifts.getTotalShift() + shifts.getExtraShift()));

                // Set the workerName in the TextField
                workerName.setText(shifts.getWorkerName());
            } else {
                totalShiftSal.setText("");
                extraShiftSal.setText("");
                overallShiftSal.setText("");
                workerName.setText("");
            }
        });
    }

    private salaryData fetchShiftsForWorker(String workerID) {
        String sql = "SELECT d.name, SUM(a.totalshift), SUM(a.extrashift) "
                + "FROM attendance a "
                + "JOIN details d ON a.attendance_id = d.worker_id "
                + "WHERE a.attendance_id = ? "
                + "GROUP BY d.name";
        salaryData shifts = new salaryData(0, 0, ""); // Default values

        try (Connection connect = database.connectDB(); PreparedStatement prepare = connect.prepareStatement(sql)) {

            prepare.setString(1, workerID);

            try (ResultSet result = prepare.executeQuery()) {
                if (result.next()) {
                    String workerName = result.getString("name");
                    double totalShift = result.getDouble(2);
                    double extraShift = result.getDouble(3);
                    shifts = new salaryData(totalShift, extraShift, workerName);
                } else {
                     System.out.println("No records found for worker ID: " + workerID);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shifts;
    }

    /////Sign Out Function
    public void signout() {

        try {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                //TO HIDE MAIN FORM
                signout.getScene().getWindow().hide();

                //LINK YOUR LOGIN FORM AND DISPLAY IT
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setTitle("Labour Management System");

                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ////////////Combo Box Lists
    private String[] experienceList = {"Novice", "Advanced Beginner", "Competent", "Proficient", "Expert"};

    public void ExperienceList() {

        List<String> experienceL = new ArrayList<>();

        for (String data : experienceList) {
            experienceL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(experienceL);
        experience.setItems(listData);
    }

    private String[] identityList = {"Permanent", "Temporary"};

    public void IdentityList() {

        List<String> identityL = new ArrayList<>();

        for (String data : identityList) {
            identityL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(identityL);
        identification.setItems(listData);
    }

    private String[] statusList = {"Lower", "Working", "Middle", "Upper-Middle", "Upper"};

    public void StatusList() {

        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(statusL);
        status.setItems(listData);

    }

    private String[] totalShiftList = {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours",
        "6 hour", "7 hours", "8 hours", "9 hours", "10 hours"};

    public void TotalShiftList() {

        List<String> totalShiftL = new ArrayList<>();

        for (String data : totalShiftList) {
            totalShiftL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(totalShiftL);
        totalShift.setItems(listData);
    }

    private String[] extraShiftList = {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours"};

    public void ExtraShiftList() {

        List<String> extraShiftL = new ArrayList<>();

        for (String data : extraShiftList) {
            extraShiftL.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(extraShiftL);
        extraShift.setItems(listData);
    }

    public void displayUsername() {

        String user = data.username;
        user = user.substring(0, 1).toUpperCase() + user.substring(1);

        username.setText(user);

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == laborBtn) {
            workerForm.setVisible(true);
            attendanceForm.setVisible(false);
            tableForm.setVisible(false);
            salaryForm.setVisible(false);

            ExperienceList();
            IdentityList();
            StatusList();

            tableShowData();
        } else if (event.getSource() == attendanceBtn) {
            workerForm.setVisible(false);
            attendanceForm.setVisible(true);
            tableForm.setVisible(false);
            salaryForm.setVisible(false);

            ExtraShiftList();

        } else if (event.getSource() == viewBtn) {
            tableForm.setVisible(true);
            workerForm.setVisible(false);
            attendanceForm.setVisible(false);
            salaryForm.setVisible(false);

        } else if (event.getSource() == salaryBtn) {
            tableForm.setVisible(false);
            workerForm.setVisible(false);
            attendanceForm.setVisible(false);
            salaryForm.setVisible(true);

        }
    }

//    public void backToWorkerDetails() {
//        workerForm.setVisible(true);
//        attendanceForm.setVisible(false);
//        tableForm.setVisible(false);
//    }
//
//    public void viewBtn() {
//        tableForm.setVisible(true);
//        workerForm.setVisible(false);
//        attendanceForm.setVisible(false);
//    }
//
//    public void NextToAttendance() {
//        workerForm.setVisible(false);
//        attendanceForm.setVisible(true);
//    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ExperienceList();
        IdentityList();
        StatusList();
        displayUsername();
        TotalShiftList();
        ExtraShiftList();

        tableShowData();
        tableShowAttendanceData();

        initializeWorkerIdListener();
    }

}
