import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomTextFieldUI extends JTextField {

    private static final Color BLUE_DARK = new Color(55, 52, 92);
    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private Color textColor;
    private Font textFont;

    public CustomTextFieldUI() {
        super();
        this.textColor = BLUE_DARK;
        this.textFont = new Font("Playfair Display", Font.PLAIN, 18);
        setForeground(textColor);
        setFont(textFont);
        setBackground(BLUE_LIGHT);
        setTextColor(BLUE_DARK);
        setHorizontalAlignment(JTextField.CENTER);
        setBorder(BorderFactory.createLineBorder(BLUE_LIGHT)); // Example border
        setPreferredSize(new Dimension(100, 30)); // Example preferred size
        setOpaque(true); // Ensure text field is not opaque by default
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //set text color dynamically
    public void setTextColor(Color color) {
        this.textColor = color;
        setForeground(textColor);
    }

    public void setTextFont(Font font) {
        this.textFont = font;
        setFont(textFont);
    }

    public String getInputText(){
        return getText();
    }

}