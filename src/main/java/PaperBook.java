/**
 * Клас PaperBook описує паперову книгу.
 * Наслідується від Book.
 */
public class PaperBook extends Book {

    private String coverType;

    /**
     * Створює паперову книгу.
     *
     * @param title назва
     * @param author автор
     * @param year рік
     * @param price ціна
     * @param pages сторінки
     * @param genre жанр
     * @param coverType тип обкладинки
     */
    public PaperBook(
            String title,
            String author,
            int year,
            double price,
            int pages,
            BookGenre genre,
            String coverType
    ) {
        super(
                title,
                author,
                year,
                price,
                pages,
                genre
        );

        setCoverType(coverType);
    }

    /**
     * @return тип обкладинки
     */
    public String getCoverType() {
        return coverType;
    }

    /**
     * Встановлює тип обкладинки.
     *
     * @param coverType тип обкладинки
     */
    public void setCoverType(String coverType) {

        if (coverType == null ||
                coverType.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Тип обкладинки не може бути порожнім."
            );
        }

        this.coverType = coverType;
    }

    /**
     * Перевизначення для демонстрації поліморфізму.
     */
    @Override
    public String toString() {
        return "PaperBook -> " +
                super.toString() +
                ", coverType='" +
                coverType + "'";
    }
}