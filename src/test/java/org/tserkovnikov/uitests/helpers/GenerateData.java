package org.tserkovnikov.uitests.helpers;

import java.util.Random;

public class GenerateData {

    // генерирую случайный тег для создания поста (с однинаковым названиям новый пост не появляется - отображается уже созданный)
    public static String getRandomTitle(){
        Random rnd = new Random();
        int tagNumber = rnd.nextInt(10000);
        return "title #"+tagNumber;
    }
}
