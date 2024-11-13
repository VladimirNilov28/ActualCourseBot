package com.example.actualcoursebot.service;

import com.example.actualcoursebot.config.BotConfig;
import com.example.actualcoursebot.model.CurrencyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot{
    private BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        CurrencyModel currencyModel = new CurrencyModel();
        String currency = "";
        if(update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start":
                    startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    break;
                default:
                    try {
                        currency = CurrencyService.getCurrencyRate(currency.trim().toUpperCase(), currencyModel);
                    } catch (IOException e) {
                        sendMessage(chatId, "There was an error getting the exchange rate. Please try again later.");
                    }
            }



        }
    }

    private void startCommandReceived(Long chatId, String name) {
        String answer = String.format("""
                Hi, %s, nice to meet you!
                Enter the crypto pair
                For example: BTCUSDT
                """, name);
        sendMessage(chatId, answer);
    }


    private void sendMessage(Long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        }catch (TelegramApiException e) {

        }
    }
}