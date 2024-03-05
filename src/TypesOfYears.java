/**
 * Перечисление, представляющее типы годов.
 *
 * @author Artyom Shepelev
 * @version 0.0.1
 */
public enum TypesOfYears {
    /**
     * Високосный год (366 дней).
     */
    LEAP_YEAR(366),

    /**
     * Невисокосный год (365 дней).
     */
    NON_LEAP_YEAR(365);

    private final int typeOfYear;

    /**
     * Конструктор перечисления.
     *
     * @param typeOfYear количество дней в году
     */
    TypesOfYears(int typeOfYear) {
        this.typeOfYear = typeOfYear;
    }

    /**
     * Получает количество дней в году.
     *
     * @return количество дней в году
     */
    public int getTypeOfYear() {
        return typeOfYear;
    }
}
