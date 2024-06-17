import javax.swing.*;
import java.awt.*;

public class ShipPanel extends JPanel {

    //colors
    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color BLUE_DARK = new Color(55, 52, 92);

    //Custom components
    private JPanel borderPanel;
    private JPanel shipPanel;
    private LivesRocket livesRocket;
    private CharacterReveal charaReveal;
    private Game game;

    public ShipPanel(Game game) {
        //customize
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(560, 380));
        setBackground(BLUE_DARK);

        this.game = game;
        this.livesRocket = new LivesRocket();

        //border panel
        borderPanel = new JPanel();
        borderPanel.setUI(new CustomPanelUI());
        borderPanel.setPreferredSize(new Dimension(560, 380));
        borderPanel.setLayout(new GridBagLayout());

        //panel holding ship pngs
        shipPanel = new JPanel();
        shipPanel.setUI(new CustomPanelUI());
        shipPanel.setPreferredSize(new Dimension(510, 345));

        //ship icon
        JLabel label = new JLabel(livesRocket.getImage());

        //label that reveals characters
        charaReveal = new CharacterReveal(game.getWord());

        //center shipPanel within borderPanel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        //add to ship panel & add ship panel to border panel
        shipPanel.add(label);
        shipPanel.add(charaReveal);
        borderPanel.add(shipPanel, gbc);

        //add borderPanel to the main ShipPanel
        add(borderPanel);
    }

    //updates image as player loses lives
    public void updateShipImage(){
        livesRocket.updateImage(game.getLives());
        JLabel label = (JLabel) shipPanel.getComponent(0);
        label.setIcon(livesRocket.getImage());
    }

    //updates label as player guesses correctly
    public void updateRevealLabel(){
        charaReveal.updateReveal(game.getWordObject());
    }
}
