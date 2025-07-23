package com.example.pajoheshgram.ui.contacts;

public class Contact {
    private String name;
    private String phone;
    private String status;
    private int avatarResId;

    public Contact(String name, String phone, String status, int avatarResId) {
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.avatarResId = avatarResId;
    }

    public String getName() { return name; }
    public String getStatus() { return status; }
    public int getAvatarResId() { return avatarResId; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

