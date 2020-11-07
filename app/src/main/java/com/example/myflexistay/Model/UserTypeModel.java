package com.example.myflexistay.Model;

import java.io.Serializable;
import java.util.List;

public class UserTypeModel implements Serializable {

    /**
     * response : {"statusCode":"SUCCESS","statusMessage":"Query succeeded."}
     * types : [{"updation_date":"2020-10-11T17:49:08.411Z","code":"UR","operator_id":"OP","is_live":true,"id":1,"name":"Unregistered","creation_date":"2020-10-11T17:49:08.411Z"},{"updation_date":"2020-10-11T17:49:08.411Z","code":"RO","operator_id":"OP","is_live":true,"id":2,"name":"Registered Owner","creation_date":"2020-10-11T17:49:08.411Z"},{"updation_date":"2020-10-11T17:49:08.411Z","code":"RS","operator_id":"OP","is_live":true,"id":3,"name":"Registered Seller","creation_date":"2020-10-11T17:49:08.411Z"},{"updation_date":"2020-10-11T17:49:08.411Z","code":"RB","operator_id":"OP","is_live":true,"id":4,"name":"Registered Buyer","creation_date":"2020-10-11T17:49:08.411Z"},{"updation_date":"2020-10-11T17:49:08.411Z","code":"OP","operator_id":"OP","is_live":true,"id":5,"name":"Operations","creation_date":"2020-10-11T17:49:08.411Z"}]
     */

    private ResponseBean response;
    private List<TypesBean> types;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
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

    public static class TypesBean {
        /**
         * updation_date : 2020-10-11T17:49:08.411Z
         * code : UR
         * operator_id : OP
         * is_live : true
         * id : 1
         * name : Unregistered
         * creation_date : 2020-10-11T17:49:08.411Z
         */

        private String updation_date;
        private String code;
        private String operator_id;
        private boolean is_live;
        private int id;
        private String name;
        private String creation_date;

        public String getUpdation_date() {
            return updation_date;
        }

        public void setUpdation_date(String updation_date) {
            this.updation_date = updation_date;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getOperator_id() {
            return operator_id;
        }

        public void setOperator_id(String operator_id) {
            this.operator_id = operator_id;
        }

        public boolean isIs_live() {
            return is_live;
        }

        public void setIs_live(boolean is_live) {
            this.is_live = is_live;
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

        public String getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }
    }
}
