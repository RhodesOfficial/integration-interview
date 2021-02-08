package com.calpis.interview.mysql;

import com.calpis.interview.mysql.dao.UserDAO;
import com.calpis.interview.mysql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysqlApplicationTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void transactionTest() {
        User user = new User();
        user.setName("Lucky");
        user.setGender(true);
        user.setAge(22);
        userDAO.saveUser(user);
    }
}
