package com.xcale.test.demo.service;

import com.xcale.test.demo.dominio.MessageSingleDto;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessageImpl implements ReceiveMessage {

    final boolean IS_OPEN_APP = false;

    @Override
    public void receiveMessage(MessageSingleDto messageSingleDto) {
        if (IS_OPEN_APP) {
            // Logic when the app is open
        } else {
            this.notifyMessage(messageSingleDto);
        }
    }

    private void notifyMessage(MessageSingleDto messageSingleDto) {
        System.out.println("The following message " + messageSingleDto.getMessage() + " was received from the " + messageSingleDto.getNumberSource());
    }
}
