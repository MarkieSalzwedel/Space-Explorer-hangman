import javax.swing.*;
import java.awt.*;

public class CustomLabelUI extends JLabel {

    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color BLUE_DARK = new Color(55, 52, 92);

    //constructor
    public CustomLabelUI(String text) {
        super(text);
        setForeground(BLUE_LIGHT);
        setBackground(BLUE_DARK);
        setFont(new Font("Playfair Display", Font.PLAIN, 24));
        setHorizontalAlignment(SwingConstants.CENTER);
        setOpaque(true);
    }

    //set text color
    public void setTextColor(Color color) {
        setForeground(color);
    }

    //set text font
    public void setTextFont(Font font) {
        setFont(font);
    }

    //set font size
    public void setFontSize(int size){
        setFont(new Font("Playfair Display", Font.PLAIN, size));
    }
}
