package com.zy.coolbicycle.bean;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/18
 */
public class LoginBean {

    /**
     * id : 1
     * account : admin
     * password : admin
     */

    private String id;
    private String account;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
