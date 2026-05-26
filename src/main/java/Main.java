import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми.
 * Реалізує консольне меню для роботи з книгами.
 */
public class Main {

    /**
     * Головний метод запуску програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        boolean running = true;

        while (running) {

            printMenu();

            int choice = readInt(scanner);

            switch (choice) {

                case 1:
                    createBook(scanner, books);
                    break;

                case 2:
                    printBooks(books);
                    break;

                case 3:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;

                default:
                    System.out.println("Невірний пункт меню.");
            }
        }

        scanner.close();
    }

    /**
     * Виводить меню.
     */
    public static void printMenu() {

        System.out.println();
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести всі об'єкти");
        System.out.println("3. Завершити роботу");
        System.out.print("Ваш вибір: ");
    }

    /**
     * Створює книгу.
     *
     * @param scanner Scanner
     * @param books список книг
     */
    public static void createBook(
            Scanner scanner,
            ArrayList<Book> books
    ) {

        try {

            System.out.print("Назва: ");
            String title = scanner.nextLine();

            System.out.print("Автор: ");
            String author = scanner.nextLine();

            System.out.print("Рік: ");
            int year = Integer.parseInt(
                    scanner.nextLine()
            );

            System.out.print("Ціна: ");
            double price = Double.parseDouble(
                    scanner.nextLine()
            );

            System.out.print("Сторінки: ");
            int pages = Integer.parseInt(
                    scanner.nextLine()
            );

            Book book =
                    new Book(
                            title,
                            author,
                            year,
                            price,
                            pages
                    );

            books.add(book);

            System.out.println(
                    "Книгу успішно додано."
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Помилка: введено не число."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Помилка: "
                            + e.getMessage()
            );
        }
    }

    /**
     * Виводить список книг.
     *
     * @param books список книг
     */
    public static void printBooks(
            ArrayList<Book> books
    ) {

        if (books.isEmpty()) {

            System.out.println(
                    "Список порожній."
            );

            return;
        }

        for (Book book : books) {

            System.out.println(book);
        }
    }

    /**
     * Зчитує пункт меню.
     *
     * @param scanner Scanner
     * @return номер меню
     */
    public static int readInt(
            Scanner scanner
    ) {

        try {

            return Integer.parseInt(
                    scanner.nextLine()
            );

        } catch (
                NumberFormatException e
        ) {

            return -1;
        }
    }
}