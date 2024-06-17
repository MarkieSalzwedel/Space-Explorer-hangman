import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CharacterReveal extends JLabel{

    private static final Color BLUE_LIGHT = new Color(239, 249, 252);
    private static final Color BLUE_DARK = new Color(55, 52, 92);

    public CharacterReveal(String text){
        super();
        setText(setLabelText(text)); //all dashes
        setTextColor(BLUE_DARK);
        setBackground(BLUE_LIGHT);
        setFontSize(58);
        setOpaque(true);
    }

    //set initial label text (start of game is all dashes)
    public String setLabelText (String text){
        StringBuilder myLabelText = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            myLabelText.append("_ ");
        }
        String labelText = myLabelText.toString();

        return labelText;
    }

    //set text color
    public void setTextColor(Color color) {
        setForeground(color);
    }

    //set background color
    public void setBackground(Color color) {
        setOpaque(true);
        super.setBackground(color);
    }

    //set font size
    public void setFontSize(int size) {
        setFont(getFont().deriveFont((float) size));
    }

    public void updateReveal(Word word){
        String myWord = word.getWord();
        int wordLen = myWord.length();
        List<Character> Revealedletters = word.getRevealedLetters();

        StringBuilder labelText = new StringBuilder();
        for(int i = 0; i < wordLen; i++){
            char letter = myWord.charAt(i);
            //if letter has already been revealed
            if (Revealedletters.contains(letter)){
                labelText.append(letter).append(" ");
            }
            //if not revealed yet, then dash
            else {
                labelText.append("_ ");
            }
        }

        //set text
        setText(labelText.toString());

    }

}
