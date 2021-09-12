package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private final ClientController controller;

    public Bot(ClientController controller) {
        this.controller = controller;
    }

    @Override
    public String getBotUsername() {
        return "Tk_testBot";
    }

    @Override
    public String getBotToken() {
        return "1972022499:AAFDNdVth4-VMg-RkwyrX2zug6UWAcuQAvE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String request = update.getMessage().getText();

            if(request.equals("/get_all"))
                send(controller.getAll(update));

            if(request.equals("jjj")){

            }

        }

    }

    public void send(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
