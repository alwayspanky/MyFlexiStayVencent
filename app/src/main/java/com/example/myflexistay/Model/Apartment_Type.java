package com.example.myflexistay.Model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Apartment_Type {


    /**
     * types : {"code":"GC","updation_date":"2020-10-11T17:49:08.411Z","operator_id":"OP","is_live":true,"name":"Gated Community Villa","id":3,"creation_date":"2020-10-11T17:49:08.411Z"}
     * response : {"statusMessage":"Query succeeded.","statusCode":"SUCCESS"}
     */

    @SerializedName("response")
    Response response;

    @SerializedName("types")
    ArrayList<ApartmentTypes> types;
    public class ApartmentTypes  {

        @SerializedName("updation_date")
        String updationDate;
        @SerializedName("code")
        String code;
        @SerializedName("operator_id")
        String operatorId;
        @SerializedName("is_live")
        String isLive;
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("creation_date")
        String creationDate;

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

        public String getIsLive() {
            return isLive;
        }

        public void setIsLive(String isLive) {
            this.isLive = isLive;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

    public ArrayList<ApartmentTypes> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<ApartmentTypes> types) {
        this.types = types;
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
