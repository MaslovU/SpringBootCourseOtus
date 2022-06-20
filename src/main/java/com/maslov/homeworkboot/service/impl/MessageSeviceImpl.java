package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.service.MessageService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageSeviceImpl implements MessageService {

    private final MessageSource messages;

    public MessageSeviceImpl(MessageSource messages) {
        this.messages = messages;
    }

    @Override
    public String getMessage(String key) {
        return messages.getMessage(key, null, Locale.getDefault());
    }

    public String getMessage(String name, String lastName, String res) {
        return String.join(" ", getMessage("student"), name, lastName, getMessage("rightAnswers"), res);
    }
}
