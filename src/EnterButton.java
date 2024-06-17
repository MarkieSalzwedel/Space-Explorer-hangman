import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterButton extends JButton implements ActionListener{

    private CustomTextFieldUI textField;
    private CustomLabelUI infoLabel;
    private Game game;
    public EnterButton(String text, CustomTextFieldUI textField, CustomLabelUI infoLabel, Game game) {
        super(text);
        this.textField = textField;
        this.infoLabel = infoLabel;
        this.game = game;
        setUI(new CustomButtonUI());
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //make all user input lowercase
        String userInput = textField.getInputText().toLowerCase();

        //evaluate guess
        game.guess(userInput);

        infoLabel.setText(game.getOutput());
        //System.out.println("Info Label: " + game.getOutput()); //debugging

        //if a win, else if a loss
        if (game.aWin()) {
            infoLabel.setText("Congratulations! You guessed the word!");
            disableInput();
        } else if (game.aLoss()) {
            infoLabel.setText("Game Over! The word was '" + game.getWord() + "'");
            disableInput();
        }
    }

    //disable button from accepting any more input (game over)
    private void disableInput(){
        textField.setEnabled(false);
        this.setEnabled(false);
    }

}
