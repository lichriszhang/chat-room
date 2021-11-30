package com.chatroom.service;

import com.chatroom.controller.entity.ChatUser;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

  private final Map<String, HashSet<ChatUser>> chatRooms = new ConcurrentHashMap<>();

  public Set<ChatUser> joinRoom(String roomId, String userId) {

    // 确保set只被初始化一次
    synchronized (chatRooms) {
      if (this.chatRooms.get(roomId) == null) {
        this.chatRooms.put(roomId, new HashSet<>());
      }
    }
    this.chatRooms.get(roomId).add(new ChatUser(userId, userId));
    return this.chatRooms.get(roomId).stream()
        .filter(u -> !userId.equals(u.getUserId()))
        .collect(Collectors.toSet());
  }

  public Set<ChatUser> leaveRoom(String roomId, String userId) {

    synchronized (chatRooms) {
      if (this.chatRooms.get(roomId) != null) {
        this.chatRooms.get(roomId).remove(new ChatUser(userId, userId));
      } else {
        return null;
      }
    }
    return this.chatRooms.get(roomId).stream()
        .filter(u -> !userId.equals(u.getUserId()))
        .collect(Collectors.toSet());
  }
}
