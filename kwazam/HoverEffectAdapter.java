import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HoverEffectAdapter extends MouseAdapter {
    private final JButton button;
    private final Color hoverColor;
    private final Color defaultColor;

    // Constructor to initialize button and colors
    public HoverEffectAdapter(JButton button, Color hoverColor, Color defaultColor) {
        this.button = button;
        this.hoverColor = hoverColor;
        this.defaultColor = defaultColor;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(hoverColor); // Set hover color
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(defaultColor); // Reset to default color
    }
}
