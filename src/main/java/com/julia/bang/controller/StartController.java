package com.julia.bang.controller;

/**
 * Created by Юлия on 09.12.2016.
 */
import com.julia.bang.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@SessionAttributes("user")
public class StartController {
    private AtomicInteger usersCounter;
    @PostConstruct
    public void postConstruct() {
        usersCounter = new AtomicInteger(0);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView start() {
        return new ModelAndView("start", "user", new User ());
    }


    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView main(@ModelAttribute ("user") User user){
        user.setStatus("Online");
        user.setUserId(usersCounter.getAndIncrement());
        return new  ModelAndView("main", "user", user);
    }
}
