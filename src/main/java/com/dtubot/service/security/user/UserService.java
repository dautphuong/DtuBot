package com.dtubot.service.security.user;



import com.dtubot.entity.security.user.User;
import com.dtubot.entity.security.user.UserDTO;

import java.util.List;


public interface UserService {
    List<User> findAll();
    void save(UserDTO userDto);
    User findByUsername(String username);
    User findById(Integer id);
    void delete(Integer id);

}


