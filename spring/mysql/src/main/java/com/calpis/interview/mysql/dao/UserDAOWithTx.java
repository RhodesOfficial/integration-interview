package com.calpis.interview.mysql.dao;

import com.calpis.interview.mysql.entity.User;
import com.calpis.interview.mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOWithTx {

    @Autowired
    private UserMapper userMapper;

    /*
     * REQUIRED(默认) 支持使用当前事务，如果当前事务不存在，创建一个新事务。
     * SUPPORTS 支持使用当前事务，如果当前事务不存在，则不使用事务。
     * MANDATORY 强制，支持使用当前事务，如果当前事务不存在，则抛出Exception。
     * REQUIRES_NEW 创建一个新事务，如果当前事务存在，把当前事务挂起。
     * NOT_SUPPORTED 无事务执行，如果当前事务存在，把当前事务挂起。
     * NEVER 无事务执行，如果当前有事务则抛出Exception。
     * NESTED 嵌套事务，如果当前事务存在，那么在嵌套的事务中执行。如果当前事务不存在，则表现跟REQUIRED一样。
     */
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
//    @Transactional(propagation = Propagation.NEVER)
    public void saveUser(User user) {
        userMapper.save(user);
    }
}
