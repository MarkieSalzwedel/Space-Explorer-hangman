import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class CustomButtonUI extends BasicButtonUI {
    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color backgroundColor = new Color(55, 52, 92);
    private static final Color hoverColor = new Color(85, 82, 122);
    private static final Color pressedColor = new Color(25, 22, 62);
    private static final Color disabledColor = new Color(218, 228, 242);

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(BLUE_LIGHT);
        button.setFont(new Font("Playfair Display", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(150, 40));
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();

        //sets pressed, hover, and background color of button depending on user interaction
        if (model.isPressed()) {
            g.setColor(pressedColor);
        } else if (model.isRollover()) {
            g.setColor(hoverColor);
        } else {
            g.setColor(backgroundColor);
        }
        g.fillRect(0, 0, button.getWidth(), button.getHeight());

        //if disabled
        if (!model.isEnabled()) {
            g.setColor(disabledColor);
        } else {
            g.setColor(BLUE_LIGHT);
        }

        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(button.getText());
        int stringHeight = fm.getAscent();
        g.drawString(button.getText(), (button.getWidth() - stringWidth) / 2, (button.getHeight() + stringHeight) / 2 - fm.getDescent());
    }
}