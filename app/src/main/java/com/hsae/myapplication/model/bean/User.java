package com.hsae.myapplication.model.bean;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/18
 */
// 用户数据模型
public class User {
    public int id;
    public String name;
    public String username;
    public String email;

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', username='" + username + "', email='" + email + "'}";
    }
}