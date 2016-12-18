package com.julia.bang.game;

import com.julia.bang.data.GamesRepository;
import com.julia.bang.model.User;

/**
 * Created by Юлия on 18.12.2016.
 */
public class GameInitializer extends Thread {
    private static Integer gamesCounter = 0;

    @Override
    public void run() {
        super.run();

        try {
           User user1 = SearchSystem.removeUserFromQueue();
            User user2 = SearchSystem.removeUserFromQueue();
            GamesRepository.addGame(gamesCounter, new Game(user1, user2, gamesCounter));
            gamesCounter++;
            user1.setStatus("In game");
            user2.setStatus("In game");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
