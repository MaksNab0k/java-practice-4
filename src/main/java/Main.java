import java.util.ArrayList;
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
        ArrayList<Book> books = new ArrayList<Book>();

        printHeader();

        boolean running = true;

        while (running) {
            printMenu();

            int choice = readInt(scanner, "Ваш вибір: ");

            switch (choice) {
                case 1:
                    createBook(scanner, books);
                    break;

                case 2:
                    printBooks(books);
                    break;

                case 3:
                    copyFirstBook(books);
                    break;

                case 4:
                    System.out.println("Кількість створених книг: " + Book.getObjectCount());
                    break;

                case 5:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;

                default:
                    System.out.println("Невірний пункт меню.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Виводить інформаційну шапку програми.
     */
    public static void printHeader() {
        System.out.println("Практична робота №6");
        System.out.println("Класи, статичні члени, агрегація, enum");
        System.out.println("Предметна область: книги");
    }

    /**
     * Виводить меню програми.
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести всі об'єкти");
        System.out.println("3. Створити копію першої книги");
        System.out.println("4. Показати кількість створених книг");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Створює нову книгу.
     *
     * @param scanner об'єкт Scanner
     * @param books список книг
     */
    public static void createBook(Scanner scanner, ArrayList<Book> books) {
        try {
            String title = readString(scanner, "Назва книги: ");
            String author = readString(scanner, "Автор книги: ");
            int year = readInt(scanner, "Рік видання: ");
            double price = readDouble(scanner, "Ціна книги: ");
            int pages = readInt(scanner, "Кількість сторінок: ");

            BookGenre genre = readGenre(scanner);

            String publisherName = readString(scanner, "Назва видавництва: ");
            Publisher publisher = new Publisher(publisherName);

            Book book = new Book(
                    title,
                    author,
                    year,
                    price,
                    pages,
                    genre,
                    publisher
            );

            books.add(book);

            System.out.println("Книгу успішно додано.");

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    /**
     * Виводить усі книги.
     *
     * @param books список книг
     */
    public static void printBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Список книг порожній.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    /**
     * Створює копію першої книги.
     *
     * @param books список книг
     */
    public static void copyFirstBook(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Немає книги для копіювання.");
            return;
        }

        Book copiedBook = new Book(books.get(0));
        books.add(copiedBook);

        System.out.println("Копію першої книги створено.");
    }

    /**
     * Зчитує непорожній рядок.
     *
     * @param scanner об'єкт Scanner
     * @param message повідомлення
     * @return введений рядок
     */
    public static String readString(Scanner scanner, String message) {
        String value;

        do {
            System.out.print(message);
            value = scanner.nextLine();

            if (value.trim().isEmpty()) {
                System.out.println("Помилка: рядок не може бути порожнім.");
            }

        } while (value.trim().isEmpty());

        return value;
    }

    /**
     * Зчитує ціле число.
     *
     * @param scanner об'єкт Scanner
     * @param message повідомлення
     * @return ціле число
     */
    public static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: потрібно ввести ціле число.");
            }
        }
    }

    /**
     * Зчитує дійсне число.
     *
     * @param scanner об'єкт Scanner
     * @param message повідомлення
     * @return дійсне число
     */
    public static double readDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Помилка: потрібно ввести число.");
            }
        }
    }

    /**
     * Зчитує жанр книги.
     *
     * @param scanner об'єкт Scanner
     * @return жанр книги
     */
    public static BookGenre readGenre(Scanner scanner) {
        while (true) {
            System.out.println("Оберіть жанр:");
            System.out.println("1. FANTASY");
            System.out.println("2. SCIENCE");
            System.out.println("3. NOVEL");
            System.out.println("4. DETECTIVE");
            System.out.println("5. HORROR");

            int choice = readInt(scanner, "Ваш вибір жанру: ");

            switch (choice) {
                case 1:
                    return BookGenre.FANTASY;
                case 2:
                    return BookGenre.SCIENCE;
                case 3:
                    return BookGenre.NOVEL;
                case 4:
                    return BookGenre.DETECTIVE;
                case 5:
                    return BookGenre.HORROR;
                default:
                    System.out.println("Помилка: такого жанру немає.");
                    break;
            }
        }
    }
}