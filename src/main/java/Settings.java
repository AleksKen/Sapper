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
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelLinesCount1 = new JLabel("Усложни себе жизнь");
        JLabel jLabelLinesCount2 = new JLabel("(по умолчанию 5 бомб): ");
        add(jLabelLinesCount1);
        add(jLabelLinesCount2);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonSetSettings = new JButton("Стартуем!");
        add(jButtonSetSettings);
        setVisible(true);

        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainSapper sapper = MainSapper.getInstance();
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    sapper.Bombs = 5;
                }
                else {
                    try {
                        sapper.Bombs = Integer.parseInt(jTextFieldLinesCount.getText());
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Необходимо вводить целое число! Вам будет предложена игра по умолчанию");
                    }
                }
                sapper.startNewGame();
                gameSettingsForm.setVisible(false);
            }
        });
    }
}