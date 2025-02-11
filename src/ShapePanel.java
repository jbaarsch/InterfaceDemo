import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel {
    final int boxDX = 10;
    final int boxDY = 10;
    final int circDX = -10;
    final int circDY = -10;
    Box box;
    Circle circle;
    MoveableIcon[] movers;
    JButton button;
    public ShapePanel() {
        movers = new MoveableIcon[3];
         movers[0] = new Box(250, 250, 30, 30);
         movers[1] = new Circle(250, 250, 30, 30);
         movers[2] = new Penguin(100, 100);
        this.setPreferredSize(new Dimension(500, 500));

        button = new JButton("MOVE SHAPE");
        button.addActionListener( e-> {
            for (MoveableIcon mover : movers){
                mover.move((int)(Math.random()*20) - 10, (int)(Math.random()*20) - 10);
            }


            repaint();
            revalidate();


        });
        add(button);

    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (MoveableIcon mover : movers){
            mover.paintIcon(this, g, 0,0);
        }


    }






}
