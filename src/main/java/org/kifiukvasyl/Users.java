package org.kifiukvasyl;

import org.kifiukvasyl.Entity.User;

import java.util.ArrayList;
import java.util.List;


public class Users {
    public final List<User> users;

    public Users(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(String username){

    }

    public static void changePassword(String username, String oldPassword, String newPassword, Users users){
        User user = users.getUserByUsernamePassword(username, oldPassword);
        if(user != null)
            user.setPassword(newPassword);
        else System.out.println("Wrong username or password!");

    }

    public User getUserByUsernamePassword(String username, String password){
        for(User u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password))
                return u;
        }
        return null;
    }

    public User getUserByUsername(String username){
        for(User u : users){
            if(u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public List<User> getUsers(){
        return this.users.stream().toList();
    }

}
