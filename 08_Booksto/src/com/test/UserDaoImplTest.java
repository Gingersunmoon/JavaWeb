package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import org.junit.Test;

class UserDaoImplTest {

    @Test
    void queryUserByUsername() {
        UserDao userDao=new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("jiangke"));
    }

    @Test
    void saveUser() {
    }

    @Test
    void queryUserByUsernameAndPassword() {
    }
}