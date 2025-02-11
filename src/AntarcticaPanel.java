import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;

public class AntarcticaPanel extends JPanel {

    private JButton marchButton;
    private JButton penguinButton;
    private ArrayList<Penguin> penguins;
    private ArrayList<CircleIcon> snowflakes;


    public AntarcticaPanel() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 450));

        penguins = new ArrayList<>();
        snowflakes = new ArrayList<>();



        marchButton = new JButton("March");
        //MarchListener marchListener = new MarchListener();
        marchButton.addActionListener(
               (getMover((int)(Math.random() * 4) + 1)));
        this.add(marchButton);

        penguinButton = new JButton("Add Penguin");
        Timer t = new Timer(1, (ActionEvent e) -> {
            snowflakes.add(new CircleIcon(
                    new Color((int)(Math.random() * 256),
                            (int)(Math.random() * 256),
                            (int)(Math.random() * 256))
                    ,
                    (int)(Math.random() * 750) + 5,
                    0, 20, 20));
            for (CircleIcon snowflake : snowflakes) {
                snowflake.move(0, 5);
            }
            for (Penguin penguin : penguins) {
                penguin.move(-3, 0);
            }
            revalidate();
            repaint();

        });
        penguinButton.addActionListener(e -> {
            penguins.add(new Penguin(800, 150));
            revalidate();
            repaint();
        }
        );
        this.add(penguinButton);
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        for (Penguin p : penguins) {
            p.paintIcon(this, g, 0, 0);
        }
        for (CircleIcon snowflake : snowflakes) {
            snowflake.paintIcon(this, g, 0, 0);
        }

    }

    // 1 moves to the left
    // 2 moves up
    // 3 moves down
    // 4 moves to the right.
    private ActionListener getMover(int moverType) {
        switch(moverType) {
            case 1: return e -> {for (Penguin p : penguins) {
                p.move(-10,0);
                revalidate();
                repaint();
            }};
            case 2: return e -> {for (Penguin p : penguins) {
                p.move(0,-10);
                revalidate();
                repaint();
            }};
            case 3: return e -> {for (Penguin p : penguins) {
                p.move(0,10);
                revalidate();
                repaint();
            }};
            case 4: return e -> {for (Penguin p : penguins) {
                p.move(10,0);
                revalidate();
                repaint();
            }};
        }
        return null;
    }

    private class MarchListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Penguin p : penguins) {
                p.move(-10,0);
                revalidate();
                repaint();
            }
        }
    }






}
