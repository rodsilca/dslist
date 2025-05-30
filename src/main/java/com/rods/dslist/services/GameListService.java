package com.rods.dslist.services;

import com.rods.dslist.dto.GameListDTO;
import com.rods.dslist.entities.GameList;
import com.rods.dslist.projections.GameMinProjection;
import com.rods.dslist.repositories.GameListRepository;
import com.rods.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//CAMADA DE SERVICO

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findALL(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x->new GameListDTO(x)).toList();
        return dto;
        //OR
        //return result.stream().map(x->new GameMinDTo(x)).toList();

    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; //ou Math.min(souceIndex,destinatioIndex)
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i<=max; i++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
            //listId = 2, list.get(i).getId() = 7, newPosistion = 1
            //vai pegar o jogo 7 da lista 2 e colocar na posicao 1
            //cada laco vai pegar a lista e id do jogo e colocar na posicao nova
        }
    }
}
