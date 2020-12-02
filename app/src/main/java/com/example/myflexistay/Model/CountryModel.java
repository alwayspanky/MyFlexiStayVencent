package com.example.myflexistay.Model;

public class CountryModel {


    /**
     * country : {"code":"IN","isd_code":91,"updation_date":"24-08-2020T15:40:00.00+05:30","operator_id":"OP","is_live":true,"name":"India","language_id":1,"id":1,"mobile_number_length":10,"creation_date":"24-08-2020T15:40:00.00+05:30","currency_id":1,"mobile_number_pattern":"[7-9][0-9]{9}"}
     * response : {"statusMessage":"Query succeeded.","statusCode":"SUCCESS"}
     */
    private CountryEntity country;
    private ResponseEntity response;

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public void setResponse(ResponseEntity response) {
        this.response = response;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public ResponseEntity getResponse() {
        return response;
    }

    public class CountryEntity {
        /**
         * code : IN
         * isd_code : 91
         * updation_date : 24-08-2020T15:40:00.00+05:30
         * operator_id : OP
         * is_live : true
         * name : India
         * language_id : 1
         * id : 1
         * mobile_number_length : 10
         * creation_date : 24-08-2020T15:40:00.00+05:30
         * currency_id : 1
         * mobile_number_pattern : [7-9][0-9]{9}
         */
        private String code;
        private int isd_code;
        private String updation_date;
        private String operator_id;
        private boolean is_live;
        private String name;
        private int language_id;
        private int id;
        private int mobile_number_length;
        private String creation_date;
        private int currency_id;
        private String mobile_number_pattern;

        public void setCode(String code) {
            this.code = code;
        }

        public void setIsd_code(int isd_code) {
            this.isd_code = isd_code;
        }

        public void setUpdation_date(String updation_date) {
            this.updation_date = updation_date;
        }

        public void setOperator_id(String operator_id) {
            this.operator_id = operator_id;
        }

        public void setIs_live(boolean is_live) {
            this.is_live = is_live;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLanguage_id(int language_id) {
            this.language_id = language_id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setMobile_number_length(int mobile_number_length) {
            this.mobile_number_length = mobile_number_length;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }

        public void setCurrency_id(int currency_id) {
            this.currency_id = currency_id;
        }

        public void setMobile_number_pattern(String mobile_number_pattern) {
            this.mobile_number_pattern = mobile_number_pattern;
        }

        public String getCode() {
            return code;
        }

        public int getIsd_code() {
            return isd_code;
        }

        public String getUpdation_date() {
            return updation_date;
        }

        public String getOperator_id() {
            return operator_id;
        }

        public boolean isIs_live() {
            return is_live;
        }

        public String getName() {
            return name;
        }

        public int getLanguage_id() {
            return language_id;
        }

        public int getId() {
            return id;
        }

        public int getMobile_number_length() {
            return mobile_number_length;
        }

        public String getCreation_date() {
            return creation_date;
        }

        public int getCurrency_id() {
            return currency_id;
        }

        public String getMobile_number_pattern() {
            return mobile_number_pattern;
        }
    }

    public class ResponseEntity {
        /**
         * statusMessage : Query succeeded.
         * statusCode : SUCCESS
         */
        private String statusMessage;
        private String statusCode;

        public void setStatusMessage(String statusMessage) {
            this.statusMessage = statusMessage;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusMessage() {
            return statusMessage;
        }

        public String getStatusCode() {
            return statusCode;
        }
    }
}
