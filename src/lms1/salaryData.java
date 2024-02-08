/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms1;

/**
 *
 * @author USER
 */


public class salaryData {

    private double totalShift;
    private double extraShift;
    private String workerName;

    public salaryData(double totalShift, double extraShift, String workerName) {
        this.totalShift = totalShift;
        this.extraShift = extraShift;
        this.workerName = workerName;
    }

    public double getTotalShift() {
        return totalShift;
    }

    public double getExtraShift() {
        return extraShift;
    }
    
    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

}
