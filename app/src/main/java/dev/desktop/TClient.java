package dev.desktop;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TClient {
    // change as needed
    public static final String version = "0.1";

    protected static String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">");
        return scanner.nextLine().replace(" ", "");
    }

    protected static void mainMenu() {
        System.out.println("T(est)Client v" + version);
        System.out.println("To load a test, use 1\nTo quit TClient, use 2");
        String n = input();
        if (n.equalsIgnoreCase("1")) {
            try {
                loadTestBank();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }

    protected static void loadTestBank() throws InterruptedException {
        System.out.println("To open a test bank, please enter it's directory.");
        Thread.sleep(500);
        try {
            File dir = new File(input());
            if (!dir.isDirectory()) {
                System.out.println("The provided path is not a directory.");
                loadTestBank();
                return;
            }

            StringBuilder content = new StringBuilder();
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                content.append(scanner.nextLine()).append("\n");
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            }
            lex(content.toString());

        } catch (NullPointerException e) {
            System.out
                    .println("The selected test bank could not be found. Are you sure you entered the absolute path?");
            loadTestBank();
        }

    }

    private static void lex(String content) {
        // todo
    }
}
