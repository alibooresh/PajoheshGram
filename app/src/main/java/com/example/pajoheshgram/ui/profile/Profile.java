package com.example.pajoheshgram.ui.profile;

import java.io.Serializable;

public class Profile implements Serializable {
    private int avatarResId;
    private String name;
    private String status;
    private String phoneNumber;
    private String bio;
    private String username;
    private String birthday;
    private String userId;

    public Profile(int avatarResId, String name, String status, String phoneNumber, String bio, String username, String birthday, String userId) {
        this.avatarResId = avatarResId;
        this.name = name;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.bio = bio;
        this.username = username;
        this.birthday = birthday;
        this.userId = userId;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public void setAvatarResId(int avatarResId) {
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
