/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms1;

import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author USER
 */
public class reportController implements Initializable {

    @FXML
    private TableView<attendanceData> attendanceView;

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
    private Label highestSal;

    @FXML
    private Label highestSalName;

    @FXML
    private Label lowestSal;

    @FXML
    private Label lowestSalName;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableShowAttendanceData();
    }

}
