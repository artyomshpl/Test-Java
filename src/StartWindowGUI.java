import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс для создания GUI стартового окна программы.
 *
 * @author Artyom Shepelev
 * @version 0.9.2
 */
public class StartWindowGUI {
    /**
     * Конструктор класса.
     */
    public StartWindowGUI() {
        // Настройка компонентов интерфейса
        JLabel universityLabel = new JLabel("Белорусский Национальный Технический Университет");
        universityLabel.setHorizontalAlignment(SwingConstants.CENTER);
        universityLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel facultyLabel = new JLabel("Факультет информационных технологий и робототехники");
        facultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        facultyLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel departmentLabel = new JLabel("Кафедра программного обеспечения и информационных технологий");
        departmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        departmentLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel courseLabel = new JLabel("<html><div style='text-align: center; font-size: 18pt;'>Курсовая работа по дисциплине \"Программирование на языке Java\"<br>Расчет банковских депозитов</div></html>");
        courseLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel authorLabel = new JLabel("Выполнил: студент группы 10702421\n Шепелев Артем Евгеньевич");
        JLabel teacherLabel = new JLabel("Преподаватель: к.ф-м.н., доц. \n Сидорик Валерий Владимирович");
        JLabel locationLabel = new JLabel("Минск 2023");

        // Создание панели для размещения информации об университете и факультете
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(3, 1));
        headerPanel.add(universityLabel);
        headerPanel.add(facultyLabel);
        headerPanel.add(departmentLabel);

        // Создание панели для размещения картинки
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon imageIcon = new ImageIcon("D:\\Артем\\Универ\\Java_Практика\\Картинки\\BankDepositImage.png"); // Замените "your_image_path.jpg" на путь к вашей картинке
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
        imagePanel.setBorder(BorderFactory.createEmptyBorder(6, 100, 0, 0)); // Отступ слева

        // Создание панели для размещения информации об авторе и преподавателе
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        JPanel infoGridPanel = new JPanel();
        infoGridPanel.setLayout(new GridLayout(2, 1));

        infoGridPanel.add(authorLabel);
        infoGridPanel.add(teacherLabel);

        infoPanel.add(infoGridPanel, BorderLayout.CENTER);
        infoPanel.add(imagePanel, BorderLayout.WEST);

        // Создайние панель для размещения кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton startButton = new JButton("Запустить программу");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Запустите выполнение функционала программы
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new CountDepositGUI();
                    }
                });
            }
        });

        JButton authorInfoButton = new JButton("Информация об авторе");
        authorInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Создать объект класса ImageIcon
                ImageIcon authorIcon = new ImageIcon("D:\\Артем\\МоиФото\\MyPhoto.jpg");

                // Создать панель для размещения картинки и надписи
                JPanel panel = new JPanel(new GridBagLayout());

                // Создать надпись
                String text = "<html>Автор: Шепелев Артем<br>Email: artyomshpl@gmail.com</html>";
                JLabel label = new JLabel(text);

                // Оформить надпись
                label.setFont(new Font("Times New Roman", Font.BOLD, 16));
                label.setForeground(Color.BLACK);

                // Создать объект GridBagConstraints для настройки размещения элементов
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.insets = new Insets(10, 0, 10, 0);

                // Добавить картинку на панель
                gbc.gridx = 0;
                gbc.gridy = 0;
                panel.add(new JLabel(authorIcon), gbc);

                // Добавить надпись на панель
                gbc.gridx = 0;
                gbc.gridy = 1;
                panel.add(label, gbc);

                // Отобразить диалоговое окно
                JOptionPane.showMessageDialog(null, panel, "Информация об авторе", JOptionPane.INFORMATION_MESSAGE);
            }

        });

        JButton programInfoButton = new JButton("Информация о программе");
        programInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Отобразите окно с краткой информацией о программе
                JOptionPane.showMessageDialog(null, "Программа выполняет расчет банковского депозита исходя из начальных вложений, процентной ставки и срока депозита.", "Информация о программе", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(authorInfoButton);
        buttonPanel.add(programInfoButton);

        // Создание основной панели и добавление на нее всех компонентов
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Создание окна и установка основной панели в качестве содержимого окна
        JFrame frame = new JFrame("Start Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Метод для запуска GUI стартового окна программы.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StartWindowGUI();
            }
        });
    }
}
