/**
 * Класс для расчета депозита.
 *
 * @author Artyom Shepelev
 * @version 0.3.1
 */
public class CountDeposit {
    // Поля класса
    private double sumWithPercents = 0;
    private double earnings = 0;
    private double funds = 0;
    private int depositDaysAmount = 0;
    private int interestRate = 0;
    TypesOfYears typesOfYears;

    /**
     * Конструктор класса CountDeposit.
     *
     * @param funds               сумма депозита (вклад) в рублях
     * @param depositDaysAmount   количество дней депозита
     * @param interestRate        процентная ставка
     * @param typesOfYears        тип года (обычный или високосный)
     */
    public CountDeposit(double funds, int depositDaysAmount, int interestRate, TypesOfYears typesOfYears) {
        this.funds = funds;
        this.depositDaysAmount = depositDaysAmount;
        this.interestRate = interestRate;
        this.typesOfYears = typesOfYears;
    }

    /**
     * Метод для получения суммы с процентами.
     *
     * @return сумма с процентами
     */
    public double getSumWithPercents() {
        return sumWithPercents;
    }

    /**
     * Метод для установки суммы с процентами.
     *
     * @param sumWithPercents сумма с процентами
     */
    public void setSumWithPercents(double sumWithPercents) {
        this.sumWithPercents = sumWithPercents;
    }

    /**
     * Метод для получения дохода.
     *
     * @return доход
     */
    public double getEarnings() {
        return earnings;
    }

    /**
     * Метод для установки дохода.
     *
     * @param earnings доход
     */
    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    /**
     * Метод для получения суммы депозита.
     *
     * @return сумма депозита
     */
    public double getFunds() {
        return funds;
    }

    /**
     * Метод для получения процентной ставки.
     *
     * @return процентная ставка
     */
    public int getInterestRate() {
        return interestRate;
    }

    /**
     * Метод для установки суммы депозита.
     *
     * @param funds сумма депозита
     */
    public void setFunds(double funds) {
        this.funds = funds;
    }

    /**
     * Метод для получения количества дней депозита.
     *
     * @return количество дней депозита
     */
    public int getDepositDays() {
        return depositDaysAmount;
    }

    /**
     * Метод для установки количества дней депозита.
     *
     * @param depositDaysAmount количество дней депозита
     */
    public void setDepositDays(int depositDaysAmount) {
        this.depositDaysAmount = depositDaysAmount;
    }

    /**
     * Метод для получения типа года (обычный или високосный).
     *
     * @return тип года
     */
    public TypesOfYears getTypesOfYears() {
        return typesOfYears;
    }

    /**
     * Метод для установки типа года (обычный или високосный).
     *
     * @param typesOfYears тип года
     */
    public void setTypesOfYears(TypesOfYears typesOfYears) {
        this.typesOfYears = typesOfYears;
    }

    /**
     * Метод для установки процентной ставки.
     *
     * @param interestRate процентная ставка
     */
    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Метод для расчета дохода.
     *
     * @return доход
     */
    public double countEarnings() {
        this.earnings = (funds * interestRate * depositDaysAmount) / TypesOfYears.LEAP_YEAR.getTypeOfYear() / 100;
        return this.earnings;
    }

    /**
     * Метод для расчета суммы с процентами.
     *
     * @return сумма с процентами
     */
    public double countSumWithPercents() {
        this.sumWithPercents = funds + (funds * interestRate * depositDaysAmount) / TypesOfYears.LEAP_YEAR.getTypeOfYear() / 100;
        return this.sumWithPercents;
    }
}
