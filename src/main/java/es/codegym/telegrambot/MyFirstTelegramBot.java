package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

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

            //Otorgando Puntos
            setUserGlory(0);

            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera","step_1_btn"));
        }

        //Identificamos el Boton sobre el que se hace Click
        if (getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
                            "¡Tomar un pescado! +20 de fama","step_2_btn",
                            "¡Tirar una lata de pepinillos! +20 de fama","step_2_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackea al Robot Aspirador Zumbador","step_3_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al Robot aspirador por comida! +30 de fama","step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama","step_4_btn",
                            "¡Huir del Robot Aspirador! +30 de fama","step_4_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Obtuviste una mision Gatuna, momento de encender y ponerte la *GoPro* de Michis","step_5_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Inicia una inspeccion del vecindario en busca de actividades paranormales! +40 de fama","step_6_btn",
                            "Dirigete al parque y filma el comportamiento humano con los animales! +40 de fama","step_6_btn",
                            "Graba cual es el Ingrediente secreto de las Pizzas del Sr. Gattuso ! +40 de fama","step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(50);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackea la Contraseña y Proporciona el Material Grabado al Dpto de Inteligencia Gatuno","step_7_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")){
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Guarda tus elementos como detective Gatuno y descansa con tu humano favorito","Final_btn"));
        }

        if (getCallbackQueryButtonKey().equals("Final_btn")){
            sendTextMessageAsync(STEP_8_TEXT);
        }


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

/*
else if(getMessageText().equalsIgnoreCase("Hola")){
            sendTextMessageAsync("Hola *Super Programador*, _cual es tu nombre_?:");
        }
        else if(getMessageText().contains("Mi nombre es")){
            sendTextMessageAsync("_Encantado de Conocerte_ *Super Programador*, yo soy *Gato* ");
        }
 */