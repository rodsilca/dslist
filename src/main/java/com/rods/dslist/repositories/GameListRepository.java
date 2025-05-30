package com.rods.dslist.repositories;

import com.rods.dslist.entities.Game;
import com.rods.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


//CAmada de acesso a dados
public interface GameListRepository extends JpaRepository<GameList,Long> {
    @Modifying //tem que colocar o modifying se o comando sql que vc der tiver UPDATE, INSERT, DELETE etc
    @Query(nativeQuery = true,
        value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
