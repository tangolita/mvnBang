package com.julia.bang.game;

import com.julia.bang.data.GamesRepository;
import com.julia.bang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Юлия on 18.12.2016.
 */
@Component
public class SearchSystem  {
   private ArrayBlockingQueue<User> commonQueue;
    private CyclicBarrier commonPlayersBarrier;

    public AtomicInteger getGamesCounter() {
        return gamesCounter;
    }

    private AtomicInteger gamesCounter;

    @Autowired
    private GamesRepository gamesRepository;

    SearchSystem(){
        this.commonPlayersBarrier = new CyclicBarrier(2,new Thread(){
            @Override
            public void run(){
                initGame();
            }
        });
        this.commonQueue = new ArrayBlockingQueue<User>(100);
        gamesCounter= new AtomicInteger(0);
    }

    public void startSearch(){
         new Thread(){
            @Override
            public void run(){
                try {
                    commonPlayersBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initGame(){
        try {
            User user1 = commonQueue.take();
            User user2 = commonQueue.take();
            gamesRepository.addGame(gamesCounter.get(), new Game(user1, user2,gamesCounter.get()));
            user1.setStatus("In game");
            user2.setStatus("In game");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public  void addUserToQueue(User user){
       commonQueue.add(user);
        user.setStatus("Search");
    }
    public User removeUserFromQueue() throws InterruptedException {
        return commonQueue.take();
    }

}
