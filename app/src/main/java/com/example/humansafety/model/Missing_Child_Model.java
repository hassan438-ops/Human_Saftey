package com.example.humansafety.model;

public class Missing_Child_Model {
    String Address,Age,Contact,Father_Name,Gender,Identification_Mark,Image_URL,Missing_Since,Name;

    public Missing_Child_Model() {
    }

    public Missing_Child_Model(String address, String age, String contact, String father_Name, String gender, String identification_Mark, String image_URL, String missing_Since, String name) {
        Address = address;
        Age = age;
        Contact = contact;
        Father_Name = father_Name;
        Gender = gender;
        Identification_Mark = identification_Mark;
        Image_URL = image_URL;
        Missing_Since = missing_Since;
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getFather_Name() {
        return Father_Name;
    }

    public void setFather_Name(String father_Name) {
        Father_Name = father_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getIdentification_Mark() {
        return Identification_Mark;
    }

    public void setIdentification_Mark(String identification_Mark) {
        Identification_Mark = identification_Mark;
    }

    public String getImage_URL() {
        return Image_URL;
    }

    public void setImage_URL(String image_URL) {
        Image_URL = image_URL;
    }

    public String getMissing_Since() {
        return Missing_Since;
    }

    public void setMissing_Since(String missing_Since) {
        Missing_Since = missing_Since;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
