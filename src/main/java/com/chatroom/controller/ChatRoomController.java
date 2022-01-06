package com.chatroom.controller;

import com.chatroom.controller.entity.ChatUser;
import com.chatroom.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

  @Autowired private ChatRoomService chatRoomService;

  @GetMapping("/join/{roomId}/{userId}")
  public Set<ChatUser> joinChatRoom(
      @PathVariable("roomId") String roomId, @PathVariable("userId") String userId) {

    return chatRoomService.joinRoom(roomId, userId);
  }

  @GetMapping("/leave/{roomId}/{userId}")
  public Set<ChatUser> leaveChatRoom(
      @PathVariable("roomId") String roomId, @PathVariable("userId") String userId) {

    return chatRoomService.leaveRoom(roomId, userId);
  }
}
