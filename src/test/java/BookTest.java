import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тести для Book.
 */
public class BookTest {

    @Test
    public void shouldThrowExceptionWhenInvalidPriceInSetter() {

        Book book = new Book(
                "Kobzar",
                "Taras Shevchenko",
                1840,
                250,
                300,
                BookGenre.NOVEL
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> book.setPrice(-10)
        );
    }

    @Test
    public void shouldThrowExceptionWhenInvalidConstructorData() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Book(
                        "",
                        "Author",
                        2020,
                        100,
                        200,
                        BookGenre.FANTASY
                )
        );
    }

    @Test
    public void shouldThrowExceptionWhenInvalidPagesInSetter() {

        Book book = new Book(
                "Valid",
                "Author",
                2020,
                100,
                200,
                BookGenre.SCIENCE
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> book.setPages(0)
        );
    }
}