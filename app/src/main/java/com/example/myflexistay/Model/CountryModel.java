package com.example.myflexistay.Model;

public class CountryModel {


    /**
     * response : {"statusCode":"SUCCESS","statusMessage":"Query succeeded."}
     * country : {"currency_id":1,"updation_date":"24-08-2020T15:40:00.00+05:30","code":"IN","operator_id":"OP","mobile_number_pattern":"[7-9][0-9]{9}","isd_code":91,"is_live":true,"language_id":1,"id":1,"name":"India","mobile_number_length":10,"creation_date":"24-08-2020T15:40:00.00+05:30"}
     */

    private ResponseBean response;
    private CountryBean country;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public CountryBean getCountry() {
        return country;
    }

    public void setCountry(CountryBean country) {
        this.country = country;
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

    public static class CountryBean {
        /**
         * currency_id : 1
         * updation_date : 24-08-2020T15:40:00.00+05:30
         * code : IN
         * operator_id : OP
         * mobile_number_pattern : [7-9][0-9]{9}
         * isd_code : 91
         * is_live : true
         * language_id : 1
         * id : 1
         * name : India
         * mobile_number_length : 10
         * creation_date : 24-08-2020T15:40:00.00+05:30
         */

        private int currency_id;
        private String updation_date;
        private String code;
        private String operator_id;
        private String mobile_number_pattern;
        private int isd_code;
        private boolean is_live;
        private int language_id;
        private int id;
        private String name;
        private int mobile_number_length;
        private String creation_date;

        public int getCurrency_id() {
            return currency_id;
        }

        public void setCurrency_id(int currency_id) {
            this.currency_id = currency_id;
        }

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

        public String getMobile_number_pattern() {
            return mobile_number_pattern;
        }

        public void setMobile_number_pattern(String mobile_number_pattern) {
            this.mobile_number_pattern = mobile_number_pattern;
        }

        public int getIsd_code() {
            return isd_code;
        }

        public void setIsd_code(int isd_code) {
            this.isd_code = isd_code;
        }

        public boolean isIs_live() {
            return is_live;
        }

        public void setIs_live(boolean is_live) {
            this.is_live = is_live;
        }

        public int getLanguage_id() {
            return language_id;
        }

        public void setLanguage_id(int language_id) {
            this.language_id = language_id;
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

        public int getMobile_number_length() {
            return mobile_number_length;
        }

        public void setMobile_number_length(int mobile_number_length) {
            this.mobile_number_length = mobile_number_length;
        }

        public String getCreation_date() {
            return creation_date;
        }

        public void setCreation_date(String creation_date) {
            this.creation_date = creation_date;
        }
    }
}
