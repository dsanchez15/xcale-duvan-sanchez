package com.xcale.test.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xcale.test.demo.dominio.MessageDto;
import com.xcale.test.demo.dominio.MessageGroupDto;
import com.xcale.test.demo.shared.RestAPIs;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SendMessageImpl implements SendMessage {
    @Override
    public String sendMessage(MessageDto message) throws JsonProcessingException {
        Assert.notNull(message, "Message is required.");

        MessageGroupDto messageGroupDto = new MessageGroupDto(message);

        if (message.fromGroupChat()) {
            return this.sendMessageGroup(messageGroupDto);
        } else {
            // Logic for simple message
            return "Simple message";
        }
    }

    @Override
    public String sendMessageGroup(MessageGroupDto messageGroupDto) throws JsonProcessingException {
        Assert.notNull(messageGroupDto, "messageGroupDto is required");

        List<String> numbers = messageGroupDto.getNumberTargets();

        for (String number : numbers) {
            Map<String, String> values = new HashMap<>();
            values.put("numberSource", number);
            values.put("message", messageGroupDto.getMessage());

            String url = "http://localhost:8080/api/receiveMessage/" + number;

            String requestBody = this.createRequestBody(values);

            final HttpRequest httpRequest = RestAPIs.postRequest(url, requestBody);

            RestAPIs.sendRequest(httpRequest);
        }
        return "Done";
    }

    private String createRequestBody(Map<String, String> values) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(values);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
