package com.example.pajoheshgram.ui.chats;

public class ChatItem {
    public String contactName;
    public String lastMessage;
    public String lastMessageTime;
    private int avatarResId;

    public ChatItem(String name, String lastMessage, String lastMessageTime,int avatarResId) {
        this.contactName = name;
        this.lastMessage = lastMessage;
        this.lastMessageTime = lastMessageTime;
        this.avatarResId = avatarResId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

    public int getAvatarUrl() {
        return avatarResId;
    }

    public void setAvatarUrl(int avatarUrl) {
        this.avatarResId = avatarUrl;
    }
}
