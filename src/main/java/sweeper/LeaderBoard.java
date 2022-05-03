package sweeper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeaderBoard extends JFrame {

    public LeaderBoard() {
        setTitle("Топ причин почему ты крут");
        setBounds(500, 300, 500, 220);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        try (BufferedReader reader = new BufferedReader(new FileReader("leaderBoard"))) {
            String line;
            while (((line = reader.readLine()) != null) && (!(line.isEmpty()))) {
                JLabel jLabel = new JLabel("    " + line);
                add(jLabel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
}


