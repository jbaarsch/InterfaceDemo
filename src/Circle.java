import java.awt.*;

public class Circle implements MoveableIcon, Comparable<Circle>{
    int x;
    int y;
    int width;
    int height;

    public Circle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.fillOval(x, y, width, height);
    }

    public void move(int dX, int dY){
        x+=dX;
        y+=dY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        paint(g);
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
    public int compareTo(Circle o) {
        return (width * height) - (o.width * o.width);
    }
}
