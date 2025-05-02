package com.rent.video.system.services;

import com.rent.video.system.dto.User;
import com.rent.video.system.exchnage.GetRegistrationRequest;
import com.rent.video.system.exchnage.GetRegistrationResponse;
import com.rent.video.system.model.UserEntity;
import com.rent.video.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    UserRepository userRepository;

    public GetRegistrationResponse registerUserintoVideoAppln(GetRegistrationRequest getRegistrationRequest) {

        UserEntity userentity = getUserEntityObj(getRegistrationRequest.getUser());
        UserEntity response_entity = userRepository.save(userentity);
        User user = getUserObj(response_entity);
        GetRegistrationResponse getRegistrationResponse = new GetRegistrationResponse();
        getRegistrationResponse.setUser(user);;
        return getRegistrationResponse;
    }

    public User loginUser(User user)
    {
        return null;
    }
    public UserEntity getUserEntityObj(User user)
    {
        UserEntity uentity = new UserEntity();
        uentity.setUserid(user.getUserid());
        uentity.setUfirstname(user.getUfirstname());
        uentity.setUlastname(user.getUlastname());
        uentity.setEmail(user.getEmail());
        uentity.setPassword(user.getPassword());
        uentity.setRoleid(user.getRoleid());
        return uentity;
    }
    public User getUserObj(UserEntity uentity)
    {
        User user = new User();
        user.setUserid(uentity.getUserid());
        user.setUfirstname(uentity.getUfirstname());
        user.setUlastname(uentity.getUlastname());
        user.setEmail(uentity.getEmail());
        user.setPassword(uentity.getPassword());
        user.setRoleid(uentity.getRoleid());
        return user;
    }
}
