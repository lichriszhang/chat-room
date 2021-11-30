package com.chatroom.controller.entity;

import java.util.Objects;

public class ChatUser {

    private String userId;
    private String name;

    public ChatUser() {
        super();
    }

    public ChatUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatUser chatUser = (ChatUser) o;
        return Objects.equals(userId, chatUser.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }
}
