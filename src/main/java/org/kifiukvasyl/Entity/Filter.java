package org.kifiukvasyl.Entity;

import java.time.LocalDate;
import java.util.List;

public class Filter {
    public static List<Match> filterByGame(List<Match> matches, String game) {
        return matches.stream().filter(n -> n.getGame().equals(game)).toList();
    }

    public static List<Match> filterByDate(List<Match> matches, LocalDate dateStart, LocalDate dateEnd) {
        return matches.stream().filter(m -> m.getDate().isAfter(dateStart) && m.getDate().isBefore(dateEnd)).toList();
    }
}
