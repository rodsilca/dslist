package com.rods.dslist.controllers;

import com.rods.dslist.dto.GameDTO;
import com.rods.dslist.dto.GameListDTO;
import com.rods.dslist.dto.GameMinDTo;
import com.rods.dslist.dto.ReplacementDTO;
import com.rods.dslist.services.GameListService;
import com.rods.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//CONTROLADOR REST

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findALL();

        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTo> findByList(@PathVariable Long listId){
        List<GameMinDTo> result = gameService.findByList(listId);

        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}
