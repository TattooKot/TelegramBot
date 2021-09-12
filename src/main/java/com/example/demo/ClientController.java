package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public SendMessage getAll(Update update){
        List<Client> clients = clientService.getAll();

        StringBuilder stringBuilder = new StringBuilder();
        clients.forEach(client -> stringBuilder.append(client.toString() + "\n"));

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(stringBuilder.toString());

        return message;
    }
}
