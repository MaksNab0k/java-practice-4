/**
 * Клас видавництва.
 */
public class Publisher {

    private String name;

    /**
     * Конструктор.
     * @param name назва видавництва
     */
    public Publisher(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Назва видавництва не може бути порожньою"
            );
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Назва видавництва не може бути порожньою"
            );
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}