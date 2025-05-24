package com.rods.dslist.controllers;

import com.rods.dslist.dto.GameMinDTo;
import com.rods.dslist.entities.Game;
import com.rods.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTo> findAll(){
        List<GameMinDTo> result = gameService.findALL();

        return result;
    }
}
