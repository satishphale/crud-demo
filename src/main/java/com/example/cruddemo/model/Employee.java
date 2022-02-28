package com.example.cruddemo.model;

import javax.persistence.*;
import java.io.Serializable;

 //this class is map to database table
public class Employee implements Serializable {

    private long id;
    private String email;
     private String employeecode;
     private String imageurl;
    private  String jobtitle;
     private String name;
    private String phone;

    public Employee()
    {

    }

     public Employee(long id, String email, String employeecode, String imageurl, String jobtitle, String name, String phone) {
         this.id = id;
         this.email = email;
         this.employeecode = employeecode;
         this.imageurl = imageurl;
         this.jobtitle = jobtitle;
         this.name = name;
         this.phone = phone;
     }

     public long getId() {
         return id;
     }

     public void setId(long id) {
         this.id = id;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }

     public String getEmployeecode() {
         return employeecode;
     }

     public void setEmployeecode(String employeecode) {
         this.employeecode = employeecode;
     }

     public String getImageurl() {
         return imageurl;
     }

     public void setImageurl(String imageurl) {
         this.imageurl = imageurl;
     }

     public String getJobtitle() {
         return jobtitle;
     }

     public void setJobtitle(String jobtitle) {
         this.jobtitle = jobtitle;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     @Override
     public String toString() {
         return "Employee{" +
                 "id=" + id +
                 ", email='" + email + '\'' +
                 ", employeecode='" + employeecode + '\'' +
                 ", imageurl='" + imageurl + '\'' +
                 ", jobtitle='" + jobtitle + '\'' +
                 ", name='" + name + '\'' +
                 ", phone='" + phone + '\'' +
                 '}';
     }
 }
