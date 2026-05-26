/**
 * Клас Book описує книгу з базовими характеристиками.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    private double price;
    private int pages;

    public Book(String title, String author, int year, double price, int pages) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPrice(price);
        setPages(pages);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою.");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор книги не може бути порожнім.");
        }
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 0 || year > 2026) {
            throw new IllegalArgumentException("Рік видання має бути від 1 до 2026.");
        }
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна книги має бути більшою за 0.");
        }
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Кількість сторінок має бути більшою за 0.");
        }
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return year == book.year &&
                Double.compare(book.price, price) == 0 &&
                pages == book.pages &&
                title.equals(book.title) &&
                author.equals(book.author);
    }
}