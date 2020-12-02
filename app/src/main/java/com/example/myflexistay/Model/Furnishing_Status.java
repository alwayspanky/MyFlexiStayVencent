package com.example.myflexistay.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Furnishing_Status {

    @SerializedName("response")
    Response response;

    @SerializedName("statuses")
    ArrayList<Furnishing_Status.furnishing_status> furnishingStatuses;

    public class furnishing_status{
        @SerializedName("updation_date")
        @Expose
        private String updationDate;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("operator_id")
        @Expose
        private String operatorId;
        @SerializedName("is_live")
        @Expose
        private Boolean isLive;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("creation_date")
        @Expose
        private String creationDate;


        public String getUpdationDate() {
            return updationDate;
        }

        public void setUpdationDate(String updationDate) {
            this.updationDate = updationDate;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOperatorId() {
            return operatorId;
        }

        public void setOperatorId(String operatorId) {
            this.operatorId = operatorId;
        }

        public Boolean getLive() {
            return isLive;
        }

        public void setLive(Boolean live) {
            isLive = live;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }
    }

    public ArrayList<Furnishing_Status.furnishing_status> getFurnishingStatuses() {
        return furnishingStatuses;
    }

    public void setFurnishingStatuses(ArrayList<Furnishing_Status.furnishing_status> furnishingStatuses) {
        this.furnishingStatuses = furnishingStatuses;
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

