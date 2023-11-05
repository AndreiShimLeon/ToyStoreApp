package view;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void print(String message){
        System.out.println(message);
    }

}

