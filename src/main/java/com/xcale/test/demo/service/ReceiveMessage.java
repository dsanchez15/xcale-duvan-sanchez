package com.xcale.test.demo.service;

import com.xcale.test.demo.dominio.MessageSingleDto;

public interface ReceiveMessage {

    /**
     * Method that is responsible for receiving a message from the back of whatsapp and deciding whether to display or send notification.
     * Requires an object of type MessageSingleDto
     *
     * @param messageSingleDto
     */
    void receiveMessage(MessageSingleDto messageSingleDto);
}
