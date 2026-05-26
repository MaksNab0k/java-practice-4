import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Клас тестів для перевірки валідації Book.
 */
public class BookTest {

    /**
     * Перевіряє кидання винятку при некоректній ціні у сеттері.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidPriceInSetter() {
        Book book = new Book("Kobzar", "Taras Shevchenko", 1840, 250.0, 300);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-10.0);
        });
    }

    /**
     * Перевіряє кидання винятку при некоректних параметрах конструктора.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author", 2020, 100.0, 200);
        });
    }

    /**
     * Перевіряє кидання винятку при некоректній кількості сторінок.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidPagesInSetter() {
        Book book = new Book("Valid title", "Valid author", 2020, 100.0, 200);

        assertThrows(IllegalArgumentException.class, () -> {
            book.setPages(0);
        });
    }
}