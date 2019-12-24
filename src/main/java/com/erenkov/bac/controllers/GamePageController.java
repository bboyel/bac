package com.erenkov.bac.controllers;

import com.erenkov.bac.GameService;
import com.erenkov.bac.Game;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GamePageController {
    static GameService gameService = new GameService();

    @GetMapping("/gamepage")
    public String view() {
        return "gamepage";
    }

    @RequestMapping(value = "gamepage/game", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Map<String, Object> stepGame(@RequestBody Map<String, Object> model) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        HashMap<String, Object> Data = gameService.runGame(model.get("id").toString(), model.get("userNumStr").toString());
        response.put("status", "success");
        response.put("data", Data);
        return response;
    }

    @RequestMapping(value = "gamepage/game", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody
    String myMethod(@RequestBody Game model) {
        return model.toString();
    }


    @RequestMapping(value = "gamepage/newgame", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Map<String, Object> makeNewGame(@RequestBody Map<String, Object> model) {
        HashMap<String, Object> response = new HashMap<String, Object>();
        response.put("status", "success");
        response.put("data", gameService.newGame(model.get("id").toString()));

        return response;
    }
}
