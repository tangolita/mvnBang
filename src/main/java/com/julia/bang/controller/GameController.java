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

/**
 * Created by Юлия on 18.12.2016.
 */
@Controller
@SessionAttributes({"user", "game"})
public class GameController {

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute ("user") User user){
        if (user.getStatus().equals("Online")){
            SearchSystem searchSystem = new SearchSystem();
            searchSystem.addUserToQueue(user);
            searchSystem.start();
        }
        if (user.getStatus().equals("Search")) {
            return new ModelAndView("waiting", "user", user);
        }
        else{
            Game game = GamesRepository.getGame(0);
            return new ModelAndView("redirect: game", "game", game);}
    }

    @RequestMapping(value = "/game")
    public String game() {
        return "game";
    }

}
