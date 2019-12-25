package com.erenkov.bac.services;


import com.erenkov.bac.Game;
import java.util.HashMap;

public class GameService {

    static HashMap<String, Game> gameMap;


    public GameService() {
        gameMap= new HashMap<>();
    }


    public  HashMap<String,Object> runGame(String idUser, String userNumStr) {

        HashMap<String,Object> resultHM = new HashMap<>();
        resultHM.put("message", gameMap.get(idUser).tryToWin(userNumStr));
        resultHM.put("isWin", gameMap.get(idUser).isWin());

        return resultHM;
    }


    public  HashMap<String,Object> newGame(String idUser) {

        if (!gameMap.containsKey(idUser)) {
            gameMap.put(idUser,new Game());
        }

        gameMap.get(idUser).setIsWin(false);
        gameMap.get(idUser).setHiddenNumStr();
        gameMap.get(idUser).setCount(0);

        HashMap<String,Object> resultHM = new HashMap<>();
        resultHM.put("isWin", gameMap.get(idUser).isWin());

        return resultHM;
    }


}
