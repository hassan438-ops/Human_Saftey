package com.example.humansafety.model;

public class Harrassment_Model {
    String Address,CNIC,Complaint,Contact,DOB,District,Father_Name,Gender,Name,Secondary_Contact,Tehsil,Type;

    public Harrassment_Model() {

    }

    public Harrassment_Model(String address, String CNIC, String complaint, String contact, String DOB, String district, String father_Name, String gender, String name, String secondary_Contact, String tehsil, String type) {
        Address = address;
        this.CNIC = CNIC;
        Complaint = complaint;
        Contact = contact;
        this.DOB = DOB;
        District = district;
        Father_Name = father_Name;
        Gender = gender;
        Name = name;
        Secondary_Contact = secondary_Contact;
        Tehsil = tehsil;
        Type = type;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String complaint) {
        Complaint = complaint;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecondary_Contact() {
        return Secondary_Contact;
    }

    public void setSecondary_Contact(String secondary_Contact) {
        Secondary_Contact = secondary_Contact;
    }

    public String getTehsil() {
        return Tehsil;
    }

    public void setTehsil(String tehsil) {
        Tehsil = tehsil;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
