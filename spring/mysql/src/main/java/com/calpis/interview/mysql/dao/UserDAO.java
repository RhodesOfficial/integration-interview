package com.calpis.interview.mysql.dao;

import com.calpis.interview.mysql.entity.User;
import com.calpis.interview.mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDAO {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDAOWithTx userDAOWithTx;

    @Transactional
    public void saveUser(User user) {
        userMapper.save(user);
        User newUser = new User();
        newUser.setName("Lucky");
        newUser.setGender(true);
        newUser.setAge(22);
        userDAOWithTx.saveUser(newUser);
    }

}
