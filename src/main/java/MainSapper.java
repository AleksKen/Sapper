import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class MainSapper extends JFrame {

    private Game game;
    private JPanel panel;
    private JLabel label;
    private final int Cols = 9;
    private final int Rows = 9;
    private final int ImageSize = 50;
    private final int Bombs = 10;

    public static void main(String[] args) {
        new MainSapper();
    }

    private MainSapper() {
        game = new Game(Cols, Rows, Bombs);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel("Welcome!");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoords()) {
                    g.drawImage((Image) game.getBox(coord).image, coord.x * ImageSize, coord.y * ImageSize, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / ImageSize;
                int y = e.getY() / ImageSize;
                Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1)
                    game.pressLeftButton(coord);
                if (e.getButton() == MouseEvent.BUTTON3)
                    game.pressRightBotton(coord);
                if (e.getButton() == MouseEvent.BUTTON2)
                    game.start();
                label.setText(getMessage());

                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(Ranges.getSize().x * ImageSize, Ranges.getSize().y * ImageSize));
        add(panel);
    }

    private String getMessage() {
        switch (game.getState()) {
            case played:
                return "Think twice!";
            case bombed:
                return "You lose!";
            case winner:
                return "Congratulations!";
            default:
                return "";
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sapper");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for (Box box : Box.values())
            box.image = getImage(box.name());
    }

    private Image getImage(String name) {
        String fileName = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

}