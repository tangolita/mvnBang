package com.julia.bang.game;

import com.julia.bang.model.User;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Юлия on 18.12.2016.
 */
@Component
public class SearchSystem extends Thread {
    private static CyclicBarrier playersBarrier  = new CyclicBarrier(2,new GameInitializer());
    private static ArrayBlockingQueue<User> queue = new ArrayBlockingQueue<User>(100);

    public SearchSystem(){
    }
    @Override
    public void run() {
        try {
            playersBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public  static void addUserToQueue(User user){
        queue.add(user);
        user.setStatus("Search");
    }
    public  static User removeUserFromQueue() throws InterruptedException {
        return  queue.take();
    }

}
