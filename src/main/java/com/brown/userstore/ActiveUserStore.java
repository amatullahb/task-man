package com.brown.userstore;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.stereotype.Component;

import com.brown.model.Team;
import com.brown.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
public class ActiveUserStore implements HttpSessionBindingListener {
    
    @Getter
    @Setter
    private User user;
    
    @Getter
    @Setter
    private Team team;
    
    @Override
    public void valueBound (HttpSessionBindingEvent event) {
        user = (User) event.getValue();
    }
    
    @Override
    public void valueUnbound (HttpSessionBindingEvent event) {
        user = null;
    }

}
