import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

/*
* Main Driver class for Space Explorer (hangman) w/ GUI
* Markie N. Salzwedel
*/

public class Main {
    public static void main(String[] args) {

        Color BLUE_DARK = new Color(55, 52, 92);

        //read file
        String fileName = "words_list.txt";

        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            System.err.println("Error: File '" + fileName + "' not found or could not be opened.");
            System.exit(1); //Exit if file not found
        }

        ReadWordFile wordFile = new ReadWordFile();
        wordFile.readFile(inputStream);

        //randomly chosen word
        String randWord = wordFile.chooseRandWord(); //get randomly chosen word
        //System.out.println("Your random word: " + randWord); //debugging

        //main driver
        Game game = new Game(randWord);

        //all panels added to the MAIN FRAME
        CustomFrameUI frame = new CustomFrameUI("✧ Space Explorer (hangman) GUI!");

        //spacing panels
        JPanel spacingPanel1 = new JPanel();
        spacingPanel1.setBackground(BLUE_DARK);
        spacingPanel1.setPreferredSize(new Dimension(510, 25));

        JPanel spacingPanel2 = new JPanel();
        spacingPanel2.setBackground(BLUE_DARK);
        spacingPanel2.setPreferredSize(new Dimension(510, 15));

        //ship panel
        ShipPanel ship_panel = new ShipPanel(game);
        game.setShipPanel(ship_panel);

        //guessing panel
        GuessPanel guess_panel = new GuessPanel(game);

        //adding all panels to MAIN FRAME
        frame.add(spacingPanel1);
        frame.add(ship_panel);
        frame.add(spacingPanel2);
        frame.add(guess_panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}