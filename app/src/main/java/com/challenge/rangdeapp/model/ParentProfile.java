package com.challenge.rangdeapp.model;

/**
 * Created by Jason on 16/01/2017.
 */
public class ParentProfile implements PersonProfile {
    private String id,name,email,address,profilePicURL,
            zipcode,studentName,studentSchool,studentGrade,subjects;


    public ParentProfile(){

    }

    public ParentProfile(String id, String name, String email, String address, String profilePicURL, String zipcode, String studentName, String studentSchool, String studentGrade, String subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.profilePicURL = profilePicURL;
        this.zipcode = zipcode;
        this.studentName = studentName;
        this.studentSchool = studentSchool;
        this.studentGrade = studentGrade;
        this.subjects = subjects;
    }

    @Override
    public String getAccountType() {
        return "Parent";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
