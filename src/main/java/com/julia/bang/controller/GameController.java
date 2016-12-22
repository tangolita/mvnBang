package com.julia.bang.controller;

import com.julia.bang.data.GamesRepository;
import com.julia.bang.game.Game;
import com.julia.bang.game.SearchSystem;
import com.julia.bang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Юлия on 18.12.2016.
 */
@Controller
@SessionAttributes({"user", "game"})
public class GameController {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private SearchSystem searchSystem;

    public SearchSystem getSearchSystem() {
        return searchSystem;
    }

    public void setSearchSystem(SearchSystem searchSystem) {
        this.searchSystem = searchSystem;
    }

    public GamesRepository getGamesRepository() {
        return gamesRepository;
    }

    public void setGamesRepository(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute ("user") User user){
        if (user.getStatus().equals("Online")){
            searchSystem.addUserToQueue(user);
            searchSystem.startSearch();
        }
        if (user.getStatus().equals("Search")) {
            return new ModelAndView("waiting", "user", user);
        }
        else{
            Game game = gamesRepository.getListOfGames().get(searchSystem.getGamesCounter().get());
            return new ModelAndView("redirect: game", "game", game);}
    }

    @RequestMapping(value = "/game")
    public String game() {
        return "game";
    }

}

