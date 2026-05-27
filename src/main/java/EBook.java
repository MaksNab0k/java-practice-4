/**
 * Клас EBook описує електронну книгу.
 * Наслідується від Book.
 */
public class EBook extends Book {

    private double fileSize;

    /**
     * Створює електронну книгу.
     *
     * @param title назва
     * @param author автор
     * @param year рік
     * @param price ціна
     * @param pages сторінки
     * @param genre жанр
     * @param fileSize розмір файлу
     */
    public EBook(
            String title,
            String author,
            int year,
            double price,
            int pages,
            BookGenre genre,
            double fileSize
    ) {
        super(
                title,
                author,
                year,
                price,
                pages,
                genre
        );

        setFileSize(fileSize);
    }

    /**
     * @return розмір файлу
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * Встановлює розмір файлу.
     *
     * @param fileSize розмір файлу
     */
    public void setFileSize(double fileSize) {
        if (fileSize <= 0) {
            throw new IllegalArgumentException(
                    "Розмір файлу має бути більшим за 0."
            );
        }

        this.fileSize = fileSize;
    }

    /**
     * Перевизначення для демонстрації поліморфізму.
     */
    @Override
    public String toString() {
        return "EBook -> " +
                super.toString() +
                ", fileSize=" + fileSize + "MB";
    }
}