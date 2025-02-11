import javax.swing.*;
import java.awt.*;

public class CircleIcon implements MoveableIcon {
    Color color;
    int x, y, height, width;

    public CircleIcon(Color color, int x, int y, int height, int width) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval(this.x, this.y, width, height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    @Override
    public void move(int dX, int dY) {
        x+= dX;
        y+= dY;
    }
}
