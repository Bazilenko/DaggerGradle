package org.kifiukvasyl;

import org.kifiukvasyl.Entity.Match;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.kifiukvasyl.Printer.print;

public class MenuScan {
    private final Scanner scanner;

    public MenuScan(){
        this.scanner = new Scanner(System.in);
    }

    public Match createMatch(){
        print("Enter name of the game:");
        String name = scanner.nextLine();

        print("Enter result (win/lose)");
        String result = scanner.nextLine();

        print("Enter date of played match (dd/MM/yyyy):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        return new Match(name, result, date);

    }

}
