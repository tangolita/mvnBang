package com.julia.bang.data;

import com.julia.bang.game.Game;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by Юлия on 18.12.2016.
 */
@Component
public class GamesRepository {

    private  HashMap<Integer, Game> listOfGames;

    public GamesRepository() {
        this.listOfGames = new HashMap<Integer, Game>();
    }

    public HashMap<Integer, Game> getListOfGames() {
        return listOfGames;
    }
    public void setListOfGames(HashMap<Integer, Game> listOfGames) {
        this.listOfGames = listOfGames;
    }
    public void addGame(int ind, Game game ){
        listOfGames.put(ind, game);
    }

}
