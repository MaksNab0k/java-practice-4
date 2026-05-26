/**
 * Клас Publisher описує видавництво книги.
 * Використовується в класі Book як приклад агрегації.
 */
public class Publisher {

    private String name;

    /**
     * Створює об'єкт видавництва.
     *
     * @param name назва видавництва
     */
    public Publisher(String name) {
        setName(name);
    }

    /**
     * Повертає назву видавництва.
     *
     * @return назва видавництва
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву видавництва.
     *
     * @param name назва видавництва
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва видавництва не може бути порожньою.");
        }

        this.name = name;
    }

    /**
     * Формує текстове представлення видавництва.
     *
     * @return текстова інформація про видавництво
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Порівнює два видавництва.
     *
     * @param obj об'єкт для порівняння
     * @return true, якщо видавництва однакові
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Publisher publisher = (Publisher) obj;

        return name.equals(publisher.name);
    }
}