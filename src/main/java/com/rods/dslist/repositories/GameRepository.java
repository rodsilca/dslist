package com.rods.dslist.repositories;

import com.rods.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;


//CAmada de acesso a dados
public interface GameRepository extends JpaRepository<Game,Long> {

}
