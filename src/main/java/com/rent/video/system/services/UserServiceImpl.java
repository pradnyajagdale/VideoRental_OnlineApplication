package com.rent.video.system.services;

import com.rent.video.system.dto.Role;
import com.rent.video.system.dto.User;
import com.rent.video.system.exchnage.*;
import com.rent.video.system.model.RoleEntity;
import com.rent.video.system.model.UserEntity;
import com.rent.video.system.repositories.UserRepository;
import com.rent.video.system.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public GetUserRegistrationResponse registerUserintoVideoAppln(GetUserRegistrationRequest urequest) {
        String rolename = urequest.getUrole();
        Optional<RoleEntity>  userRoleInfo = roleRepository.findByRolename(rolename);
        RoleEntity roleEntity;
        if (userRoleInfo.isPresent()) {
            roleEntity = userRoleInfo.get();
            // proceed with the role
        } else {
            // handle case where role not found
             roleEntity = new RoleEntity();
        }
        String hashedPassword = passwordEncoder.encode(urequest.getUpassword());
        UserEntity userentity = new UserEntity(urequest.getUfirstname(),urequest.getUlastname(),urequest.getUemail(),hashedPassword,roleEntity);
        UserEntity response_entity = userRepository.save(userentity);
        User user = getUserObj(response_entity);
        GetUserRegistrationResponse getRegistrationResponse = new GetUserRegistrationResponse();
        getRegistrationResponse.setUser(user);;
        return getRegistrationResponse;
    }

    public GetUserLoginResponse loginUserToApplication(GetUserLoginRequest getUserLoginRequest) {
        GetUserLoginResponse loginResponse= new GetUserLoginResponse();
        Optional<UserEntity> userbyemail = userRepository.findByUemail(getUserLoginRequest.getEmail());
        Optional<RoleEntity>  userRoleInfo = roleRepository.findByRolename(getUserLoginRequest.getRole());
        int roleid=0;
        if (userRoleInfo.isPresent()) {
            roleid = userRoleInfo.get().getRoleid();
        }

        String rawPassword = passwordEncoder.encode(getUserLoginRequest.getPassword());
        String hashedPasswordFromDB = userbyemail.get().getUpassword();

        if(userbyemail.isPresent() && passwordEncoder.matches(rawPassword, hashedPasswordFromDB) &&  userbyemail.get().getRole().getRoleid()==roleid)
        {
            UserEntity user = userbyemail.get();
            loginResponse.setMessage("login_success");
        }
        else {
            loginResponse.setMessage("login_fail");
        }
        return loginResponse;
    }
    public UserEntity getUserEntityObj(User user)
    {
        UserEntity uentity = new UserEntity();
        uentity.setUfirstname(user.getUfirstname());
        uentity.setUlastname(user.getUlastname());
        uentity.setUemail(user.getUemail());
        uentity.setUpassword(user.getUpassword());
      //  uentity.setRole(user.getRole());
        return uentity;
    }
    public User getUserObj(UserEntity uentity)
    {
        User user = new User();
        user.setUserid(uentity.getUserid());
        user.setUfirstname(uentity.getUfirstname());
        user.setUlastname(uentity.getUlastname());
        user.setUemail(uentity.getUemail());
        user.setUpassword(uentity.getUpassword());
        user.setRole(convertToRole(uentity.getRole()));
        return user;
    }

    public Role convertToRole(RoleEntity entity) {
        return new Role(entity.getRoleid(), entity.getRolename());
    }
}
