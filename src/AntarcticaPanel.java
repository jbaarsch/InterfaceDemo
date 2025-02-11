import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AntarcticaPanel extends JPanel {

    private JButton marchButton;
    private JButton penguinButton;
    private ArrayList<Penguin> penguins;


    public AntarcticaPanel() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 450));

        penguins = new ArrayList<>();

        marchButton = new JButton("March");
        MarchListener marchListener = new MarchListener();
        marchButton.addActionListener(marchListener);
        this.add(marchButton);

        penguinButton = new JButton("Add Penguin");
        PenguinListener penguinListener = new PenguinListener();
        penguinButton.addActionListener(penguinListener);
        this.add(penguinButton);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Penguin p : penguins) {
            p.paintIcon(this, g, 0, 0);
        }

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

    private class PenguinListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            penguins.add(new Penguin(800, 150));
        }
    }






}
