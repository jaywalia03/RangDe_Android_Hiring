package com.challenge.rangdeapp.model;

/**
 * Created by Jason on 16/01/2017.
 */
public class TutorProfile implements PersonProfile {
    private String id,name,email,address,profilePicURL,
            zipcode,bio,students;

    public TutorProfile(){

    }
    public TutorProfile(String id, String students, String bio, String zipcode, String profilePicURL, String address, String email, String name) {
        this.id = id;
        this.students = students;
        this.bio = bio;
        this.zipcode = zipcode;
        this.profilePicURL = profilePicURL;
        this.address = address;
        this.email = email;
        this.name = name;
    }

    @Override
    public String getAccountType() {
        return "Tutor";
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getStudents() {
        return students;
    }

    public void setStudents(String students) {
        this.students = students;
    }
}
