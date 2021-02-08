package com.calpis.interview.mysql.mapper;

import com.calpis.interview.mysql.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends JpaRepositoryImplementation<User, Long> {

}
