package com.julia.bang.game;

import com.julia.bang.model.User;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Юлия on 18.12.2016.
 */
public class Game {
    User user1;
    User user2;

    public Game(User user1, User user2, Integer gameId) {
        this.user1 = user1;
        this.user2 = user2;
        this.gameId = gameId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    Integer gameId;
    Game(){}

}
