package com.service;

import com.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password);

    /**
     * 检查 用户名是否可用
     * @param name
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String name);

}
