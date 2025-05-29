package org.kifiukvasyl.Entity;

public class User {
    private String username;
    private String password;

    private boolean isAdmin = false;

    public User(String username, String password){
        if(username.contains("admin"))
            isAdmin = true;
        this.username = username;
        this.password = password;
    }


    public void setPassword(String password) {
        if(password.length() < 8)
            System.out.println("Password is too weak!!!");
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
