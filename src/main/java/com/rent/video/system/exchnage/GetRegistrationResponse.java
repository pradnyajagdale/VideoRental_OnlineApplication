package com.rent.video.system.exchnage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rent.video.system.dto.User;
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRegistrationResponse {
    private User user;
    public GetRegistrationResponse()
    {
    }
    public GetRegistrationResponse(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "GetRegistrationResponse{" +
                "user=" + user +
                '}';
    }
}
