package com.rent.video.system.exchnage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rent.video.system.dto.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRegistrationRequest {
    String action;
    User user;
    public GetRegistrationRequest()
    {

    }
    public GetRegistrationRequest(String action, User user) {
        this.action = action;
        this.user = user;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "GetRegistrationRequest{" +
                "action='" + action + '\'' +
                ", user=" + user +
                '}';
    }
}
