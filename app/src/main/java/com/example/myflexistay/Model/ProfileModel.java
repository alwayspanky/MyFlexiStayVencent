package com.example.myflexistay.Model;

public class ProfileModel {


    /**
     * response : {"statusCode":"SUCCESS","statusMessage":"Query succeeded."}
     * profile : {"first_name":"Prarthana","last_name":"Shankar","mobile":{"isd_code":91,"number":9606349900},"mobile_validated":false,"email":"shankar.prarthana@gmail.com","email_validated":false,"pref_language":"English","profile_image":"unverified/IMG_20190508_185451_307.jpg","reference_code":null}
     */

    private ResponseBean response;
    private ProfileBean profile;

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
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

    public static class ProfileBean {
        /**
         * first_name : Prarthana
         * last_name : Shankar
         * mobile : {"isd_code":91,"number":9606349900}
         * mobile_validated : false
         * email : shankar.prarthana@gmail.com
         * email_validated : false
         * pref_language : English
         * profile_image : unverified/IMG_20190508_185451_307.jpg
         * reference_code : null
         */

        private String first_name;
        private String last_name;
        private MobileBean mobile;
        private boolean mobile_validated;
        private String email;
        private boolean email_validated;
        private String pref_language;
        private String profile_image;
        private Object reference_code;

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

        public MobileBean getMobile() {
            return mobile;
        }

        public void setMobile(MobileBean mobile) {
            this.mobile = mobile;
        }

        public boolean isMobile_validated() {
            return mobile_validated;
        }

        public void setMobile_validated(boolean mobile_validated) {
            this.mobile_validated = mobile_validated;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmail_validated() {
            return email_validated;
        }

        public void setEmail_validated(boolean email_validated) {
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

        public Object getReference_code() {
            return reference_code;
        }

        public void setReference_code(Object reference_code) {
            this.reference_code = reference_code;
        }

        public static class MobileBean {
            /**
             * isd_code : 91
             * number : 9606349900
             */

            private int isd_code;
            private long number;

            public int getIsd_code() {
                return isd_code;
            }

            public void setIsd_code(int isd_code) {
                this.isd_code = isd_code;
            }

            public long getNumber() {
                return number;
            }

            public void setNumber(long number) {
                this.number = number;
            }
        }
    }
}