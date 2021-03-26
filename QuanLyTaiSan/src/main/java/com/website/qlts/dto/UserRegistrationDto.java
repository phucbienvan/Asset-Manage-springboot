package com.website.qlts.dto;

public class UserRegistrationDto {
    private String userName;
    private String password;
    private String rePass;

    public UserRegistrationDto(String userName, String password, String rePass) {
        this.userName = userName;
        this.password = password;
        this.rePass = rePass;
    }

    public UserRegistrationDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }
}
