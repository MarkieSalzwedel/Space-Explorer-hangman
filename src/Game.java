import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Character> guessedLetters; //list of player-guessed letters
    private List<String> guessedWords; //list of player-guessed words
    private Word word;
    private Player player;
    private boolean win;
    private String output;
    private ShipPanel shipPanel;

    //constructor
    public Game(String word){
        this.word = new Word(word);
        this.player = new Player();
        this.guessedLetters = new ArrayList<>();
        this.guessedWords = new ArrayList<>();
        this.win = false;
        this.output = "";
    }

    //reference ship panel
    public void setShipPanel(ShipPanel shipPanel){
        this.shipPanel = shipPanel;
    }

    //evaluate player guess
    public void guess(String guessInput){
        String chosenWord = this.word.getWord(); // get word from Word class

        //if user is guessing a word
        if (guessInput.length() > 1){

            //if word has already been guessed
            if (guessedWords.contains(guessInput)){
                setOutput("'" + guessInput + "' has already been guessed. Try again.");
            }
            //else if not
            else {
                //if user guess is the word
                if (guessInput.equals(chosenWord)){
                    //add each letter of the chosen word to the revealed letter list
                    for (int i = 0; i < chosenWord.length(); i++) {
                        this.word.revealLetter(chosenWord.charAt(i));
                    }
                    win = true;
                    setOutput("Congratulations! You guessed the word!");
                }
                //if user word guess is wrong
                else{
                    setOutput("'" + guessInput + "' is NOT the word...");
                    guessedWords.add(guessInput);
                    this.player.lifeLoss();
                    shipPanel.updateShipImage();
                }

            }

        } else { //else if player is guessing a character/letter
            //convert single-character guess to char
            char guessedChar = guessInput.charAt(0);

            //if letter has already been guessed
            if (guessedLetters.contains(guessedChar)){
                setOutput("'" + guessedChar + "' has already been guessed. Try again.");
            }
            //if letter hasn't already been guessed
            else{
                //if user guess is in word, add to guessed list
                if(chosenWord.contains(guessInput)){
                    this.word.revealLetter(guessedChar);
                    setOutput("'" + guessedChar + "' is in the word!");
                }
                //if user guess is NOT in word, player loses a life & image is updated
                else{
                    this.player.lifeLoss();
                    shipPanel.updateShipImage();
                    setOutput("'" + guessedChar + "' is NOT in the word...");
                }

                this.guessedLetters.add(guessedChar);
            }
        }

        //update image & reveal label
        if (shipPanel != null) {
            shipPanel.updateShipImage();
            shipPanel.updateRevealLabel();
        }

    }

    public boolean aWin(){
        String chosenWord = this.word.getWord(); //get word
        int wordLen = chosenWord.length(); //get word length
        List<Character> revealedLetters = word.getRevealedLetters(); // get revealed letters list

        //check if bool value is true, return true to winning
        if (win){
            return true;
        }

        //check each individual character in word to see if all letters have been revealed
        for(int i = 0; i < wordLen; i++){
            char letter =  chosenWord.charAt(i);
            //if letter has not been revealed, not a win yet
            if(!revealedLetters.contains(letter)){
                return false;
            }
        }
        return true;
    }

    //player loses
    public boolean aLoss(){
        return player.get_lives() <= 0;
    }

    //set output for label
    public void setOutput(String output){
        this.output = output;
    }

    //get output for label
    public String getOutput(){
        return output;
    }

    //get word
    public String getWord(){
        return word.getWord();
    }

    //get Word Object
    public Word getWordObject() { return this.word;}

    //get Player lives
    public int getLives(){
        return player.get_lives();
    }
}
