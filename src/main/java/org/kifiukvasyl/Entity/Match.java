package org.kifiukvasyl.Entity;

import java.time.LocalDate;

public class Match {
    private String game;
    private String result; // win (w) / lose (l)
    private LocalDate date;

    public Match(){}

    public Match(String game, String result, LocalDate date){
        this.game = game;
        this.result = result;
        this.date = date;
    }

    public String getGame() {
        return game;
    }

    public LocalDate getDate() {
        return date;
    }
    public String getResult(){
        return result;
    }

    @Override
    public String toString(){
        return (this.getGame() + " " +
                this.result + " " +
                this.date);
    }

}
