package com.rods.dslist.services;

import com.rods.dslist.dto.GameListDTO;
import com.rods.dslist.entities.GameList;
import com.rods.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//CAMADA DE SERVICO

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findALL(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x->new GameListDTO(x)).toList();
        return dto;
        //OR
        //return result.stream().map(x->new GameMinDTo(x)).toList();

    }
}
