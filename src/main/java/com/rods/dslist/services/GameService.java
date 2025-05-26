package com.rods.dslist.services;

import com.rods.dslist.dto.GameDTO;
import com.rods.dslist.dto.GameMinDTo;
import com.rods.dslist.entities.Game;
import com.rods.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//CAMADA DE SERVICO

@Service
public class GameService  {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId){
        Game result = gameRepository.findById(gameId).get();
        GameDTO dto = new GameDTO(result);

        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTo> findALL(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTo> dto = result.stream().map(x->new GameMinDTo(x)).toList();
        return dto;
        //OR
        //return result.stream().map(x->new GameMinDTo(x)).toList();

    }
}
