package com.xcale.test.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xcale.test.demo.dominio.MessageDto;
import com.xcale.test.demo.dominio.MessageSingleDto;
import com.xcale.test.demo.service.ReceiveMessage;
import com.xcale.test.demo.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class MessageController {

    @Autowired
    private final SendMessage sendMessage;

    @Autowired
    private final ReceiveMessage receiveMessage;

    public MessageController(SendMessage sendMessage, ReceiveMessage receiveMessage) {
        this.sendMessage = sendMessage;
        this.receiveMessage = receiveMessage;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto message) throws JsonProcessingException {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(sendMessage.sendMessage(message));
    }

    @PostMapping("/receiveMessage/3013244221")
    public ResponseEntity<String> receiveMessage(@RequestBody MessageSingleDto messageSingleDto){
        receiveMessage.receiveMessage(messageSingleDto);
        return ResponseEntity.ok().body("Done");
    }
}
