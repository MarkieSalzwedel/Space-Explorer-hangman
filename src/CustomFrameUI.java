import javax.swing.*;
import java.awt.*;

public class CustomFrameUI extends JFrame {

    private static final Color BLUE_DARK = new Color(55, 52, 92);

    public CustomFrameUI(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 640);
        setResizable(false);
        setLayout(new FlowLayout());

        //setting custom settings
        JPanel contentPane = new JPanel();
        contentPane.setBackground(BLUE_DARK);
        contentPane.setOpaque(true);
        setContentPane(contentPane);
    }

}
