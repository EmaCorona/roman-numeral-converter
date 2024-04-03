package romanconverter;

import romanconverter.converter.IntegerToRomanConverter;
import romanconverter.util.ApplicationConst;
import romanconverter.util.ApplicationConst.Menu;

import java.util.Scanner;

public class Application {
    private static final int EXIT = 0;
    private static final int INTEGER_TO_ROMAN = 1;
    private static final int ROMAN_TO_INTEGER = 2;
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            int choice = showMenu();

            switch (choice) {
                case EXIT: {
                    return;
                }
                case INTEGER_TO_ROMAN: {
                    printIntegerToRomanMenu();
                    break;
                }
                case ROMAN_TO_INTEGER: {
                    System.out.println("ROMAN_TO_INTEGER");
                    break;
                }
            }
        }
    }

    private static int showMenu() {
        System.out.println(Menu.HEADER);
        System.out.println(Menu.EXIT);
        System.out.println(Menu.ROMAN_TO_INTEGER);
        System.out.println(Menu.INTEGER_TO_ROMAN + ApplicationConst.NEW_LINE);
        System.out.print(Menu.OPTION_SELECTION);

        int choice;

        while (!scanner.hasNextInt() || ((choice = scanner.nextInt()) < 0 || choice > 2)) {
            System.err.print(Menu.OPTION_NOT_VALID);
            scanner.next(); // Consuma l'input non valido
        }

        return choice;
    }

    private static void printIntegerToRomanMenu() {
        System.out.print(ApplicationConst.NEW_LINE + "Insert a number to convert: ");

        while (!scanner.hasNextInt()) {
            System.err.print(Menu.OPTION_NOT_VALID);
            scanner.next(); // Consuma l'input non valido
        }

        String romanNumber = convertIntegerToRoman(scanner.nextInt());
        System.out.println("Result of conversion: " + romanNumber + ApplicationConst.NEW_LINE);
    }

    private static String convertIntegerToRoman(int number) {
        IntegerToRomanConverter converter = new IntegerToRomanConverter(number);
        return converter.convert();
    }
}