import javax.swing.*;
import java.awt.*;

public interface MoveableIcon extends Icon {
    public void move(int dX, int dY);
}
