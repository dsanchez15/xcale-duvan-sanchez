package com.xcale.test.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xcale.test.demo.dominio.MessageDto;
import com.xcale.test.demo.dominio.MessageGroupDto;

public interface SendMessage {
    /**
     * Method that is responsible for receiving a message from the whatsapp chat and decide how to send it depending on the origin.
     * Requires an object of type MessageDto
     *
     * @param message
     * @return
     * @throws JsonProcessingException
     */
    String sendMessage(MessageDto message) throws JsonProcessingException;

    /**
     * Method that sends a message to the whatsapp chat for the users of a group.
     * Requires an object of type MessageGroupDto
     *
     * @param messageGroupDto
     * @return
     * @throws JsonProcessingException
     */
    String sendMessageGroup(MessageGroupDto messageGroupDto) throws JsonProcessingException;
}
