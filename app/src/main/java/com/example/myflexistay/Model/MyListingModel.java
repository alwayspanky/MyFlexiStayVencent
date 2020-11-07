package com.example.myflexistay.Model;

import java.util.List;

public class MyListingModel {


    /**
     * response : {"statusCode":"SUCCESS","statusMessage":"Query succeeded."}
     * listings : [{"updation_date":"2020-10-24T15:30:10.472Z","user_id":1,"listing_type_id":1,"operator_id":"updateListing","property_class_id":1,"is_active":true,"id":1,"creation_date":"2020-10-21T05:08:09.139Z","is_verified":false},{"updation_date":"2020-10-21T05:08:09.139Z","user_id":1,"listing_type_id":2,"operator_id":"createListing","property_class_id":1,"is_active":false,"id":2,"creation_date":"2020-10-21T05:08:09.139Z","is_verified":false}]
     */

    private ResponseBean response;
    private List<MyListings> listings;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public List<MyListings> getListings() {
        return listings;
    }

    public void setListings(List<MyListings> listings) {
        this.listings = listings;
    }

    public static class ResponseBean {
        /**
         * statusCode : SUCCESS
         * statusMessage : Query succeeded.
         */

        private String statusCode;
        private String statusMessage;

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

    public static class MyListings {
        /**
         * updation_date : 2020-10-24T15:30:10.472Z
         * user_id : 1
         * listing_type_id : 1
         * operator_id : updateListing
         * property_class_id : 1
         * is_active : true
         * id : 1
         * creation_date : 2020-10-21T05:08:09.139Z
         * is_verified : false
         */

        private String updation_date;
        private int user_id;
        private int listing_type_id;
        private String operator_id;
        private int property_class_id;
        private boolean is_active;
        private int id;
        private String creation_date;
        private boolean is_verified;

        public String getUpdation_date() {
            return updation_date;
        }

        public void setUpdation_date(String updation_date) {
            this.updation_date = updation_date;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getListing_type_id() {
            return listing_type_id;
        }

        public void setListing_type_id(int listing_type_id) {
            this.listing_type_id = listing_type_id;
        }

        public String getOperator_id() {
            return operator_id;
        }

        public void setOperator_id(String operator_id) {
            this.operator_id = operator_id;
        }

        public int getProperty_class_id() {
            return property_class_id;
        }

        public void setProperty_class_id(int property_class_id) {
            this.property_class_id = property_class_id;
        }

        public boolean isIs_active() {
            return is_active;
        }

        public void setIs_active(boolean is_active) {
            this.is_active = is_active;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }

        public boolean isIs_verified() {
            return is_verified;
        }

        public void setIs_verified(boolean is_verified) {
            this.is_verified = is_verified;
        }
    }
}
