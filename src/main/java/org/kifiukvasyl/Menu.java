package org.kifiukvasyl;

import org.kifiukvasyl.Entity.Match;
import javax.inject.Inject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.kifiukvasyl.Printer.print;

public class Menu {
    private final Scanner scanner;
    private List<Match> matches;
    private final MenuScan menuScan;
    private final Printer printer;
    private final Jackson jackson;

    @Inject
    public Menu(MenuScan menuScan, Printer printer, Jackson jackson){
        this.scanner = new Scanner(System.in);
        this.matches = new ArrayList<>();
        this.menuScan = menuScan;
        this.printer = printer;
        this.jackson = jackson;
    }

    public void menu() {
        String command;
        matches = jackson.readFromFile("matchesInfo");

        do {
            printer.printMain();
            command = scanner.nextLine();
            switch (command) {
                case "1" -> {
                    if (matches.isEmpty()) {
                        System.out.println("List of matches is empty!!!");
                    } else {
                        printer.printGameHeader();
                        printer.printMatches(matches);
                    }
                }
                case "2" -> {
                    print("Enter game to show matches:");
                    printer.printMatchesByGame(matches, scanner.nextLine());
                }
                case "3" -> {
                    print("Enter date from to to show matches: ");
                    LocalDate startDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate endDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    printer.printMatchesByDate(matches, startDate, endDate);
                }
                case "4" -> {
                    matches.add(menuScan.createMatch());
                }
                case "exit" ->
                    System.out.println("Exiting...");
                default -> print("Invalid command!");

            }

        }
        while (!command.equals("exit"));
        jackson.writeToFile("matchesInfo", matches);
    }

}
