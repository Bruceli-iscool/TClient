package dev.desktop;
import java.util.Scanner;
public class TClient {
    // change as needed
    public static final String version = "0.1";
    protected static String input() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(">");
            return scanner.nextLine().replace(" ", "");
        }
    }
    protected static void mainMenu() {
        System.out.println("T(est)Client v" + version);
        System.out.println("To load a test, use 1\nTo quit TClient, use 2");
        String n = input();
        if (n.equalsIgnoreCase("1")) {
            loadTestBank();
        } else {
            System.exit(0);
        }
    }
    protected static void loadTestBank() {
        // todo
    }
}
