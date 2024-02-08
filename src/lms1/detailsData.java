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
public class detailsData {
    
    private Integer id;
    private String workerId;
    private String name;
    private String email;
    private String contact;
    private String referrer;
    private String experience;
    private String identification;
    private double weight;
    private String status;
    private double height;
    private String address;
    private String nokName;
    private String nokEmail;
    private String nokContact;
    private Date date;
    
    public detailsData(Integer id, String workerId, String name, String email, String contact,
            String referrer, String experience, String identification, double weight,
            String status, double height, String address, String nokName, String nokEmail,
            String nokContact, Date date) {

        this.id = id;
        this.workerId = workerId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.referrer = referrer;
        this.experience = experience;
        this.identification = identification;
        this.weight = weight;
        this.status = status;
        this.height = height;
        this.address = address;
        this.nokName = nokName;
        this.nokEmail = nokEmail;
        this.nokContact = nokContact;
        this.date = date;

    }

    
    public Integer getId() {
        return id;
    }
    
     public String getWorkerId() {
        return workerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getReferrer() {
        return referrer;
    }
    
    public String getExperience() {
        return experience;
    }
    
    public String getIdentification() {
        return identification;
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    public Double getHeight() {
        return height;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getNokName() {
        return nokName;
    }
    
    public String getNokEmail() {
        return nokEmail;
    }
    
    public String getNokContact() {
        return nokContact;
    }

    public Date getDate() {
        return date;
    }
    
}
