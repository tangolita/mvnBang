package com.julia.bang.model;

import com.julia.bang.game.SearchSystem;
import org.springframework.stereotype.Component;

/**
 * Created by Юлия on 17.12.2016.
 */
@Component
public class User {
    private Integer userId;
    private String name;
    private String status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
