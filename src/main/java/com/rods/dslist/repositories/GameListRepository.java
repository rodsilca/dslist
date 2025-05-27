package com.rods.dslist.repositories;

import com.rods.dslist.entities.Game;
import com.rods.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;


//CAmada de acesso a dados
public interface GameListRepository extends JpaRepository<GameList,Long> {

}
