import java.util.ArrayList;
import java.util.List;

public class Word {

    private String word;
    private List<Character> revealedLetters;

    //constructor
    public Word(String word){
        this.word = word;
        this.revealedLetters = new ArrayList<>();
    }

    //get word
    public String getWord(){
        return word;
    }

    //add letter to revealed list
    public void revealLetter(char letter){
        // if letter is not already in revealed list, add it
        if (!revealedLetters.contains(letter)){
            revealedLetters.add(letter);
        }
    }

    //get revealed letters list
    public List<Character> getRevealedLetters(){
        return revealedLetters;
    }

}
