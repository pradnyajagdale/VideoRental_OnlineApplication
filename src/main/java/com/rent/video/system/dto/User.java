package com.rent.video.system.dto;


public class User {
    int userid;
    String ufirstname;
    String ulastname;
    String email;
    String password;
    int roleid;

    public User()
    {

    }
    public User(int userid, String ufirstname, String ulastname, String email, String password, int roleid) {
        this.userid = userid;
        this.ufirstname = ufirstname;
        this.ulastname = ulastname;
        this.email = email;
        this.password = password;
        this.roleid = roleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUfirstname() {
        return ufirstname;
    }

    public void setUfirstname(String ufirstname) {
        this.ufirstname = ufirstname;
    }

    public String getUlastname() {
        return ulastname;
    }

    public void setUlastname(String ulastname) {
        this.ulastname = ulastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", ufirstname='" + ufirstname + '\'' +
                ", ulastname='" + ulastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                '}';
    }
}
