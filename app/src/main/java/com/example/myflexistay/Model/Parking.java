package com.example.myflexistay.Model;

import com.google.android.gms.common.api.Response;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Parking {

   @SerializedName("response")
   Response response;

   @SerializedName("types")
    ArrayList<Parking.parking> parkingstypes;

   public class parking{


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

    public ArrayList<parking> getParkingstypes() {
        return parkingstypes;
    }

    public void setParkingstypes(ArrayList<parking> parkingstypes) {
        this.parkingstypes = parkingstypes;
    }

    class Response {
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

        public Parking.Response getResponse() {
            return response;
        }

        public void setResponse(Parking.Response response) {
            this.response = response;
    }
}


