package com.erenkov.bac;

import java.util.Random;

public class Game {
    boolean isWin;
    int count;
    String hiddenNumStr;
    String userNumStr;


    public Game() {
        this.setCount(0);
        this.setIsWin(false);
    }


    public boolean isWin() {
        return isWin;
    }

    public void setIsWin(boolean win) {
        isWin = win;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getHiddenNumStr() {
        return hiddenNumStr;
    }

    public String getUserNumStr() {
        return userNumStr;
    }

    public void setUserNumStr(String userNumStr) {
        this.userNumStr = userNumStr;
    }

    public void setHiddenNumStr() {
        StringBuilder aHiddenNumStr;
        aHiddenNumStr = new StringBuilder();
        int i=0;                             //Счётчик для цикла

        /*  Компьютер придумывает число  */
        final Random random = new Random();

        aHiddenNumStr.append(random.nextInt(10));
        while (i<3){
            int k =random.nextInt(10);
            if (aHiddenNumStr.indexOf( k + "" ) == -1 ){
                aHiddenNumStr.append( k );
                i++;
            }
        }
        this.hiddenNumStr = aHiddenNumStr.toString();
        System.out.println(hiddenNumStr.toString());  // ОТЛАДКА !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }


    public String tryToWin(String userNumStr){

        int  numberCows  = 0;        // Количество "коров"
        int  numberBulls = 0;        //          и "быков"

        if (hiddenNumStr.toString().equals(userNumStr)) {
            this.setIsWin(true);
            return "4Б0К (Число угадано)";
        }

        for (int i = 0; i < 4; i++) {
            int j = hiddenNumStr.toString().indexOf(userNumStr.charAt(i));

            if (j == -1) {
                continue;
            }

            if (j == i) {
                numberBulls++;
            } else {
                numberCows++;
            }
        }

        return numberBulls + "Б" + numberCows + "К";
    }



}
