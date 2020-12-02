package com.example.myflexistay.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Profile {

    @SerializedName("response")
    Response response;

    @SerializedName("profile")
    ArrayList<Profile.Profile_screen> profile_screens;

    public class Profile_screen{
        @SerializedName("first_name")
        String first_name;
        @SerializedName("last_name")
        String last_name;
        @SerializedName("mobile_validated")
        String mobile_validated;
        @SerializedName("email")
        String email;
        @SerializedName("email_validated")
        String email_validated;
        @SerializedName("pref_language")
        String pref_language;
        @SerializedName("profile_image")
        String profile_image;
        @SerializedName("reference_code")
        String reference_code;

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }



        public String getMobile_validated() {
            return mobile_validated;
        }

        public void setMobile_validated(String mobile_validated) {
            this.mobile_validated = mobile_validated;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail_validated() {
            return email_validated;
        }

        public void setEmail_validated(String email_validated) {
            this.email_validated = email_validated;
        }

        public String getPref_language() {
            return pref_language;
        }

        public void setPref_language(String pref_language) {
            this.pref_language = pref_language;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }

        public String getReference_code() {
            return reference_code;
        }

        public void setReference_code(String reference_code) {
            this.reference_code = reference_code;
        }
    }



    public ArrayList<Profile.Profile_screen> getProfile_screens() {
        return profile_screens;
    }

    public void setProfile_screens(ArrayList<Profile.Profile_screen> profile_screens) {
        this.profile_screens = profile_screens;
    }

    class Response{
        @SerializedName("statusCode")
        String statusCode;

        @SerializedName("statusMessage")
        String statusMessage;

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusMessage() {
            return statusMessage;
        }

        public void setStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
