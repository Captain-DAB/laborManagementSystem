/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms1;

import java.util.Date;

/**
 *
 * @author USER
 */
public class attendanceData {

    private Integer id;
    private String attendanceId;
    private String totalShift;
    private String extraShift;
    private String timeIn;
    private String timeOut;
    private String building;
    private Date date;

    public attendanceData(Integer id, String attendanceId, String totalShift, String extraShift,
            String timeIn, String timeOut, String building, Date date) {
        this.id = id;
        this.attendanceId = attendanceId;
        this.totalShift = totalShift;
        this.extraShift = extraShift;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.building = building;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public String getTotalShift() {
        return totalShift;
    }

    public String getExtraShift() {
        return extraShift;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public String getBuilding() {
        return building;
    }

    public Date getDate() {
        return date;
    }

}
