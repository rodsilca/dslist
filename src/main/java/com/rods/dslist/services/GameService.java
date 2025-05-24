package com.rods.dslist.services;

import com.rods.dslist.dto.GameMinDTo;
import com.rods.dslist.entities.Game;
import com.rods.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTo> findALL(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTo> dto = result.stream().map(x->new GameMinDTo(x)).toList();
        return dto;
        //OR
        //return result.stream().map(x->new GameMinDTo(x)).toList();

    }
}
