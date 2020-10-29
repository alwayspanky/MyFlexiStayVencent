package com.example.myflexistay.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("mobile_validated")
    @Expose
    private Boolean mobileValidated;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_validated")
    @Expose
    private Boolean emailValidated;
    @SerializedName("pref_language")
    @Expose
    private String prefLanguage;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("reference_code")
    @Expose
    private Object referenceCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getMobileValidated() {
        return mobileValidated;
    }

    public void setMobileValidated(Boolean mobileValidated) {
        this.mobileValidated = mobileValidated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailValidated() {
        return emailValidated;
    }

    public void setEmailValidated(Boolean emailValidated) {
        this.emailValidated = emailValidated;
    }

    public String getPrefLanguage() {
        return prefLanguage;
    }

    public void setPrefLanguage(String prefLanguage) {
        this.prefLanguage = prefLanguage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Object getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(Object referenceCode) {
        this.referenceCode = referenceCode;
    }

}