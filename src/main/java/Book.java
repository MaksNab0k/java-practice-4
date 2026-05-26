/**
 * Клас Book описує книгу з базовими характеристиками.
 */
public class Book {

    private static int objectCount = 0;

    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;
    private BookGenre genre;
    private Publisher publisher;

    /**
     * Створює об'єкт книги.
     *
     * @param title назва книги
     * @param author автор книги
     * @param year рік видання
     * @param price ціна книги
     * @param pages кількість сторінок
     * @param genre жанр книги
     * @param publisher видавництво книги
     */
    public Book(
            String title,
            String author,
            int year,
            double price,
            int pages,
            BookGenre genre,
            Publisher publisher
    ) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPrice(price);
        setPages(pages);
        setGenre(genre);
        setPublisher(publisher);

        objectCount++;
    }

    /**
     * Конструктор копіювання.
     *
     * @param other книга, яку потрібно скопіювати
     */
    public Book(Book other) {
        if (other == null) {
            throw new IllegalArgumentException("Книга для копіювання не може бути null.");
        }

        setTitle(other.title);
        setAuthor(other.author);
        setYear(other.year);
        setPrice(other.price);
        setPages(other.pages);
        setGenre(other.genre);
        setPublisher(other.publisher);

        objectCount++;
    }

    /**
     * Повертає кількість створених об'єктів Book.
     *
     * @return кількість створених книг
     */
    public static int getObjectCount() {
        return objectCount;
    }

    /**
     * @return назва книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Встановлює назву книги.
     *
     * @param title назва книги
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою.");
        }

        this.title = title;
    }

    /**
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Встановлює автора книги.
     *
     * @param author автор книги
     */
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор книги не може бути порожнім.");
        }

        this.author = author;
    }

    /**
     * @return рік видання
     */
    public int getYear() {
        return year;
    }

    /**
     * Встановлює рік видання.
     *
     * @param year рік видання
     */
    public void setYear(int year) {
        if (year <= 0 || year > 2026) {
            throw new IllegalArgumentException("Рік видання має бути від 1 до 2026.");
        }

        this.year = year;
    }

    /**
     * @return ціна книги
     */
    public double getPrice() {
        return price;
    }

    /**
     * Встановлює ціну книги.
     *
     * @param price ціна книги
     */
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна книги має бути більшою за 0.");
        }

        this.price = price;
    }

    /**
     * @return кількість сторінок
     */
    public int getPages() {
        return pages;
    }

    /**
     * Встановлює кількість сторінок.
     *
     * @param pages кількість сторінок
     */
    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Кількість сторінок має бути більшою за 0.");
        }

        this.pages = pages;
    }

    /**
     * @return жанр книги
     */
    public BookGenre getGenre() {
        return genre;
    }

    /**
     * Встановлює жанр книги.
     *
     * @param genre жанр книги
     */
    public void setGenre(BookGenre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Жанр книги не може бути null.");
        }

        this.genre = genre;
    }

    /**
     * @return видавництво книги
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * Встановлює видавництво книги.
     *
     * @param publisher видавництво книги
     */
    public void setPublisher(Publisher publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("Видавництво не може бути null.");
        }

        this.publisher = publisher;
    }

    /**
     * Формує текстову інформацію про книгу.
     *
     * @return інформація про книгу
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", pages=" + pages +
                ", genre=" + genre +
                ", publisher=" + publisher +
                '}';
    }

    /**
     * Порівнює книги між собою.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо книги однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return year == book.year
                && Double.compare(book.price, price) == 0
                && pages == book.pages
                && title.equals(book.title)
                && author.equals(book.author)
                && genre == book.genre
                && publisher.equals(book.publisher);
    }
}