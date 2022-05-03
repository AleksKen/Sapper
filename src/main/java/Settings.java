import sweeper.LeaderBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    Settings gameSettingsForm = this;

    public static void main(String[] args) {
        Settings gameForm = new Settings();
    }

    public Settings() {
        setTitle("Что тут думать?!");
        setBounds(600, 300, 210, 210);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelBombsCount1 = new JLabel("Усложни себе жизнь");
        JLabel jLabelBombsCount2 = new JLabel("(по умолчанию 5 бомб): ");
        add(jLabelBombsCount1);
        add(jLabelBombsCount2);
        JTextField jTextFieldBombssCount = new JTextField();
        jTextFieldBombssCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldBombssCount);
        JLabel jLabelLinesCount1 = new JLabel("Укажите длину стороны");
        JLabel jLabelLinesCount2 = new JLabel("(по умолчанию 6): ");
        add(jLabelLinesCount1);
        add(jLabelLinesCount2);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonLeader = new JButton("Книга рекордов");
        add(jButtonLeader);
        JButton jButtonSetSettings = new JButton("Стартуем!");
        add(jButtonSetSettings);
        setVisible(true);


        jButtonLeader.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderBoard leaderBoard = new LeaderBoard();
            }
        });

        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainSapper sapper = MainSapper.getInstance();
                if (jTextFieldBombssCount.getText().isEmpty()) {
                    sapper.Bombs = 5;
                } else {
                    try {
                        sapper.Bombs = Integer.parseInt(jTextFieldBombssCount.getText());
                    } catch (NumberFormatException ex) {
                        System.out.println("Необходимо вводить целое число! Вам будет предложена игра по умолчанию");
                    }
                }
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    sapper.Rows = 11;
                    sapper.Cols = 11;
                } else {
                    try {
                        sapper.Cols = Integer.parseInt(jTextFieldLinesCount.getText()) * 2 - 1;
                        sapper.Rows = Integer.parseInt(jTextFieldLinesCount.getText()) * 2 - 1;
                    } catch (NumberFormatException ex) {
                        System.out.println("Необходимо вводить целое число! Вам будет предложена игра по умолчанию");
                    }
                    sapper.startNewGame();
                    gameSettingsForm.setVisible(false);
                }
            }
        });
    }
}