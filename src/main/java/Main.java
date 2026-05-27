import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<Book>();

        boolean running = true;

        while (running) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Додати Book");
            System.out.println("2. Додати EBook");
            System.out.println("3. Додати PaperBook");
            System.out.println("4. Показати всі книги");
            System.out.println("5. Вихід");

            int choice = readInt(scanner);

            switch (choice) {

                case 1:
                    books.add(createBook(scanner));
                    break;

                case 2:
                    books.add(createEBook(scanner));
                    break;

                case 3:
                    books.add(createPaperBook(scanner));
                    break;

                case 4:

                    if (books.isEmpty()) {
                        System.out.println("Список порожній.");
                    }

                    for (Book book : books) {
                        System.out.println(book);
                    }

                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Невірний пункт.");
            }
        }

        scanner.close();
    }

    public static Book createBook(Scanner scanner) {

        return new Book(
                readString(scanner, "Назва: "),
                readString(scanner, "Автор: "),
                readInt(scanner, "Рік: "),
                readDouble(scanner, "Ціна: "),
                readInt(scanner, "Сторінки: "),
                BookGenre.NOVEL
        );
    }

    public static EBook createEBook(
            Scanner scanner
    ) {

        return new EBook(
                readString(scanner, "Назва: "),
                readString(scanner, "Автор: "),
                readInt(scanner, "Рік: "),
                readDouble(scanner, "Ціна: "),
                readInt(scanner, "Сторінки: "),
                BookGenre.SCIENCE,
                readDouble(scanner, "Розмір файлу MB: ")
        );
    }

    public static PaperBook createPaperBook(
            Scanner scanner
    ) {

        return new PaperBook(
                readString(scanner, "Назва: "),
                readString(scanner, "Автор: "),
                readInt(scanner, "Рік: "),
                readDouble(scanner, "Ціна: "),
                readInt(scanner, "Сторінки: "),
                BookGenre.FANTASY,
                readString(scanner, "Тип обкладинки: ")
        );
    }

    public static String readString(
            Scanner scanner,
            String text
    ) {

        while (true) {

            System.out.print(text);

            String value =
                    scanner.nextLine();

            if (!value.trim().isEmpty()) {
                return value;
            }

            System.out.println(
                    "Поле не може бути порожнім."
            );
        }
    }

    public static int readInt(
            Scanner scanner
    ) {

        return readInt(
                scanner,
                "Введіть число: "
        );
    }

    public static int readInt(
            Scanner scanner,
            String text
    ) {

        while (true) {

            try {

                System.out.print(text);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (
                    NumberFormatException e
            ) {

                System.out.println(
                        "Некоректне число."
                );
            }
        }
    }

    public static double readDouble(
            Scanner scanner,
            String text
    ) {

        while (true) {

            try {

                System.out.print(text);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (
                    NumberFormatException e
            ) {

                System.out.println(
                        "Некоректне число."
                );
            }
        }
    }
}