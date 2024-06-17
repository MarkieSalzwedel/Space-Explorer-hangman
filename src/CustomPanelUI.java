import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.PanelUI;
import java.awt.*;

public class CustomPanelUI extends PanelUI {

    private static final CustomPanelUI INSTANCE = new CustomPanelUI();
    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color BLUE_DARK = new Color(55, 52, 92);

    public static ComponentUI createUI(JComponent c) {
        return INSTANCE;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(BLUE_LIGHT);
        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25);

        super.paint(g, c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.setOpaque(false);
        c.setBackground(BLUE_LIGHT); //Set background color
        c.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        c.setBorder(new RoundedBorder(BLUE_DARK, 30, 7));
    }

    private static class RoundedBorder extends AbstractBorder {
        private final Color color;
        private final int radius;
        private final int thickness;

        //create a round border (around panel)
        public RoundedBorder(Color color, int radius, int thickness) {
            this.color = color;
            this.radius = radius;
            this.thickness = thickness;
        }

        //paint border
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.setStroke(new BasicStroke(thickness));
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        //returns insets
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        //gets border insets
        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = insets.top = insets.bottom = thickness;
            return insets;
        }
    }
}

