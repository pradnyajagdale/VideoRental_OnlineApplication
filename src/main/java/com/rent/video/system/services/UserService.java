package com.rent.video.system.services;

import com.rent.video.system.exchnage.GetUserLoginRequest;
import com.rent.video.system.exchnage.GetUserLoginResponse;
import com.rent.video.system.exchnage.GetUserRegistrationRequest;
import com.rent.video.system.exchnage.GetUserRegistrationResponse;

public interface UserService {
    public GetUserRegistrationResponse registerUserintoVideoAppln(GetUserRegistrationRequest urequest);
    public GetUserLoginResponse loginUserToApplication(GetUserLoginRequest getUserLoginRequest);
}
