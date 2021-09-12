package com.example.demo;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class ClientModel {

    private final ClientService clientService;

    public ClientModel(ClientService clientService) {
        this.clientService = clientService;
    }

    public SendMessage getAll(Update update){
        List<Client> clients = clientService.getAll();

        StringBuilder stringBuilder = new StringBuilder();
        clients.forEach(client -> stringBuilder.append(String.format("%s: %d", client.getName(), client.getCount())).append("\n"));

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText(stringBuilder.toString());

        return message;
    }

    public SendMessage getById(Update update){
        String request = update.getMessage().getText();
        String chatId = update.getMessage().getChatId().toString();

        if(request.length() <= 3 || request.length() > 6)
            return new SendMessage(chatId,"Щоб отримати інформацію, виконай команду id {id}");

        String stringId = request.substring(3);
        if(!stringId.matches("[0-9]+"))
            return new SendMessage(chatId,"Id це тільки цифри, спробуй ще раз! \n");

        int id = Integer.parseInt(stringId);
        if(!clientService.checkById(id))
            return new SendMessage(chatId,"Id не знайдено, спробуй ще раз! \n");

        return new SendMessage(chatId,clientService.getById(id).toString());
    }
}
