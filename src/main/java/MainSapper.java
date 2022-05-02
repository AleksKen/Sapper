import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class MainSapper extends JFrame {
    private static MainSapper instance = null;
    private Game game;
    private JPanel panel;
    private JLabel label;
    private final int Cols = 7;
    private final int Rows = 7;
    private final int ImageH = 60;
    private final int ImageL = 50;
    static int Bombs = 5;

    private MainSapper() {
        game = new Game(Cols, Rows, Bombs);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initFrame();
    }

    public static synchronized MainSapper getInstance(){
        if (instance == null)
            instance = new MainSapper();
        return instance;
    }

    void startNewGame() {
        repaint();
        game = new Game(Cols, Rows, Bombs);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initFrame();
        setVisible(true);
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
                    if (coord.y % 2 == 0)
                        g.drawImage((Image) game.getBox(coord).image, coord.x * ImageL + (ImageL / 2), coord.y * ImageH / 4 * 3, this);
                    else
                        g.drawImage((Image) game.getBox(coord).image, coord.x * ImageL, coord.y * ImageH / 4 * 3, this);
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int y = e.getY() / (ImageH / 4 * 3);
                int x;
                if (y % 2 == 0)
                    x = (e.getX() - (ImageL / 2)) / ImageL;
                else
                    x = e.getX() / ImageL;

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

        panel.setPreferredSize(new Dimension(350, 330));
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