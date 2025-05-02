package com.rent.video.system.exchnage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserLoginResponse {
    String message;

    public GetUserLoginResponse()
    {

    }
    public GetUserLoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
