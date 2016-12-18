package com.julia.bang.data;

import com.julia.bang.game.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

/**
 * Created by Юлия on 18.12.2016.
 */
@Repository
public class GamesRepository {


    private static HashMap<Integer, Game> listOfGames = new HashMap<Integer, Game>();

    public static void addGame(Integer gameId, Game game){
        listOfGames.put(gameId, game);
    }
    public static Game getGame(Integer gameId){
        return listOfGames.get(gameId);
    }
}
