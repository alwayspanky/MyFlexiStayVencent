
package com.example.myflexistay.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Types {

    @Expose
    private String code;
    @SerializedName("creation_date")
    private String creationDate;
    @Expose
    private Long id;
    @SerializedName("is_live")
    private Boolean isLive;
    @Expose
    private String name;
    @SerializedName("operator_id")
    private String operatorId;
    @SerializedName("updation_date")
    private String updationDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getUpdationDate() {
        return updationDate;
    }

    public void setUpdationDate(String updationDate) {
        this.updationDate = updationDate;
    }

}
