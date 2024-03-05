import javax.swing.*;
import java.awt.*;

/**
 * Класс для создания GUI калькулятора банковского вклада.
 *
 * @author Artyom Shepelev
 * @version 0.6.1
 */

public class CountDepositGUI {
    /**
     * Поле для ввода суммы вклада.
     */
    private JTextField fundsField;

    /**
     * Поле для ввода количества дней вклада.
     */
    private JTextField depositDaysAmountField;

    /**
     * Поле для ввода процентной ставки.
     */
    private JTextField interestRateField;

    /**
     * Поле для выбора типа года.
     */
    private JComboBox<TypesOfYears> typesOfYearsComboBox;

    /**
     * Метка для отображения прибыли.
     */
    private JLabel earningsLabel;

    /**
     * Метка для отображения суммы с процентами.
     */
    private JLabel sumWithPercentsLabel;

    /**
     * Конструктор класса.
     */
    public CountDepositGUI() {
        // Создание и настройка компонентов интерфейса
        JLabel fundsLabel = new JLabel("Funds:");
        fundsField = new JTextField(10);

        JLabel depositDaysAmountLabel = new JLabel("Deposit Days Amount:");
        depositDaysAmountField = new JTextField(10);

        JLabel interestRateLabel = new JLabel("Interest Rate:");
        interestRateField = new JTextField(10);

        JLabel typesOfYearsLabel = new JLabel("Types of Years:");
        typesOfYearsComboBox = new JComboBox<>(TypesOfYears.values());

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> {
            // Получение введенных значений из текстовых полей
            try {
                double funds = Double.parseDouble(fundsField.getText());
                if (funds < 0) {
                    throw new ArithmeticException("Сумма вклада не может быть отрицательной");
                }

                int depositDaysAmount = Integer.parseInt(depositDaysAmountField.getText());
                if (depositDaysAmount < 0) {
                    throw new ArithmeticException("Количество дней вклада не может быть отрицательным");
                }

                int interestRate = Integer.parseInt(interestRateField.getText());
                if (interestRate < 0) {
                    throw new ArithmeticException("Процентная ставка не может быть отрицательной");
                }

                // Получение типа года из списка
                TypesOfYears typesOfYears = (TypesOfYears) typesOfYearsComboBox.getSelectedItem();

                // Проверка значения типа года
                if (typesOfYears == null) {
                    throw new NullPointerException("Тип года не должен быть null");
                }

                // Создание экземпляра класса CountDeposit с введенными параметрами
                CountDeposit countDeposit = new CountDeposit(funds, depositDaysAmount, interestRate, typesOfYears);

                // Рассчет прибыли и суммы с процентами
                double earnings = countDeposit.countEarnings();
                double sumWithPercents = countDeposit.countSumWithPercents();

                // Отображение результатов на метках
                earningsLabel.setText(String.format("Earnings: %.2f", earnings));
                sumWithPercentsLabel.setText(String.format("Sum with Percents: %.2f", sumWithPercents));
            } catch (NumberFormatException e1) {
                // Обработать исключение
                JOptionPane.showMessageDialog(null, "Неправильный формат данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (ArithmeticException e2) {
                // Обработать исключение
                JOptionPane.showMessageDialog(null, "Некорректное значение", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
        });

        earningsLabel = new JLabel();
        sumWithPercentsLabel = new JLabel();

        // Создание главной панели
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.add(fundsLabel);
        panel.add(fundsField);
        panel.add(depositDaysAmountLabel);
        panel.add(depositDaysAmountField);
        panel.add(interestRateLabel);
        panel.add(interestRateField);
        panel.add(typesOfYearsLabel);
        panel.add(typesOfYearsComboBox);
        panel.add(calculateButton);
        panel.add(new JLabel());
        panel.add(earningsLabel);
        panel.add(sumWithPercentsLabel);

        // Создание окна
        JFrame frame = new JFrame("Bank Deposit Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CountDepositGUI();
            }
        });
    }
}