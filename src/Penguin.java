import javax.swing.*;
import java.awt.*;

public class Penguin implements MoveableIcon{
    private int x, y;
    private ImageIcon icon;

    public Penguin(){
        new Penguin(0, 0);
    }

    public Penguin(int x, int y){
        icon = new ImageIcon("marching_penguin.jpg");
        placePenguin(x, y);
    }

    public void placePenguin(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int dX, int dY) {
        x+= dX;
        y+= dY;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c, g, this.x, this.y);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight();
    }






}
