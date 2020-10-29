
package com.example.myflexistay.Model;

import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class Response {

    @Expose
    private String statusCode;
    @Expose
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
