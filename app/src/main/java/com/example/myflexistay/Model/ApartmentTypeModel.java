
package com.example.myflexistay.Model;


import com.google.gson.annotations.Expose;


@SuppressWarnings("unused")
public class ApartmentTypeModel {

    @Expose
    private Response response;
    @Expose
    private Types types;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

}
