package org.kifiukvasyl;

import org.kifiukvasyl.Entity.Match;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

import static org.kifiukvasyl.Entity.Filter.filterByDate;
import static org.kifiukvasyl.Entity.Filter.filterByGame;

public class Printer {
    private final String DESCRIPTION_MAIN = """
            Welcome to main menu!!!
            Choose option:
            1.Show full match history.
            2.Search match history by game.
            3.Search match history by date.
            4.Add match.
            5.Delete match.
            6.Sort by parameter match history.
            Enter exit to stop the program!!!
            """;

    private final String GAME_HEADER = " |GAME|" + " |RESULT|" + "|DATE|";

    @Inject
    public Printer() {
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public void printMain() {
        print(this.DESCRIPTION_MAIN);
    }

    public void printGameHeader() {
        print(this.GAME_HEADER);
    }

    public void printMatches(List<Match> matches) {
        if (matches.isEmpty())
            print("List of matches is empty!");
        else {
            for (Match m : matches)
                print(m.toString());
        }
    }

    public void printMatchesByGame(List<Match> matches, String game) {
        List<Match> m = filterByGame(matches, game);
        printMatches(m);
    }

    public void printMatchesByDate(List<Match> matches, LocalDate dateStart, LocalDate dateEnd) {
        if (matches.isEmpty())
            print("List of matches is empty!");
        else {
            List<Match> m = filterByDate(matches, dateStart, dateEnd);
            printMatches(m);
        }
    }
}
