package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

class UserServiceImplTest {
    UserService userService=new UserServiceImpl();
    @Test
    void registUser() {
        userService.registUser(new User(null,"liaowanting","654321","358207304@qq.com"));
    }

    @Test
    void login() {
        User jiangke = userService.login("jiangke", "123456");
        if(jiangke==null){
            System.out.println("登陆失败");
        }else {
            System.out.println("登陆成功："+jiangke);
        }
    }

    @Test
    void existsUsername() {
        if (userService.existsUsername("liaowanting")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名合法！");
        }
    }
}