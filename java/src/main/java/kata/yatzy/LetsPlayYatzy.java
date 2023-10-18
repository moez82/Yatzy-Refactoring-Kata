package kata.yatzy;

import java.util.Arrays;
import java.util.Scanner;

public class LetsPlayYatzy {

    public static void main(String[] args) {

        // Object to read player choices from console
        Scanner in = new Scanner(System.in);

        printWelcomeMessage();

        Roll roll = readRoll(in);

        Category category = readCategory(in);

        System.out.println("Your roll is : " + Arrays.toString(roll.dice().toArray()));
        System.out.println("Your category is : " + category.name());

        int score = Category.getCategoryByCode(category.code()).score(roll);

        System.out.println("\nYour score is : " + score);
        System.out.println("\nEnd of the game.");

        in.close();

    }

    private static void printWelcomeMessage() {
        System.out.println("Welcome to ");
        System.out.println("____    ____  ___   .___________.________  ____    ____");
        System.out.println("    \\  /   / /   \\  |           |       /  \\   \\  /   /");
        System.out.println(" \\   \\/   / /  ^  \\ `---|  |----`---/  /    \\   \\/   /");
        System.out.println("  \\_    _/ /  /_\\  \\    |  |       /  /      \\_    _/");
        System.out.println("    |  |  /  _____  \\   |  |      /  /----.    |  |");
        System.out.println("    |__| /__/     \\__\\  |__|     /________|    |__|     game !!");
    }

    private static Roll readRoll(Scanner in) {
        System.out.println("\nPlease roll the dice.. type digits separated by commas (Ex: 1, 2, 3, 4, 5)");
        int[] _arrayRoll = null;

        try {
            String _roll = in.nextLine();
            _arrayRoll = Arrays.stream(_roll.split(","))
                .map(String::strip).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            System.err.println("Sorry.. Bad input type!!");
            System.exit(0);
        }
        return new Roll(_arrayRoll);
    }

    private static Category readCategory(Scanner in) {
        System.out.println("\nCool!! Now choose a category.. just type the category code please");
        Category.print();

        int categoryId = 0;
        try {
            categoryId = in.nextInt();
        } catch (Exception e) {
            System.err.println("Sorry.. Bad input type!!");
            System.exit(0);
        }

        return Category.getCategoryByCode(categoryId);
    }
}
