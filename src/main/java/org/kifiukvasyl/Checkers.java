package org.kifiukvasyl;

import org.kifiukvasyl.Entity.User;
import org.kifiukvasyl.Users;

import java.util.List;


public class Checkers {
    public static boolean isAdmin(String username){
        return username.contains("admin");
    }

    public static boolean isUserExist(String username, Users users){
        List<User> user = users.getUsers();
        for (User u : user){
            if(u.getUsername().contains(username))
                return true;
        }
        return false;
    }


}
