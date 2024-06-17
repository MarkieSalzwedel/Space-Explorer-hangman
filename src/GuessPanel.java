import javax.swing.*;
import java.awt.*;

public class GuessPanel extends JPanel {

    //colors
    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color BLUE_DARK = new Color(55, 52, 92);

    //custom components
    private JPanel mainContainer;
    private JPanel container;
    private CustomLabelUI myLabel1;
    private CustomTextFieldUI myTextField;
    private EnterButton enterButton;
    private CustomLabelUI infoLabel;

    public GuessPanel(Game game) {
        setPreferredSize(new Dimension(500, 175));
        setBackground(BLUE_DARK);

        //main container
        mainContainer = new JPanel();
        mainContainer.setPreferredSize(new Dimension(500, 175));
        mainContainer.setBackground(BLUE_DARK);
        mainContainer.setLayout(new GridLayout(4, 1));

        //mini container
        container = new JPanel();
        container.setBackground(BLUE_DARK);

        //generic label
        myLabel1 = new CustomLabelUI("ENTER YOUR GUESS");
        myLabel1.setBackground(BLUE_DARK);
        myLabel1.setTextColor(BLUE_LIGHT);

        //text field
        myTextField = new CustomTextFieldUI();
        myTextField.setPreferredSize(new Dimension(245, 40));

        //info label
        infoLabel = new CustomLabelUI("messages will appear here!");
        infoLabel.setBackground(BLUE_DARK);
        infoLabel.setFontSize(16);

        //button
        enterButton = new EnterButton("ENTER", myTextField, infoLabel, game);
        enterButton.setPreferredSize(new Dimension(100, 40));

        //mini container
        container.add(myTextField);
        container.add(enterButton);

        //add to main container
        mainContainer.add(myLabel1);
        mainContainer.add(container);
        mainContainer.add(infoLabel);

        //add container to the main GuessPanel
        add(mainContainer);
    }
}
