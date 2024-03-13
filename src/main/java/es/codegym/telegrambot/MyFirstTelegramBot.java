package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeGymMaratonBotDidierM_bot";
    public static final String TOKEN = "7181177768:AAE2Ij7szJXLsogLmTlwgYPwOnZD2oRS2fw";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")) {
            sendTextMessageAsync("Hola _futuro_ *Programador*");
        }
        else if(getMessageText().equalsIgnoreCase("Hola")){
            sendTextMessageAsync("Hola *Super Programador*, _cual es tu nombre_?:");
        }
        else if(getMessageText().contains("Mi nombre es")){
            sendTextMessageAsync("_Encantado de Conocerte_ *Super Programador*, yo soy *Gato* ");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}