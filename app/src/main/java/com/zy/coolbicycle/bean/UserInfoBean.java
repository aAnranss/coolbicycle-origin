package com.zy.coolbicycle.bean;

/**
 * 应用模块:
 * 类描述:
 * Created by 卢文钏 on 2020/4/19
 */
public class UserInfoBean {

    /**
     * uid : 3
     * u_account : admin
     * u_password : 21232f297a57a5a743894a0e4a801fc3
     * u_email : null
     * u_age : null
     * u_ride_time : null
     * u_head : null
     */

    private String uid;
    private String u_account;
    private String u_password;
    private String u_nickname;
    private String u_email;
    private String u_age;
    private String u_ride_time;
    private String u_head;

    public UserInfoBean() {
    }

    public UserInfoBean(String u_account, String u_nickname, String u_email, String u_age, String u_ride_time, String u_head) {
        this.u_account = u_account;
        this.u_email = u_email;
        this.u_age = u_age;
        this.u_ride_time = u_ride_time;
        this.u_head = u_head;
        this.u_nickname = u_nickname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getU_account() {
        return u_account;
    }

    public void setU_account(String u_account) {
        this.u_account = u_account;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_nickname() {
        return u_nickname;
    }

    public void setU_nickname(String u_nickname) {
        this.u_nickname = u_nickname;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public String getU_age() {
        return u_age;
    }

    public void setU_age(String u_age) {
        this.u_age = u_age;
    }

    public String getU_ride_time() {
        return u_ride_time;
    }

    public void setU_ride_time(String u_ride_time) {
        this.u_ride_time = u_ride_time;
    }

    public String getU_head() {
        return u_head;
    }

    public void setU_head(String u_head) {
        this.u_head = u_head;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "uid='" + uid + '\'' +
                ", u_account='" + u_account + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_nickname='" + u_nickname + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_age='" + u_age + '\'' +
                ", u_ride_time='" + u_ride_time + '\'' +
                ", u_head='" + u_head + '\'' +
                '}';
    }
}
